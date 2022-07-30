//Given a string s, find the length of the longest substring without repeating characters.
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LongestSubStr {
    public static void main(String[] args) {
        String s = "Hello";
        int ans = lengthOfLongestSubstringArr(s);
        System.out.println(ans);
    }
    //Uses hashset which doesn't allow duplicates to figure out the current biggest substring.
    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<Character>();
        while(j < s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
    //Uses array to keep track of sliding window and where the left pointer(slow pointer) should point next.
    //nextIndex is 128 for ASCII Characters.
    public static int lengthOfLongestSubstringArr(String s) {
        int n = s.length(), longest = 0;
        int[] nextIndex = new int[128];

        for (int r=0, l=0; r<n; r++) {
            l = Math.max(nextIndex[s.charAt(r)], l);
            longest = Math.max(longest, r - l + 1);
            nextIndex[s.charAt(r)] = r + 1;
        }

        return longest;
    }
}

//SOLUTION USING ARR: It took me a while to understand when it sends in s.charA(r) into nextIndex...but it is finding the index of the ascii character basically in the array
//With it setting r+1 as the value at that index, it is basically saying that look, we have found another instance of that letter when searching for the length
// of the longest substring in the string, move to this index instead and look if there is a bigger substring wihtout duplicates. Math.Max() returns the max
// of the two integers sent into the function. We check again for the longest math.max to see if at our current search if our current substring is better than our current stored
//longest one, then set our longest int ot the new longest;
//O(n)
//Time Complexity: O(n) where n is the length of the string.
//Space Complexity: O(128) for the nextIndex array.

