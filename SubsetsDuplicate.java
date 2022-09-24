import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetsDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        System.out.println(subsetsWithDup(nums).toString());
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfsHelper(result, new ArrayList<>(),0,nums);
        return result;

    }

    public static void dfsHelper(List<List<Integer>> result, List<Integer> subset, int start, int[] nums) {
        result.add(new ArrayList<>(subset));
        if(start == nums.length) return;
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            subset.add(nums[i]);
            dfsHelper(result,subset,i+1,nums);
            subset.remove(subset.size()-1);
        }
    }
}