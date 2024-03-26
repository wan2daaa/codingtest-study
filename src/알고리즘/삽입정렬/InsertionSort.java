package 알고리즘.삽입정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertionSort {

  public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
    for (int index = 0; index < dataList.size() - 1; index++) {
      for (int index2 = index + 1; index2 > 0 ; index2--) {
        if (dataList.get(index2) < dataList.get(index2 - 1)) {

          System.out.printf("%s < %s",
              dataList.get(index2) , dataList.get(index2 - 1));
          System.out.println();
          Collections.swap(dataList, index2, index2-1);
        }else {
          break;
        }
      }
    }
    return dataList;
  }


  public static void main(String[] args) {
    InsertionSort insertionSort = new InsertionSort();

    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      list.add((int) (Math.random() * 100));
    }
    System.out.println("list = " + list);

    List<Integer> sort = insertionSort.sort(list);

    System.out.println("sort = " + sort);
  }
}
