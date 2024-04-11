package 알고리즘.백트래킹_전략;

import java.util.ArrayList;

class NQueen {

  public void dfsFunction(Integer N, Integer currentRow, ArrayList<Integer> currentCandidate) {

    if (currentRow == N) { //전체 행을 다 돌았다면, index 기준 다 돌았다는 뜻
      System.out.println(currentCandidate);
    }

    for (int index = 0; index < N; index++) {
      if (this.isAvailable(currentCandidate, index)) { // 위치가 적합하다는 뜻
        currentCandidate.add(index);
        this.dfsFunction(N, currentRow + 1, currentCandidate);
        //가지치기
        currentCandidate.removeLast();
      }

    }
  }

  public boolean isAvailable(ArrayList<Integer> candidate, Integer currentCol) {
    Integer currentRow = candidate.size();

    for (int index = 0; index < currentRow; index++) {
      if (
          (candidate.get(index) == currentCol) ||
          ((Math.abs(candidate.get(index) - currentCol)) == currentRow - index)
      ) {
        return false;
      }
    }
    return true;
  }


  public static void main(String[] args) {
    NQueen nQueen = new NQueen();

    nQueen.dfsFunction(4, 0, new ArrayList<>());

  }


}
