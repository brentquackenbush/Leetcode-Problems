import java.util.*;

class TaskScheduler {

    public static void main(String[] args) {
        char[] test = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(leastInterval(test,n));
    }
    public static int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;

        Map<Character,Integer> map = new HashMap<>();
        for(char c: tasks) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((i1, i2) -> i2.getValue() - i1.getValue());

        maxHeap.addAll(map.entrySet());

        int count = 0;
        while(!maxHeap.isEmpty()) {

            int interval = n + 1;
            List<Map.Entry<Character, Integer>> list = new ArrayList<>();

            while(interval > 0 && !maxHeap.isEmpty()) {
                Map.Entry<Character,Integer> entry = maxHeap.poll();
                entry.setValue(entry.getValue()-1);
                list.add(entry);
                interval--;
                count++;
            }

            for(Map.Entry<Character,Integer> entry: list) {
                if(entry.getValue() > 0) {
                    maxHeap.offer(entry);
                }
            }
            if(maxHeap.isEmpty()) break;

            count+= interval;
        }
        return count;
    }
}