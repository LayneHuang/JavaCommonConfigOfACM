import java.io.*;
import java.util.*;

public class Main {

    private static void solve() {
        int n = in.nextInt();
        String s = in.next();
        String ns = "";

        for (int i = 0; i < n; ++i) {
            if (i == 0 || (s.charAt(i) != s.charAt(i - 1))) {
                ns += s.charAt(i);
            }
        }

        int[][][] dp = new int[n + 10][n + 10][30];
        n = ns.length();

        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= n; ++j) {
                for (int k = 0; k < 26; ++k) {
                    dp[i][j][k] = n;
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            dp[i][i][ns.charAt(i) - 'a'] = 1;
        }

        for (int len = 2; len <= n; ++len) {
            for (int beg = 0; beg + len - 1 < n; ++beg) {
                int ed = beg + len - 1;
                int mx = dp[beg][ed][0];
                for (int k = 0; k < 26; ++k) {
                    mx = Math.min(mx, dp[beg][ed][k]);
                }
                int c = 0;
                int d = 0;
                if (beg > 0) {
                    c = ns.charAt(beg - 1) - 'a';
                }
                if (ed + 1 < n) {
                    d = ns.charAt(ed + 1) - 'a';
                }
                if (beg > 0) {
                    dp[beg - 1][ed][c] = Math.min(dp[beg - 1][ed][c], mx + 1);
                }
                if (ed < n - 1) {
                    dp[beg][ed + 1][d] = Math.min(dp[beg][ed + 1][d], mx + 1);
                }
                if (beg > 0 && ed < n - 1 && c == d) {
                    dp[beg - 1][ed + 1][c] = Math.min(dp[beg - 1][ed + 1][c], mx + 1);
                }
                for (int k = 0; k < 26; ++k) {
                    if (beg > 0) {
                        dp[beg - 1][ed][k] = Math.min(dp[beg - 1][ed][k], dp[beg][ed][k]);
                    }
                    if (ed < n - 1) {
                        dp[beg][ed + 1][k] = Math.min(dp[beg][ed + 1][k], dp[beg][ed][k]);
                    }
                    if (beg > 0 && ed < n - 1 && c == d) {
                        dp[beg - 1][ed + 1][k] = Math.min(dp[beg - 1][ed + 1][k], dp[beg][ed][k]);
                    }
                }
            }
        }

        out.println(dp[0][1][0]);
        int ans = n;
        for (int k = 0; k < 26; ++k) {
            ans = Math.min(ans, dp[0][n - 1][k]);
        }
        out.println(ans);
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