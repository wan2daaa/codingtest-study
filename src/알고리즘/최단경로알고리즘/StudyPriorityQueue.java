package 알고리즘.최단경로알고리즘;

import java.util.PriorityQueue;

class StudyPriorityQueue {

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
    PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
    priorityQueue.add(new Edge(2, "A"));
    priorityQueue.add(new Edge(5, "B"));
    priorityQueue.offer(new Edge(1, "C"));
    priorityQueue.offer(new Edge(7, "D"));

    System.out.println(priorityQueue);
    //[vertex: C, distance: 1, vertex: B, distance: 5, vertex: A, distance: 2, vertex: D, distance: 7]

    Edge peek = priorityQueue.peek(); // 삭제는 안함
    System.out.println("peek = " + peek); //peek = vertex: C, distance: 1

    Edge polledEdge = priorityQueue.poll(); // 자료도 꺼내고 삭제!
    System.out.println("polledEdge = " + polledEdge); //polledEdge = vertex: C, distance: 1

    System.out.println("priorityQueue = " + priorityQueue);
    // [vertex: A, distance: 2, vertex: B, distance: 5, vertex: D, distance: 7]

    int size = priorityQueue.size();
    System.out.println("size = " + size); //size = 3


  }

}
