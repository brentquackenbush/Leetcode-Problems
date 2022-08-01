//Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
//
//        In other words, return true if one of s1's permutations is the substring of s2.
import java.util.Arrays;
public class StringPermutation {

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        boolean isPermutation = checkInclusionFast(s1,s2);
        System.out.println(isPermutation);
    }

    public static boolean checkInclusionSlow(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1map, s2map))
                return true;
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return matches(s1map, s2map);
    }

    public static boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }

    public static boolean checkInclusionFast(String s1, String s2) {

        //edge cases
        if(s1.length() == 0) return true;
        if(s1.length() > s2.length()) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        for(int i = s1.length(); i < s2.length(); i++) {
            if(Arrays.equals(arr1,arr2)) return true;
            //The below statement is something I need to understand
            //I understand what it does which is, it minuses the previous position because we are now looking for a new position to look at to find the permutation of s1 in s2
            arr2[s2.charAt(i-s1.length()) - 'a']--;
            arr2[s2.charAt(i) - 'a']++;

        }
        if(Arrays.equals(arr1,arr2)) { return true; } else { return false;}

    }

}

//SOLUTION for FAST: Time complexity: O(l1+26*(l2-l1)).
//We check the edge cases first if s1 is 0 then of course s1 is in s2. If s1 has a greater length than s2, it is impossible
//for there to be a permutation of s1 in s2. We create our sliding window and an array holding s1 (arr1 and arr2) arr2
//is our sliding window.(TIP: The reason why we initialize s1 with length 26 is because we are assuming this is for
// permutations with lower case characters.) With this we populate the entirety of s1 into arr1 and the beginning of
//s2 until the end of s1.length. Now for our sliding window loop. We check first if arr1 and arr2 equal each other.
//Next if it doesn't we want to minus the previous search because that character is not a permutation of s1.
//Then we add the next character of s2 to see if it in s1.
