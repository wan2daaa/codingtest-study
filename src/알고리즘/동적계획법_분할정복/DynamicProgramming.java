package 알고리즘.동적계획법_분할정복;

public class DynamicProgramming {

  public int fibonacciWithFactorial(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("0보다 낮은 수를 입력할 수 없습니다.");
    }
    if (n <= 1) {
      return n;
    }

    return fibonacciWithFactorial(n - 1) + fibonacciWithFactorial(n - 2);
  }

  public int fibonacciWithDP(int n) {
    Integer[] cache = new Integer[n + 1];
    cache[0] = 0;
    cache[1] = 1;

    for (int index = 2; index < n + 1; index++) {
      cache[index] = cache[index - 1] + cache[index - 2];
    }

    return cache[n];
  }


  public static void main(String[] args) {
    DynamicProgramming dp = new DynamicProgramming();

    int fibonacci = dp.fibonacciWithFactorial(9);
    System.out.println("fibonacci = " + fibonacci);
  }
}
