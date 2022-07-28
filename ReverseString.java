//Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
//Input: s = "Let's take LeetCode contest"
//Output:s = "s'teL ekat edoCteeL tsetnoc"
public class ReverseString {
    public static void main(String[] args) {
        String s = "Hello world!";
        s = reverseWord(s);
        System.out.println(s);
    }

    public static String reverseWord(String s) {

        char[] word = s.toCharArray();
        int end = 0, start = 0;
        for(;end < word.length; end++) {
            if(word[end] == ' ') {
                reverse(word,start, end -1);
                start = end+1;
            }
        }
        reverse(word,start,end-1); //have to reverse the last word in the string.
        // Since there is no empty space at the end of the array we will have to manually account for this outside of the for loop

        return new String(word);

    }
    public static void reverse(char[] s,int start, int end) {
        //reverse the character array
        while(start <= end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;end--;
        }

    }
}

//SOLUTION Time Complexity: \mathcal{O}(N)O(N) The outer loop iterates over \text{N}N characters to find the start and end index of every word.
// The algorithm to reverse the word also iterates \text{N}N times to perform \text{N/2}N/2 swaps.
// Thus, the time complexity is \mathcal{O}(N + N) = {O}(N)O(N+N)=O(N).
