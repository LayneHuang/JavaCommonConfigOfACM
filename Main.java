import java.io.*;
import java.util.*;

public class Main {

    private static void solve() {
        int n = in.nextInt();
        int k = in.nextInt();

        ArrayList<MyPair> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int ti = in.nextInt();
            int bi = in.nextInt();
            list.add(new MyPair(ti, bi));
        }

        list.sort((o1, o2) -> Integer.compare(o2.y, o1.y));

        Queue<Integer> que = new PriorityQueue<>(n);

        long ans = 0;
        long sum = 0;
        int idx = 0;
        for (int i = 0; i < n; ++i) {
            while (que.size() < k && idx < n) {
                que.add()
                idx++;
            }
        }
    }

    // -----------------------  Common Func ------------------------

    public static void main(String[] args) {
        while (in.hasNext()) {
            solve();
        }
        out.close();
    }

    static class MyScanner {
        private Scanner scanner;

        MyScanner() {
            this.scanner = new Scanner(System.in);
        }

        int nextInt() {
            return scanner.nextInt();
        }

        long nextLong() {
            return scanner.nextLong();
        }

        String next() {
            return scanner.next();
        }

        String nextLine() {
            return scanner.nextLine();
        }

        boolean hasNext() {
            return scanner.hasNext();
        }

        Integer[] nextIntegerArray(int len) {
            Integer[] result = new Integer[len];
            for (int i = 0; i < len; ++i) {
                result[i] = nextInt();
            }
            return result;
        }

        ArrayList<Integer> nextIntegerArrayList(int len) {
            return new ArrayList<>(Arrays.asList(nextIntegerArray(len)));
        }

        String[] nextStringArray(int len) {
            String[] result = new String[len];
            for (int i = 0; i < len; ++i) {
                result[i] = next();
            }
            return result;
        }

        ArrayList<String> nextStringArrayList(int len) {
            return new ArrayList<>(Arrays.asList(nextStringArray(len)));
        }
    }

    private static MyScanner in = new MyScanner();
    private static PrintStream out = System.out;

    private static <T> void commonPrintLine(List<T> list) {
        int i = 0, len = list.size();
        for (T item : list) {
            out.print(item);
            out.print((++i) < len ? ' ' : '\n');
        }
    }

    private static <T> void commonPrintLine(ArrayList<T> list) {
        int i = 0, len = list.size();
        for (T item : list) {
            out.print(item);
            out.print((++i) < len ? ' ' : '\n');
        }
    }

    public static class MyPair {
        int x;
        int y;

        MyPair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}