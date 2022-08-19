import java.util.List;
import java.util.ArrayList;

public class Subset {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        List<List<Integer>> ans = subsetsBack(nums);

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }
    static void solve(int[] nums, int start, List<Integer> list, List<List<Integer>> result){
        result.add(new ArrayList<>(list));
        if(start == nums.length)
            return;
        for(int i=start; i<nums.length; i++){
            list.add(nums[i]);
            solve(nums, i+1, list, result);
            list.remove(list.size()-1);
        }
    }

    public static List<List<Integer>> subsetsBack(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(nums, 0, new ArrayList<>(), result);
        return result;
    }
}
//This is kind of like a DFS because it goes deeper and deeper. Like it goes through the list by doing 1 and then 1 and 2
//then 1,2, and 3 and then 1,2,3,4, instead of a BFS that would do 1, and then 1,2, and then 2 and then 2,3, etc.
//Back tracking is hard. O(n * 2^n)