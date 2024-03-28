# 너비 우선 탐색 (Breadth-First Search)

## BFS 와 DFS 란? 

- 대표적인 그래프 탐색 알고리즘 
  - 너비 우선 탐색 : 정점들과 같은 레벨이 있는 노드들( 형제 노드들)을 먼저 탐색 하는 방식
  - 깊이 우선 탐색 : 정점의 자식들을 먼저 탐색하는 방식


![bfs-dfs-diff.gif](bfs-dfs-diff.gif)

## 시간복잡도 
- 일반적인 BFS 시간 복잡도 
  - 노드수 : V
  - 간선수 : E
    - O(V+E)

## JAVA로 그래프를 표현하는 방법 

- Java Collection Framework 에서 제공하는 HashMap 과 ArrayList 를 활용해서 그래프를 표현할 수 있음 

### 그래프를 자료구조로 작성하기 

- HashMap 을 사용하여, 그래프를 자료구조로 작성할 수 있음
- 아래 코드는 무방향 그래프 예시 코드 

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


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
  
  
}

```