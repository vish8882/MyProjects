package blind75;

public class LongestPalindrome {

    public static void main(String[] args) {
        String input = "cbbd";
        System.out.println("Finding longest palindrome");
        System.out.println("Longest palindrome is : " + new LongestPalindrome().longestPalindrome(input));
    }

    public String longestPalindrome(String input) {
        int st = 0;
        int en = 1;
        char[] s = input.toCharArray();
        int len = s.length;
        if (len == 1) {
            return input;
        }
        boolean[][] arr = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (i == 0) {
                    arr[i][j] = true;
                } else {
                    int row = j;
                    boolean similar = s[j - i] == s[row];
                    if (similar) {
                        if (i == 1) {
                            arr[i][row] = true;
                            st = j - i;
                            en = row + 1;

                        } else {
                            if (arr[i - 2][row - 1]) {
                                arr[i][row] = true;
                                st = j - i;
                                en = row + 1;
                            }
                        }
                    }
                }
            }
        }
        return input.substring(st, en);
    }

}
