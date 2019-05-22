package datastructure;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMapTest
 *
 * @autor rj-liang
 * @date 2017/7/30 下午8:18
 */
public class LinkedHashMapTest {
    public static void main(String[] args) throws Exception{
        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(10, 0.75f, true);
        map.put(9,3);
        map.put(7,4);
        map.put(5,9);
        map.put(3,4);
        // 现在遍历的话顺序肯定是9,7,5,3
        for(Iterator<Map.Entry<Integer,Integer>> it = map.entrySet().iterator(); it.hasNext();){
            System.out.println(it.next().getKey());
        }
        System.out.println("================");
        //下面访问了一下9,3这个键值对，输出顺序就变喽~
        map.get(9);
        for(Iterator<Map.Entry<Integer,Integer>> it = map.entrySet().iterator(); it.hasNext();){
            System.out.println(it.next().getKey());
        }
    }

}
