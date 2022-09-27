class ShipPackage {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(weights,days));
    }
    //left = the biggest package needed to be shipped aka the minimum of weight we are able to ship at once
    //right = the max weight we are able to ship at once
    //with that we can use a binary search in order to find the minimum amount of weight to ship within the days given.
    public static int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for(int num: weights) {
            left = Math.max(left,num);
            right+= num;
        }

        while(left < right) {
            int mid = left + (right-left)/2, need = 1, cur = 0;
            for(int w: weights) {
                if(cur + w > mid) {
                    need+=1;
                    cur = 0;
                }
                cur+= w;
            }
            if( need > days) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
