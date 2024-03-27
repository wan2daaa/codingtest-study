package 알고리즘.이진탐색;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {

  public boolean searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
    if (dataList.size() == 1 && searchItem.equals(dataList.get(0))) {
      return true;
    }
    if (dataList.size() == 1 && searchItem != dataList.get(0)) {
      return false;
    }
    if (dataList.isEmpty()) {
      return false;
    }

    int medium = dataList.size() / 2;

    if (searchItem == dataList.get(medium)) {
      return true;
    }
    else {
      if (searchItem < dataList.get(medium)) {
        return searchFunc(new ArrayList<>(dataList.subList(0, medium)), searchItem);
      } else {
        return searchFunc(new ArrayList<>(dataList.subList(medium, dataList.size())), searchItem);
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<Integer> testData = new ArrayList<>();

    for (int i = 0; i < 100; i++) {
      testData.add((int) (Math.random() * 100));
    }

    Collections.sort(testData);

    System.out.println("testData = " + testData);

    BinarySearch binarySearch = new BinarySearch();

    boolean isExists = binarySearch.searchFunc(testData, 4);

    System.out.println("isExists = " + isExists);


  }

}
