package concepts.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Dijkstras {


    private int getMinDistanceVertex(Map<Integer, Integer> vertexVsShortestDistanceFromSource, Boolean[] visitedVertices) {
        AtomicInteger min =  new AtomicInteger(Integer.MAX_VALUE);
        AtomicInteger vertexIndex= new AtomicInteger( -1);
        vertexVsShortestDistanceFromSource.forEach((key,val)-> {
            if(!visitedVertices[key] && val < min.get()){
                min.set(vertexVsShortestDistanceFromSource.get(key));
                vertexIndex.set(key);
            }
        });

        return vertexIndex.get();
    }

    public Map<Integer, Integer> getVertexVsShortestDistanceFromSource(int graph[][], Integer sourceVertex, Integer totalVertices) {
        Map<Integer, Integer> vertexVsShortestDistanceFromSource = new HashMap<>();


        Boolean visitedVertices[] = new Boolean[totalVertices];
        for (int i = 0; i < totalVertices; i++) {
            vertexVsShortestDistanceFromSource.putIfAbsent(i, Integer.MAX_VALUE);
            visitedVertices[i] = false;
        }

        vertexVsShortestDistanceFromSource.put(sourceVertex, 0);
        //visitedVertices[sourceVertex]=true;

        for (int i = 0; i < totalVertices; i++) {
            int minDistanceVertex = getMinDistanceVertex(vertexVsShortestDistanceFromSource, visitedVertices);
            visitedVertices[i] = true;

            for (int j = 0; j < totalVertices; j++) {

                if (!visitedVertices[j] && graph[minDistanceVertex][j] != 0 &&
                        vertexVsShortestDistanceFromSource.get(minDistanceVertex) != Integer.MAX_VALUE &&
                        vertexVsShortestDistanceFromSource.get(minDistanceVertex) + graph[minDistanceVertex][j]
                                < vertexVsShortestDistanceFromSource.get(j))
                    vertexVsShortestDistanceFromSource.put(
                            j,
                            vertexVsShortestDistanceFromSource.get(minDistanceVertex) + graph[minDistanceVertex][j]);

            }


        }
        return vertexVsShortestDistanceFromSource;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        Dijkstras dijkstras = new Dijkstras();
        System.out.println(dijkstras.getVertexVsShortestDistanceFromSource(graph, 0,9));
    }
}
