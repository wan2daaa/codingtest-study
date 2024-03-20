import java.util.ArrayList;
import java.util.List;

public class Test {

  public static void main(String[] args) {
    String[] testList = new String[5];

    testList[0] = "1";
    testList[1] = "1";
    testList[2] = "1";

    System.out.println(testList.length);
    ArrayList<Integer> list = new ArrayList<>();

    list.add(3);

    System.out.println(list.size());

    List<String> stringList = new ArrayList<>();

    stringList.add("a");
    stringList.add("a");

    System.out.println(stringList.size());

    System.out.println(stringList.get(0).indexOf("0"));


  }

}
