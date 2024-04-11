package 알고리즘.최소신장트리.프림;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class Prim {

  public ArrayList<Edge> primFunc(String startNode, ArrayList<Edge> edges) {
    Edge currentEdge, poppedEdge, adjacentEdgeNode;
    ArrayList<Edge> currentEdgeList, candidateEdgeList, adjacentEdgesNodes;
    PriorityQueue<Edge> priorityQueue;

    ArrayList<String> connectedNodes = new ArrayList<>();
    ArrayList<Edge> mst = new ArrayList<>();
    HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<>();

    for (int index = 0; index < edges.size(); index++) {
      currentEdge = edges.get(index);
      if (!adjacentEdges.containsKey(currentEdge.node1)) {
        adjacentEdges.put(currentEdge.node1, new ArrayList<Edge>());
      }
      if (!adjacentEdges.containsKey(currentEdge.node2)) {
        adjacentEdges.put(currentEdge.node2, new ArrayList<Edge>());
      }
    }

    for (int index = 0; index < edges.size(); index++) {
      currentEdge = edges.get(index);
      currentEdgeList = adjacentEdges.get(currentEdge.node1);
      currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node1, currentEdge.node2));
      currentEdgeList = adjacentEdges.get(currentEdge.node2);
      currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node2, currentEdge.node1));
    }

    connectedNodes.add(startNode);
    candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<Edge>());
    priorityQueue = new PriorityQueue<Edge>();

    for (int index = 0; index < candidateEdgeList.size(); index++) {
      priorityQueue.add(candidateEdgeList.get(index));
    }

    // 핵심 로직
    while (priorityQueue.size() > 0) {
      poppedEdge = priorityQueue.poll();
      if (!connectedNodes.contains(poppedEdge.node2)) { // 사이클이 안생기는 경우
        // 해당 edge를 mst에 추가
        connectedNodes.add(poppedEdge.node2);
        mst.add(new Edge(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));

        adjacentEdgesNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<Edge>());

        for (int index = 0; index < adjacentEdgesNodes.size(); index++) {
          adjacentEdgeNode = adjacentEdgesNodes.get(index);

          if (!connectedNodes.contains(adjacentEdgeNode.node2)) {
            priorityQueue.add(adjacentEdgeNode);
          }
        }
      }
    }

    return mst;
  }


  public static void main(String[] args) {
    ArrayList<Edge> myEdges = new ArrayList<>();
    addEdgeData(myEdges);

    Prim prim = new Prim();

    ArrayList<Edge> primFunc = prim.primFunc("A", myEdges);
    System.out.println("primFunc = " + primFunc);

  }


  private static class Edge implements Comparable<Edge> {

    public int weight;
    public String node1;
    public String node2;

    public Edge(int weight, String node1, String node2) {
      this.weight = weight;
      this.node1 = node1;
      this.node2 = node2;
    }

    @Override
    public int compareTo(Edge edge) {
      return this.weight - edge.weight;
    }

    @Override
    public String toString() {
      return
          "\nweight=" + weight +
          ", node1='" + node1 + '\'' +
          ", node2='" + node2 + '\'';
    }
  }


  private static void addEdgeData(ArrayList<Edge> myEdges) {
    myEdges.add(new Edge(7, "A", "B"));
    myEdges.add(new Edge(5, "A", "D"));
    myEdges.add(new Edge(8, "B", "C"));
    myEdges.add(new Edge(9, "B", "D"));
    myEdges.add(new Edge(7, "D", "E"));
    myEdges.add(new Edge(5, "C", "E"));
    myEdges.add(new Edge(7, "B", "E"));
    myEdges.add(new Edge(6, "D", "F"));
    myEdges.add(new Edge(8, "E", "F"));
    myEdges.add(new Edge(9, "E", "G"));
    myEdges.add(new Edge(11, "F", "G"));
  }

}
