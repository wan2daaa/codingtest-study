import java.util.ArrayList;
import java.util.List;

public class Test {

  public static void main(String[] args) {

    /**
     * 배열
     */
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

    /**
     * 큐
     */

    class QueueImpl<T>{
      private ArrayList<T> queue = new ArrayList<T>();

      public void enqueue(T item) {
        queue.add(item);
      }

      public T dequeue() {
        if (queue.isEmpty()) {
          return null;
        }

//        T temp = queue.get(0);
//        queue.remove(0);
//        return temp;

        return queue.remove(0);
      }

      public boolean isEmpty() {
        return queue.isEmpty();
      }

    }

    QueueImpl<Integer> queue = new QueueImpl<>();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    System.out.println("queue remove fir"+queue.dequeue());
    System.out.println("queue remove sec"+queue.dequeue());
    System.out.println("queue remove third"+queue.dequeue());

  }

}
