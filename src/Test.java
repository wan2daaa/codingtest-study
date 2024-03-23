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

    class QueueImpl<T> {

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

    System.out.println("queue remove fir" + queue.dequeue());
    System.out.println("queue remove sec" + queue.dequeue());
    System.out.println("queue remove third" + queue.dequeue());

    /**
     * LinkedList
     */

    class SingleLinkedList<T> {

      public Node<T> head = null;

      public class Node<T> {

        T data;
        Node<T> next = null;

        public Node(T data) {
          this.data = data;
        }
      }

      public void addNode(T data) {
        if (head == null) {
          head = new Node<T>(data);
        } else {
          Node<T> node = this.head;
          while (node.next != null) {
            node = node.next;
          }

          node.next = new Node<>(data);
        }
      }

      public void printAll() {
        if (head != null) {
          Node<T> node = this.head;
          System.out.println(node.data);

          while (node.next != null) {
            node = node.next;
            System.out.println(node.data);
          }
        }
      }

      public Node<T> search(T data) {
        if (this.head == null) {
          return null;
        } else {
          Node<T> node = this.head;

          while (node != null) {
            if (node.data == data) {
              return node;
            } else {
              node = node.next;
            }
          }

          return null;
        }
      }

      public void addNodeInside(T data, T isData) {
        Node<T> searchedNode = this.search(isData);

        if (searchedNode == null) {
          this.addNode(isData);
        } else {
          Node<T> nextNode = searchedNode.next;

          searchedNode.next = new Node<>(data);
          searchedNode.next.next = nextNode;
        }
      }

      public boolean delete(T isData) {
        if (this.head == null) {
          return false;
        } else {
          Node<T> node = this.head;

          if (node.data == isData) {
            this.head = this.head.next;
            return true;
          } else {
            while (node.next != null) {

              if (node.next.data == isData) {
                node.next = node.next.next;
                return true;
              }
              node = node.next;
            }
            return false;
          }
        }
      }

    }

    SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();

    linkedList.addNode(1);
    linkedList.addNode(2);
    linkedList.addNode(3);

    linkedList.printAll();

    linkedList.addNodeInside(2, 10);

    linkedList.printAll();

    linkedList.delete(2);

    linkedList.printAll();

  }

}
