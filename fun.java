public class fun {
    public static void main(String[] args) {
        int[] test = new int[]{1,2,4,5,6,3,3};
        System.out.println(findDuplicate(test));
    }
    public static int findDuplicate(int[] nums) {
        if(nums.length <=1 ) return -1;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j< nums.length; j++) {
                if(nums[i] == nums[j]) return nums[i];
            }
        }
        return -1;
    }
    public static int findDuplicateN(int[] nums) {

        return -1;
    }
}
