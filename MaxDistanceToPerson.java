class MaxDistanceToPerson {// 0 0 0 1

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,0,0,1};
        System.out.println(maxDistToClosest(nums));
    }

    public static int maxDistToClosest(int[] seats) {
        int res = 0, n = seats.length, last = -1;
        for (int i = 0; i < n; ++i) {
            if (seats[i] == 1) {
                //res = last < 0 ? i : Math.max(res, (i - last) / 2);
                if(last < 0) {
                    res = i;
                } else {
                    res = Math.max(res,(i-last)/2);
                }
                last = i;
            }
        }
        res = Math.max(res, n - last - 1);
        return res;
    }
}

//We create one for loop to iterate the entire array and we keep track of the index of the last seated seat.
//This is Time: O(N) as this iterate through the entire array in one pass