package 알고리즘.최단경로알고리즘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class Dijkstra {

  public HashMap<String, Integer> jijkstraFunc(HashMap<String, ArrayList<Edge>> graph,
      String start) {

    //initialize
    HashMap<String, Integer> distances = new HashMap<>();
    Edge edgeNode, adjacentNode;
    int currentDistance, weight, distance ;
    String currenctNode, adjacent;
    ArrayList<Edge> nodeList;

    for (String key : graph.keySet()) {
      distances.put(key, Integer.MAX_VALUE);
    }
    distances.put(start, 0);

    PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
    priorityQueue.add(new Edge(distances.get(start), start));

    // 알고리즘 작성
    while (priorityQueue.size() > 0) {

      edgeNode = priorityQueue.poll();
      currentDistance = edgeNode.distance;
      currenctNode = edgeNode.vertex;


      if (distances.get(currenctNode) < currentDistance) {
        continue;
      }

      nodeList = graph.get(currenctNode);

      for (Edge edge : nodeList) {
        adjacentNode = edge;
        adjacent = adjacentNode.vertex;
        weight = adjacentNode.distance;

        distance = currentDistance + weight;

        if (distance < distances.get(adjacent)) {
          distances.put(adjacent, distance);
          priorityQueue.add(new Edge(distance, adjacent));
        }

      }
    }
    return distances;
  }



  static class Edge implements Comparable<Edge> {

    public int distance;
    public String vertex;

    public Edge(int distance, String vertex) {
      this.distance = distance;
      this.vertex = vertex;
    }

    public String toString() {
      return "vertex: " + this.vertex + ", distance: " + this.distance;
    }

    @Override
    public int compareTo(Edge edge) {
      return this.distance - edge.distance;
    }
  }

  public static void main(String[] args) {
    HashMap<String, ArrayList<Edge>> graph = new HashMap<>();
    graph.put("A",
        new ArrayList<>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
    graph.put("B", new ArrayList<>());
    graph.put("C", new ArrayList<>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
    graph.put("D", new ArrayList<>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
    graph.put("E", new ArrayList<>(Arrays.asList(new Edge(1, "F"))));
    graph.put("F", new ArrayList<>(Arrays.asList(new Edge(5, "A"))));

    /**
     * 참고 : Hashmap에 들어 있는 모든 Key 가져오기
     */
//    for (String key : graph.keySet()) {
//      System.out.println("key = " + key);
//      System.out.println("graph.get(key) = " + graph.get(key));
//    }

    Dijkstra dijkstra = new Dijkstra();
    HashMap<String, Integer> shortDistance = dijkstra.jijkstraFunc(graph, "A");
    System.out.println("shortDistance = " + shortDistance);

  }

}
