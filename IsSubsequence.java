class IsSubsequence {
    public static void main(String[] args) {
        String s = "b";
        String t = "abc";
        System.out.println(isSubsequence(s,t));

    }
    public static boolean isSubsequence(String s, String t) {
        //I take out the char at every index of string s found in string t and if string s is empty at the end return true, else return false
        //I can do this because t has to be arranged in a subsequence so I can search through string s linearly

        for(int i = 0; i < t.length();i++) {
            if(s.length() == 0) return true;
            if(s.charAt(0) == t.charAt(i)) {
                s = s.substring(1);
            }
        }
        return s.equals("") ? true : false;
    }
}