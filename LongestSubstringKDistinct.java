//Given a string, find the length of the longest substring in it with no more than K distinct characters.
//Input: String="araaci", K=2
//Output: 4
//Explanation: The longest substring with no more than '2' distinct characters is "araa".


import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static void main(String[] args) {
        String str = "qrsaatatv"; //aatat = 5
        int k = 2;
        System.out.println(findLength(str,k));

    }
    public static int findLength(String str, int k) {

        Map<Character,Integer> map = new HashMap<>();
        int longestSubStr = Integer.MIN_VALUE, slidingWindow = 0;
        for(int i = 0; i < str.length(); i++) {
            char rightChar = str.charAt(i);
            map.put(rightChar,map.getOrDefault(rightChar,0)+1);
            while(map.size()>k) {
                char leftChar = str.charAt(slidingWindow);
                map.put(leftChar,map.getOrDefault(leftChar,0)-1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                slidingWindow++; // shrink the window
            }
            longestSubStr = Math.max(longestSubStr, i - slidingWindow + 1);
        }
        return longestSubStr;
    }
}
