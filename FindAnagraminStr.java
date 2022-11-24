import java.util.ArrayList;
import java.util.List;

public class FindAnagraminStr {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(findAnagrams(s,p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s == null || p == null || p.length() > s.length()) return res;

        int[] pArr = new int[26];
        for(Character c: p.toCharArray()) pArr[c-'a']++;

        int left = 0, right = 0;
        while(right < s.length()) {

            char c = s.charAt(right);
            pArr[c-'a']--;

            while(pArr[c-'a'] < 0) {
                char temp = s.charAt(left);
                pArr[temp - 'a']++;
                left++;
            }

            if(right - left + 1 == p.length())
                res.add(left);

            right++;
        }

        return res;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)

We used an auxillary data structure to solve the problem, however it is of fixed size, so it is constant. I used a
dynamic sliding window algorithm to find the starting indexs of the anagrams in the string s.
 */
