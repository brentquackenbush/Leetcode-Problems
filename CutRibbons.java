class CutRibbons {

        public static int maxLength(int[] ribbons, int k) {
            int maxRibbon = 0;
            for (int ribbon : ribbons) {
                maxRibbon = Math.max(maxRibbon, ribbon);
            }
            int low = 0, high = maxRibbon;
            while (low < high) {
                int mid = (high - low + 1) / 2 + low;
                int count = 0;
                for (int ribbon : ribbons)
                    count += ribbon / mid;
                if (count >= k)
                    low = mid;
                else
                    high = mid - 1;
            }
            return low;
        }

    public static void main(String[] args){
        int[] arr = {12,5,7};
        System.out.println(maxLength(arr, 3));
    }
}

/*
Problem: You are given an integer array ribbons, where ribbons[i] represents the length of the ith ribbon, and an integer k.
You may cut any of the ribbons into any number of segments of positive integer lengths, or perform no cuts at all.
Your goal is to obtain k ribbons of all the same positive integer length. You are allowed to throw away any excess ribbon as a result of cutting.
Return the maximum possible positive integer length that you can obtain k ribbons of, or 0 if you cannot obtain k ribbons of the same length.
 */

/*
This type of problem follows similar logic to other problems where they ask you to maximize the minimum or the
minimise the maximum. The way to go about doing that is finding some range and doing a binary search on it.
The main portion of our algorithm is a binary search. However in our binary search we go through the entirety of our
array again to divide each ribbon by mid which we hope is the optimal answer. The time complexity of this algorithm is
O(nlogn) and space complexity is O(1).

 */