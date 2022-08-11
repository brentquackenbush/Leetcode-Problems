//You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj].
//        Each list of intervals is pairwise disjoint and in sorted order.
//
//        Return the intersection of these two interval lists.
//
//        A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
//
//        The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval.
//        For example, the intersection of [1, 3] and [2, 4] is [2, 3].

import java.util.ArrayList;
import java.util.List;

public class IntervalListM {

    public static void main(String[] args) {
        int[][] firstList = new int[][]{{0,4},{7,11}, {14,20}};
        int[][] secondList = new int[][]{{1,2},{9,13}, {17,25}};
        //Answer should be {1,2} {9,11} {17,20}
        int[][] intersectionPoints = intervalIntersection(firstList,secondList);
        for(int i = 0; i < intersectionPoints.length; i++) {
            System.out.print("{");
            for(int j : intersectionPoints[i]) {
                System.out.print(j + ",");
            }
            System.out.println("}");
        }
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length ==0 || secondList.length == 0) return new int[][]{}; //return empty list if a list is empty

        List<int[]> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < firstList.length && j < secondList.length) {

            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1],secondList[j][1]);
            if(end >= start) ans.add(new int[]{start,end});
            if(firstList[i][1] == end) i++;
            if(secondList[j][1] == end) j++;
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
//Solution should  take O(m*n) with m = rows and n = columns. We create a generic list and initialize it to an ArrayList
//(saw this on StackOverFlow) it is important to intitialize it to a interface so in case we want to change it to an
//LinkedList halfway through our code it doesn't throw errors. We loop until all arrays are looped to the end.
//Grab the max of the minimum start and then grab the minimum of the end. Should make sense to you if not you're dumb.JK
//increment if firstList[i][1] is equal to end meaning that the firstList is what has the smaller end so there can be another
//intersection with secondList.