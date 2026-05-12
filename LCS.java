import java.util.*;

public class LCS {
    public static void main(String[] args) {
        String s1 = "MUHAMMAD ARSAL"; // Example name - replace with yours
        String s2 = "ETAOINSHR";

        solveLCS(s1.toUpperCase(), s2);
    }

    public static void solveLCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        displayTable(s1, s2, dp);

        StringBuilder lcsString = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcsString.append(s1.charAt(i - 1));
                i--; j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.println("\nLCS Length: " + dp[m][n]);
        System.out.println("LCS Result: " + lcsString.reverse().toString());
    }

    public static void displayTable(String s1, String s2, int[][] dp) {
        System.out.print("    ");
        for (int j = 0; j < s2.length(); j++) {
            System.out.print(s2.charAt(j) + " ");
        }
        System.out.println();

        for (int i = 1; i <= s1.length(); i++) {
            System.out.print(s1.charAt(i - 1) + " | ");
            for (int j = 1; j <= s2.length(); j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}