package 알고리즘.선택정렬;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {

  public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
    for (int cycle = 0; cycle < dataList.size() - 1; cycle++) {
      int minData = dataList.get(cycle);
      int minIndex = cycle;
      for (int index = cycle; index < dataList.size() - 1; index++) {
        if (minData > dataList.get(index)) {
          minData = dataList.get(index);
          minIndex = index;
        }
        if (minIndex != cycle) {
          Collections.swap(dataList, cycle, minIndex);
        }

      }
    }
    return dataList;
  }


  // 개선
  public ArrayList<Integer> sort2(ArrayList<Integer> dataList) {
    int minIndex;
    for (int cycle = 0; cycle < dataList.size() - 1;
        cycle++) { //사이클이 돌면서 사이클에 해당하는 인덱스에 제일 작은 값이 위치 하면됨
      minIndex = cycle;
      for (int index = cycle + 1; index < dataList.size() - 1; index++) {//minIndex로 첫 번째 비교값을 넣어줘서 cycle + 1

        if (dataList.get(minIndex) > dataList.get(index)) {
          minIndex = index;
        }
      }
      Collections.swap(dataList, cycle, minIndex);
    }
    return dataList;
  }


  public static void main(String[] args) {
    SelectionSort selectionSort = new SelectionSort();

    ArrayList<Integer> dataList = new ArrayList<>();

    for (int i = 0; i < 100; i++) {
      dataList.add((int) (Math.random() * 100));
    }

    ArrayList<Integer> sort = selectionSort.sort2(dataList);
    System.out.println("sort = " + sort);

  }
}
