import java.util.*;

public class MultiLevelCache {

    LinkedHashMap<String,String> L1 =
            new LinkedHashMap<>(10,0.75f,true);

    HashMap<String,String> L2 =
            new HashMap<>();

    public String getVideo(String id){

        if(L1.containsKey(id)){
            return "L1 HIT";
        }

        if(L2.containsKey(id)){
            L1.put(id,L2.get(id));
            return "L2 HIT → promoted to L1";
        }

        L2.put(id,"videoData");

        return "DB HIT";
    }

    public static void main(String[] args){

        MultiLevelCache cache=new MultiLevelCache();

        System.out.println(cache.getVideo("video123"));
        System.out.println(cache.getVideo("video123"));
    }
}