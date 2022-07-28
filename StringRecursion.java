//Write a function that reverses a string. The input string is given as an array of characters s.
//
//You must do this by modifying the input array in-place with O(1) extra memory.

public class StringRecursion {

    public static void main(String[] args) {
        char[] s = {'m','o','t','h','e','r'};
        iterativeSwap(s);
        String reverse = new String(s);
        System.out.println(reverse.toString());

    }

    public static void reverseString(char[] s) {
        solve(s, 0, s.length-1);
    }

    public static void solve(char[] s, int start, int end){
        if(start>=end)return; //base case
        swap(s, start, end);
        solve(s, ++start, --end);
    }

    public static void swap(char[] s, int i, int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public static void iterativeSwap(char[] s) {
        int i = 0;
        int j = s.length-1;
        while(i <= j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}

//when doing recursion there always must be a base case in order for the recursion to stop and not be an endless loop.
//SOLUTION: For the recursive approach it is still O(n) time complexity.
//SOLTUION: For iterative approach it is still O(n) time complexity
