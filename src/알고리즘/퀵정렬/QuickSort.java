package 알고리즘.퀵정렬;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

  public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
    if (dataList.size() <= 1) {
      return dataList;
    }

    int pivot = dataList.get(0);

    ArrayList<Integer> leftArr = new ArrayList<>();
    ArrayList<Integer> rightArr = new ArrayList<>();

    for (int index = 1; index < dataList.size(); index++) {
      if (dataList.get(index) > pivot) {
        rightArr.add(dataList.get(index));
      } else {
        leftArr.add(dataList.get(index));
      }
    }

    ArrayList<Integer> mergedArr = new ArrayList<>();
    mergedArr.addAll(sort(leftArr));
    mergedArr.add(pivot);
    mergedArr.addAll(sort(rightArr));

    return mergedArr;
  }

  public static void main(String[] args) {
    ArrayList<Integer> testData = new ArrayList<>();

    for (int i = 0; i < 100; i++) {
      testData.add((int) (Math.random() * 100));
    }
      QuickSort quickSort = new QuickSort();
      ArrayList<Integer> sortedData = quickSort.sort(testData);

      System.out.println("sortedData = " + sortedData);
  }



}

class Split {
  public void splitFunc(ArrayList<Integer> dataList) {
    if (dataList.size() <= 1) {
      return;
    }
    int pivot = dataList.get(0);

    ArrayList<Integer> leftArr = new ArrayList<>();
    ArrayList<Integer> rightArr = new ArrayList<>();

    for (int index = 1; index < dataList.size(); index++) {
      if (dataList.get(index) > pivot) {
        rightArr.add(dataList.get(index));
      } else {
        leftArr.add(dataList.get(index));
      }
    }

    ArrayList<Integer> mergedArr = new ArrayList<>();

    mergedArr.addAll(leftArr);
    mergedArr.add(pivot);
    mergedArr.addAll(rightArr);

    System.out.println("leftArr = " + leftArr);
    System.out.println("pivot = " + pivot);
    System.out.println("rightArr = " + rightArr);
    System.out.println("mergedArr = " + mergedArr);
  }

  public static void main(String[] args) {
    ArrayList<Integer> array = new ArrayList<>(List.of(4, 1, 2, 5, 7));
    Split split = new Split();
    split.splitFunc(array);


  }
}