package 알고리즘.순차탐색;

import java.util.ArrayList;

public class SequentialSearch {

  public int searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
    for (int index = 0; index < dataList.size(); index++) {
      if (dataList.get(index) == searchItem) {
        return index;
      }
    }
    return -1;
  }


  public static void main(String[] args) {
    ArrayList<Integer> testData = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      testData.add((int) (Math.random() * 100));
    }

    System.out.println("testData = " + testData);

    SequentialSearch sequentialSearch = new SequentialSearch();

    int searchIndex = sequentialSearch.searchFunc(testData, 55);
    System.out.println("searchIndex = " + searchIndex);

  }

}
