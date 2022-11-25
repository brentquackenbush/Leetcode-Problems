import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.
 */
public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    public static List<Integer> partitionLabels(String s) {
        //we want to break the string into as many substrings as possible so that the characters contained in the string are unique compared to other substrings.
        List<Integer> res = new ArrayList<>();

        if(s.length() == 1) {
            res.add(1);
            return res;
        }

        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }

        int max = 0, prev = -1;
        for(int i = 0; i < s.length() ;i++) {
            char ch = s.charAt(i);
            max = Math.max(max, map.get(ch));
            if(i == max) {
                res.add(max - prev);
                prev = max;
            }
        }
        return res;
    }
}

/*
Time complexity: O(n)
Space Complexity: O(n) we utilize a hashmap in order to solve this problem

We store the characters in the hashmap as a key and store the index as a value creating a key value pair of
<Character, Integer>. Now we can go through the entire length of the string again keep two pointers for max and prev.
We will store max index of the current char we are looking at. If I catches up to max, we know that this is one substring
and then we add it to our list by doing max - prev. Then store max at prev.


 */
