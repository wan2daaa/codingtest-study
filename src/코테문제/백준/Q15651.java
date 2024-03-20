package 코테문제.백준;

import java.io.*;
import java.util.*;

//TODO. 브루트포스 어려워서 자료구조 공부후 다시 진행


public class Q15651 {
    static StringBuilder sb = new StringBuilder();

    static void input() {
      FastReader scan = new FastReader();
      N = scan.nextInt();
      M = scan.nextInt();
      selected = new int[M + 1];
    }

    static int N, M;
    static int[] selected;

    // Recurrence Function (재귀함수)
    // 만약 M개를 전부 고르면 => 조건에 맞는 탐색을 한 가지 성공한 것 !
    // 아직 M 개를 고르지 않았으면 => k 번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도
    static void rec_func(int k) {
      if (k == M + 1) { //다 골랐을때
        //selected[1...M] 배열이 새롭게 탐색된 결과
        for (int i =1; i<=M;i++) sb.append(selected[i]).append(' ');
        sb.append('\n');
      } else {
        for (int cand = 1; cand <= N; cand++) {
          selected[k] = cand;
          //k+1번 ~ M번을 모두 탐색하는 일을 해야하는 상황
          rec_func(k+1);
          selected[k] = 0;
        }
      }
    }

    public static void main(String[] args) {
      input();

      rec_func(1);
      System.out.println(sb);
    }

    static class FastReader {
      BufferedReader br;
      StringTokenizer st;

      public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
      }

      public FastReader(String s) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(new File(s)));
      }

      String next() {
        while (st == null || !st.hasMoreElements()) {
          try {
            st = new StringTokenizer(br.readLine());
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        return st.nextToken();
      }

      int nextInt() {
        return Integer.parseInt(next());
      }

      long nextLong() {
        return Long.parseLong(next());
      }

      double nextDouble() {
        return Double.parseDouble(next());
      }

      String nextLine() {
        String str = "";
        try {
          str = br.readLine();
        } catch (IOException e) {
          e.printStackTrace();
        }
        return str;
      }
    }

}
