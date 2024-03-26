package 알고리즘.재귀용법;

import java.util.ArrayList;

public class RecursiveCall {

  public int factorial(int n) {
    if (n == 1) {
      return n;
    } else {
      return n * factorial(n - 1);
    }
  }

  public int factorialAdd(ArrayList<Integer> dataList) {
    if (dataList.size() <= 0) {
      return 0;
    } else {
      return dataList.get(0) + this.factorialAdd(
          new ArrayList<>(dataList.subList(1, dataList.size())));
    }
  }


  public static void main(String[] args) {
    RecursiveCall recursiveCall = new RecursiveCall();

    int factorial = recursiveCall.factorial(5);
    System.out.println("factorial = " + factorial);

    ArrayList<Integer> numberList = new ArrayList<>();
    for (int i = 0; i < 11; i++) {
      numberList.add(i);
    }

    int addNum = recursiveCall.factorialAdd(numberList);
    System.out.println("addNum = " + addNum);


  }
}
