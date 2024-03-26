package 알고리즘.병합정렬;

import java.util.ArrayList;

public class MergeSort {


  public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
    ArrayList<Integer> mergedList = new ArrayList<>();
    int leftPoint = 0;
    int rightPoint = 0;

    // CASE 1: left/right 둘 다 있을 때
    while (leftList.size() > leftPoint && rightList.size() > rightPoint) {
      if (leftList.get(leftPoint) > rightList.get(rightPoint)) {
        mergedList.add(rightList.get(rightPoint));
        rightPoint++;
      } else {
        mergedList.add(leftList.get(leftPoint));
        leftPoint++;
      }
    }

    // CASE 2: right 데이터가 없을 때
    while (leftList.size() > leftPoint) {
      mergedList.add(leftList.get(leftPoint));
      leftPoint++;
    }

    // CASE 3: left 데이터가 없을 때
    while (rightList.size() > rightPoint) {
      mergedList.add(rightList.get(rightPoint));
      rightPoint++;
    }

    return mergedList;
  }

  public ArrayList<Integer> mergeSplitFunction(ArrayList<Integer> dataList) {
    if (dataList.size() <= 1) {
      return dataList;
    }

    int medium = dataList.size() / 2;

    ArrayList<Integer> leftArr = new ArrayList<>();
    ArrayList<Integer> rightArr = new ArrayList<>();

    leftArr = mergeSplitFunction(new ArrayList<>(
        dataList.subList(0, medium))); // 0 부터 medium -1 (0 <= x <medium) 인덱스 번호까지 해당 배열 아이템을 분리
    rightArr = mergeSplitFunction(new ArrayList<>(
        dataList.subList(medium, dataList.size()))); // medium <= x < dataList.size()

    return mergeFunc(leftArr, rightArr);
  }

  public static void main(String[] args) {
    ArrayList<Integer> testData = new ArrayList<>();

    for (int i = 0; i < 1000; i++) {
      testData.add((int) (Math.random() * 1000));
    }

    MergeSort mergeSort = new MergeSort();

    ArrayList<Integer> mergedData = mergeSort.mergeSplitFunction(testData);

    System.out.println("mergedData = " + mergedData);
  }

}
