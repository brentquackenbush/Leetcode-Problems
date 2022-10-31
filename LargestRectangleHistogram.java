import java.awt.desktop.SystemSleepListener;
import java.util.ArrayDeque;
import java.util.Deque;

class LargestRectangleHistogram {

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.print(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights == null) {
            throw new IllegalArgumentException("Input array is null");
        }

        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= len; i++) {
            while (!stack.isEmpty() && (i == len || heights[stack.peek()] >= heights[i])) {
                int h = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                /**
                 * i-1 - left ==> This is calculating the width of the rectangle. Both ith and
                 * left positions are excluded.
                 */
                maxArea = Math.max(maxArea, (i - 1 - left) * h);
            }
            stack.push(i);
        }

        return maxArea;
    }
}