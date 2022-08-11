public class BackspaceString {

    public static void main(String[] args) {
        String s = "abch#d#e";
        String t = "abr#cg#e";
        System.out.println(backspaceCompare(s,t));
    }

        public static boolean backspaceCompare(String S, String T) {
            int i = S.length()-1;
            int j = T.length()-1;
            int countS = 0;
            int countT = 0;
            while (i >= 0 || j >= 0) { //we set up this conditional because this means if we reach the end traversing through one of these strings then stop the loop
                while (i >= 0 && (countS > 0 || S.charAt(i) == '#')) {
                    if (S.charAt(i) == '#') countS++;
                    else countS--;
                    i--;
                }
                char left = i < 0 ? '@' : S.charAt(i);
                while (j >= 0 && (countT > 0 || T.charAt(j) == '#')) {
                    if (T.charAt(j) == '#') countT++;
                    else countT--;
                    j--;
                }
                char right = j < 0 ? '@' : T.charAt(j);
                if (left != right) return false;
                i--;
                j--;
            }
            return true;
        }

}

