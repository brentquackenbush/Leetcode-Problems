import java.util.TreeMap;

public class MyCalendarI {

    static TreeMap<Integer,Integer> map;

    MyCalendarI() {
        map = new TreeMap<>();
    }

    public static void main(String[] args) {
        MyCalendarI calendarI = new MyCalendarI();
        System.out.println(calendarI.book(10,20));
        System.out.println(calendarI.book(15,20));
    }

    public static boolean book(int left, int right) {
        Integer low = map.lowerKey(right);

        if(low == null || map.get(low) <= left) {
            map.put(left,right);
            return true;
        }
        return false;
    }
}

//First implementation of using TreeMap
//TreeMap is not like HashMap, it does not using hashing function
//TreeMap is good to keep a sorted key value mapping. It sorts the map by the key
//Understanding Intervals is important. A lot of problems deal with intersecting intervals.
