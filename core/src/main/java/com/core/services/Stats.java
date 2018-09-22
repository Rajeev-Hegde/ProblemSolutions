package com.core.services;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Stats {
        public static class StatisticsAggregatorImpl implements StatisticsAggregator {

            private Map<String,Double> symbolVsPrice = new ConcurrentHashMap<>();
            private Map<String, Integer> symbolVsTickCount = new ConcurrentHashMap<>();


            @Override
            public void putNewPrice(String symbol, double price) {
                // YOUR CODE HERE
                double finalPrice = price;
                if (this.symbolVsPrice.containsKey(symbol)) {
                    finalPrice = this.symbolVsPrice.get(symbol) + price;
                }
                this.symbolVsPrice.put(symbol,finalPrice);
                this.symbolVsTickCount.putIfAbsent(symbol,0);
                this.symbolVsTickCount.put(symbol,this.symbolVsTickCount.get(symbol)+1);
            }

            @Override
            public double getAveragePrice(String symbol) {
                // YOUR CODE HERE
                return this.symbolVsPrice.getOrDefault(symbol,0.0)/this.symbolVsTickCount.getOrDefault(symbol,1);
            }

            @Override
            public int getTickCount(String symbol) {
                // YOUR CODE HERE
                return this.symbolVsTickCount.getOrDefault(symbol, 0);
            }
        }

        ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

        public interface StatisticsAggregator {
            // This is an input. Make note of this price.
            public void putNewPrice(String symbol, double price);

            // Get the average price
            public double getAveragePrice(String symbol);

            // Get the total number of prices recorded
            public int getTickCount(String symbol);
        }

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                final StatisticsAggregator stats = new StatisticsAggregatorImpl();
                final Set<String> symbols = new TreeSet<>();

                String line = scanner.nextLine();
                String[] inputs = line.split(",");
                int threads = Integer.parseInt(inputs[0]);
                ExecutorService pool = Executors.newFixedThreadPool(threads);
                for (int i = 1; i < inputs.length; ++i) {
                    String[] tokens = inputs[i].split(" ");
                    final String symbol = tokens[0];
                    symbols.add(symbol);
                    final double price = Double.parseDouble(tokens[1]);
                    pool.submit(new Runnable() {
                        @Override
                        public void run() {
                            stats.putNewPrice(symbol, price);
                        }
                    });

                }
                pool.shutdown();
                try {
                    pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (String symbol : symbols) {
                    System.out.println(String.format("%s %.4f %d", symbol,
                            stats.getAveragePrice(symbol),
                            stats.getTickCount(symbol)));
                }
            }
            scanner.close();

        }
}