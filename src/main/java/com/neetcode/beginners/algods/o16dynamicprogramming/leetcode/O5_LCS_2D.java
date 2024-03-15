package com.neetcode.beginners.algods.o16dynamicprogramming.leetcode;

public class O5_LCS_2D {

    public int longestCommonSubsequence(String text1, String text2) {
        // return bruteForce(text1, text2, 0, 0);

        // int[][] cache = new int[text1.length()][text2.length()];
        // for(int[] row : cache) {
        // This is very important step because in this problem 0 indicates there is no
        // matching characters.
        // Arrays.fill(row, -1);
        // }

        // return memoization(text1, text2, 0, 0, cache);
        // return dynamicProgrammingTopDown(text1, text2);
        // This is a better way to handle loops for such kind of questions
        return dynamicProgrammingTopDownRetrieveString(text1, text2);
    }

    // Time limit exceeded
    // For a given 2 strings you have following options
    // option 1: if first character in both the strings match, then we proceed to
    // the next character in both the string.
    // option 2: if first character in both the string does not match, you have
    // following choices
    // 2.1 go to next character in the first string and compare with the second
    // string
    // 2.2 go to next character in the second string and compare with the first
    // string.
    // str1 = a b c d e f
    // str2 = d a b c
    // str[1] != str[2] then str1 = abcdef and str2 = abc OR str1 = bcdef and str2 =
    // dabc
    public static int bruteForce(String text1, String text2, int charIndexText1, int charIndexText2) {
        int m = text1.length();
        int n = text2.length();

        if (charIndexText1 >= m || charIndexText2 >= n)
            return 0;

        if (text1.charAt(charIndexText1) == text2.charAt(charIndexText2)) {
            return 1 + bruteForce(text1, text2, charIndexText1 + 1, charIndexText2 + 1);
        } else {
            return Math.max(bruteForce(text1, text2, charIndexText1, charIndexText2 + 1),
                    bruteForce(text1, text2, charIndexText1 + 1, charIndexText2));
        }
    }

    // memoization
    public static int memoization(String text1, String text2, int charIndexText1, int charIndexText2, int[][] cache) {
        int m = text1.length();
        int n = text2.length();

        if (charIndexText1 >= m || charIndexText2 >= n) {
            return 0;
        }
        if (cache[charIndexText1][charIndexText2] > -1) {
            return cache[charIndexText1][charIndexText2];
        }

        if (text1.charAt(charIndexText1) == text2.charAt(charIndexText2)) {
            cache[charIndexText1][charIndexText2] = 1
                    + memoization(text1, text2, charIndexText1 + 1, charIndexText2 + 1, cache);
        } else {
            cache[charIndexText1][charIndexText2] = Math.max(
                    memoization(text1, text2, charIndexText1, charIndexText2 + 1, cache),
                    memoization(text1, text2, charIndexText1 + 1, charIndexText2, cache));
        }

        return cache[charIndexText1][charIndexText2];
    }

    public static int dynamicProgrammingTopDown(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] lookup = new int[m][n];
        if (text1.charAt(0) == text2.charAt(0)) {
            lookup[0][0] = 1;
        }

        // Fill up first row comparing 1 character from text2 with characters from text1
        for (int j = 1; j < n; j++) {
            if (text2.charAt(j) == text1.charAt(0)) {
                lookup[0][j] = lookup[0][j] + 1;
            } else {
                lookup[0][j] = lookup[0][j - 1];
            }
        }

        // Fill up first col comparing 1 character from text1 with characters from text2
        for (int i = 1; i < m; i++) {
            if (text1.charAt(i) == text2.charAt(0)) {
                lookup[i][0] = lookup[i][0] + 1;
            } else {
                lookup[i][0] = lookup[i - 1][0];
            }
        }

        // proceed with filling up all the cells
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    lookup[i][j] = lookup[i - 1][j - 1] + 1;
                } else {
                    lookup[i][j] = Math.max(lookup[i][j - 1], lookup[i - 1][j]);
                }
            }
        }
        return lookup[m - 1][n - 1];
    }

    public static int dynamicProgrammingTopDownRetrieveString(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] table = new int[m + 1][n + 1];

        // first column and first row is kept empty. You can think of it as an empty strings.
        // This method makes it easier to retrieve string if asked.
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    table[i][j] = 1 + table[i - 1][j - 1];
                } else {
                    table[i][j] = Math.max(table[i][j - 1], table[i - 1][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (table[m][n] == 0) {
            System.out.println(sb.toString());
        } else {
            int x = m;
            int y = n;
            while (x > 0 && y > 0) {
                if (text1.charAt(x - 1) == text2.charAt(y - 1)) {
                    sb.insert(0, text1.charAt(x - 1));
                    x--; y--;
                } else {
                    if (table[x][y - 1] > table[x - 1][y]) {
                        y--;
                    } else {
                        x--;
                    }
                }
            }
        }
        System.out.println(sb.toString());
        return table[m][n];
    }


    public static void main(String[] args) {
        System.out.println(dynamicProgrammingTopDownRetrieveString("abcde", "ace"));
        System.out.println(dynamicProgrammingTopDownRetrieveString("abc", "abc"));
        System.out.println(dynamicProgrammingTopDownRetrieveString("abcdef", "dabc"));
    }
}
