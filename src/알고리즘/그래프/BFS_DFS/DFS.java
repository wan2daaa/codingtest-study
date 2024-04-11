package 알고리즘.그래프.BFS_DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DFS {

  public ArrayList<String> dfsFunc(HashMap<String, ArrayList<String>> graph, String startNode) {
    ArrayList<String> visited = new ArrayList<>();
    ArrayList<String> needVisit = new ArrayList<>();

    needVisit.add(startNode);

    while (!needVisit.isEmpty()) {
      String node = needVisit.remove(needVisit.size()-1);

      if (!visited.contains(node)) {
        visited.add(node);
        needVisit.addAll(graph.get(node));
      }

    }

    return visited; // 방문한 순서
  }


  public static void main(String[] args) {
    HashMap<String, ArrayList<String>> graph = new HashMap<>();
    graph.put("A", new ArrayList<>(List.of("B", "C")));
    graph.put("B", new ArrayList<>(List.of("B", "D")));
    graph.put("C", new ArrayList<>(List.of("A", "G", "H", "I")));
    graph.put("D", new ArrayList<>(List.of("B", "E", "F")));
    graph.put("E", new ArrayList<>(List.of("D")));
    graph.put("F", new ArrayList<>(List.of("D")));
    graph.put("G", new ArrayList<>(List.of("C")));
    graph.put("H", new ArrayList<>(List.of("C")));
    graph.put("I", new ArrayList<>(List.of("C", "J")));
    graph.put("J", new ArrayList<>(List.of("I")));

    DFS bfs = new DFS();
    ArrayList<String> dfsSearchList = bfs.dfsFunc(graph, "A");

    System.out.println("dfsSearchList = " + dfsSearchList);
  }

}
