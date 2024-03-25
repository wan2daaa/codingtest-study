package 알고리즘.버블정렬;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {

  public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
    for (int index = 0; index < dataList.size() - 1; index++) {
      boolean isSwap = false;

      for (int index2 = 0; index2 < dataList.size() - 1 - index ; index2++) {
        if (dataList.get(index2) > dataList.get(index2 + 1)) {
          Collections.swap(dataList, index2, index2 + 1);
          isSwap = true;
        }
      }

      if (!isSwap) break;
    }
    return dataList;
  }

  static class Main {

    public static void main(String[] args) {

      ArrayList<Integer> list = new ArrayList<>();

      for (int i = 0; i < 100; i++) {
        list.add((int) (Math.random() % 100));
      }

      BubbleSort bubbleSort = new BubbleSort();

      ArrayList<Integer> sort = bubbleSort.sort(list);
      System.out.println(sort);
    }
  }

}
