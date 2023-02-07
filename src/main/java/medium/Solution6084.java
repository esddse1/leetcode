package medium;

import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution6084 {



    public String largestWordCount(String[] messages, String[] senders) {
        TreeMap<String,Integer> treeMap=new TreeMap<>();
        for (int i=0;i<messages.length;i++){
            int count=messages[i].split(" ").length;
            treeMap.put(senders[i],treeMap.getOrDefault(senders[i],0)+count);
        }
        final String[] result = {null};
        AtomicInteger currentMax= new AtomicInteger();
        treeMap.forEach((key,value)->{
            if (result[0] ==null || value>=currentMax.get()){
                result[0] = key;
                currentMax.set(value);
            }
        });
        return result[0];
    }
}
