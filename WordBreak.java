import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        String s = "Leetcode";
        List<String> list = new ArrayList<>();
        list.add("Leet");
        list.add("code");
        System.out.println(wordBreak(s,list));
    }

    public static boolean wordBreak(String s, List<String> wordList) {

        boolean[] T = new boolean[s.length() + 1];

        int maxLen = 0;
        for (String word : wordList) {
            maxLen = Math.max(maxLen, word.length());
        }
        T[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (i - j > maxLen) {
                    continue;
                }
                if (T[j] && wordList.contains(s.substring(j, i))) {
                    T[i] = true;
                    break;
                }
            }
        }
        return T[s.length()];
    }

}
