import java.io.*;
import java.util.*;

public class Main {

    private static void solve() {

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

    public static class myPair {
        int x;
        int y;

        myPair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}