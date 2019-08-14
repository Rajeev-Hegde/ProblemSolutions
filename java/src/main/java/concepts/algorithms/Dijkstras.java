package concepts.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Dijkstras {


    int getMinDistanceVertex(Map<Integer, Integer> vertexVsShortestDistanceFromSource, Boolean[] visitedVertices) {
        AtomicInteger min =  new AtomicInteger(Integer.MAX_VALUE);
        int vertexIndex=-1;
        vertexVsShortestDistanceFromSource.forEach((key,val)-> {
            if(!visitedVertices[key]&& val <= min.get()){
                min.set(vertexVsShortestDistanceFromSource.get(key));
            }
        });

        return vertexIndex;
    }

    public Map<Integer, Integer> getVertexVsShortestDistanceFromSource(int graph[][], Integer sourceVertex, Integer totalVertices) {
        Map<Integer, Integer> vertexVsShortestDistanceFromSource = new HashMap<>();


        Boolean visitedVertices[] = new Boolean[totalVertices];
        for (int i = 0; i < totalVertices; i++) {
            vertexVsShortestDistanceFromSource.putIfAbsent(i, Integer.MAX_VALUE);
            visitedVertices[i] = false;
        }

        vertexVsShortestDistanceFromSource.put(sourceVertex, 0);

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

    }
}
