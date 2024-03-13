package com.leetcode.cn.solution1_50;

public class Solution44 {
    public boolean isMatch(String s, String p) {
        p = removeDuplicateCharacter(p);
        // 代表字符串s以si为起点，p以pi为起点是否完全匹配，0代表未知，1代表不匹配，2代表匹配
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = 2;
        return dfs(s, p, 0, 0, dp);
    }

    // 去除重复的'*'字符
    public String removeDuplicateCharacter(String p) {
        StringBuilder result = new StringBuilder();
        // 出现'*'
        boolean flag = false;
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (!flag) {
                result.append(c);
            } else {
                if (c != '*') {
                    result.append(c);
                    flag = false;
                }
            }
            if (c == '*' && !flag) {
                flag = true;
            }
        }
        return result.toString();
    }

    // 字符串s以si为起点，p以pi为起点是否完全匹配
    public boolean dfs(String s, String p, int si, int pi, int[][] dp) {
        // si和pi都匹配到字符串末尾
        if (si == s.length() && pi == p.length()) {
            return true;
        }
        // si没匹配到末尾，pi匹配到末尾
        if (si != s.length() && pi == p.length()) {
            dp[si][pi] = 1;
            return false;
        }
        // si匹配到末尾，pi没匹配到末尾
        if (si == s.length() && pi != p.length()) {
            if(p.charAt(pi) != '*') {
                dp[si][pi] = 1;
                return false;
            }
            if(dp[si][pi + 1] != 0) {
                dp[si][pi] = dp[si][pi + 1];
                return dp[si][pi] == 2;
            } else {
                boolean flag = dfs(s, p, si, pi + 1, dp);
                dp[si][pi] = flag ? 2 : 1;
                return flag;
            }
        }
        // '?'代表s和p匹配一个字符
        if (p.charAt(pi) == '?') {
            if (dp[si + 1][pi + 1] != 0) {
                dp[si][pi] = dp[si + 1][pi + 1];
            }
            boolean flag = dfs(s, p, si + 1, pi + 1, dp);
            dp[si][pi] = flag ? 2 : 1;
            return dp[si][pi] == 2;
        }
        if (p.charAt(pi) == '*') {
            // '*'从匹配0个字符开始，若后续匹配成功则返回true。否则，'*'匹配1个字符，失败再匹配2个字符，直到匹配到s末尾。
            // s匹配到末尾还是匹配失败，则以si和pi为起点的匹配失败
            for(int i = si; i <= s.length(); i++) {
                if (dp[i][pi + 1] != 0) {
                    if (dp[i][pi + 1] == 2) {
                        dp[si][pi] = 2;
                        return true;
                    }
                } else {
                    boolean flag = dfs(s, p, i, pi + 1, dp);
                    if (flag) {
                        dp[si][pi] = 2;
                        return true;
                    }
                }
            }
            dp[si][pi] = 1;
            return false;
        }
        // si和pi字符相同，继续往后匹配
        if(s.charAt(si) == p.charAt(pi)) {
            if(dp[si + 1] [pi + 1] != 0) {
                dp[si][pi] = dp[si + 1] [pi + 1];
                return dp[si][pi] == 2;
            }
            boolean flag = dfs(s, p, si + 1, pi + 1, dp);
            dp[si][pi] = flag ? 2 : 1;
            return flag;
        }
        // pi不是特殊字符，且si和pi字符不同，则匹配失败
        dp[si][pi] = 1;
        return false;
    }
}
