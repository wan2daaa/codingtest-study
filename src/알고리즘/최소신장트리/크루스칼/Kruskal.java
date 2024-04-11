package 알고리즘.최소신장트리.크루스칼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Kruskal {

  HashMap<String, String> parent = new HashMap<>();
  HashMap<String, Integer> rank = new HashMap<>();

  private String find(String node) {
    // path compression 기법
    if (parent.get(node) != node) {
      parent.put(node, find(parent.get(node)));
    }
    return parent.get(node);
  }

  //사이클이 안 생긴다고 가정
  private void union(String nodeV, String nodeU) {
    String root1 = find(nodeV);
    String root2 = find(nodeU);

    //Union-by-rank
    if (rank.get(root1) > rank.get(root2)) {
      parent.put(root2, root1);
    } else {
      parent.put(root1, root2);
      if (rank.get(root1) == rank.get(root2)) {
        rank.put(root2, rank.get(root2) + 1);
      }
    }
  }


  private void makeSet(String node) {
    this.parent.put(node, node);
    this.rank.put(node, 0);
  }

  public ArrayList<Edge> kruskalFunc(ArrayList<String> vetices, ArrayList<Edge> edges) {
    ArrayList<Edge> mst = new ArrayList<>();
    Edge currentEdge;

    //Initialization
    for (String vetice : vetices) {
      makeSet(vetice);
    }

    // 간선 weight 기반, sorting
    Collections.sort(edges);

    for (int index = 0; index < edges.size(); index++) {
      currentEdge = edges.get(index);
      if (find(currentEdge.nodeV) != find(currentEdge.nodeU)) {
        union(currentEdge.nodeV, currentEdge.nodeU);
        mst.add(currentEdge);
      }
    }

    return mst;
  }

  public static void main(String[] args) {
    ArrayList<String> vertices = new ArrayList<String>(
        Arrays.asList("A", "B", "C", "D", "E", "F", "G"));

    ArrayList<Edge> edges = new ArrayList<>();
    addEdgeDatas(edges);

    Kruskal kruskal = new Kruskal();
    ArrayList<Edge> kruskalFunc = kruskal.kruskalFunc(vertices, edges);
    System.out.println("kruskalFunc = " + kruskalFunc);

  }

  private static class Edge implements Comparable<Edge> {

    public int weight;
    public String nodeV;
    public String nodeU;

    public Edge(int weight, String nodeV, String nodeU) {
      this.weight = weight;
      this.nodeV = nodeV;
      this.nodeU = nodeU;
    }

    @Override
    public String toString() {
      return
         "\n" +"weight=" + weight +
          ", nodeV='" + nodeV + '\'' +
          ", nodeU='" + nodeU + '\'' ;
    }

    @Override
    public int compareTo(Edge edge) {
      return this.weight - edge.weight;
    }

  }

  private static void addEdgeDatas(ArrayList<Edge> edges) {
    edges.add(new Edge(7, "A", "B"));
    edges.add(new Edge(5, "A", "D"));
    edges.add(new Edge(7, "B", "A"));
    edges.add(new Edge(8, "B", "C"));
    edges.add(new Edge(9, "B", "D"));
    edges.add(new Edge(7, "B", "E"));
    edges.add(new Edge(8, "C", "B"));
    edges.add(new Edge(5, "C", "E"));
    edges.add(new Edge(5, "D", "A"));
    edges.add(new Edge(9, "D", "B"));
    edges.add(new Edge(7, "D", "E"));
    edges.add(new Edge(6, "D", "F"));
    edges.add(new Edge(7, "E", "B"));
    edges.add(new Edge(5, "E", "C"));
    edges.add(new Edge(7, "E", "D"));
    edges.add(new Edge(8, "E", "F"));
    edges.add(new Edge(9, "E", "G"));
    edges.add(new Edge(6, "F", "D"));
    edges.add(new Edge(8, "F", "E"));
    edges.add(new Edge(11, "F", "G"));
    edges.add(new Edge(9, "G", "E"));
    edges.add(new Edge(11, "G", "F"));
  }
}
