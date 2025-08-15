
import java.util.HashMap;
import java.util.Map;

public class Hash
{
    public static void main(String[] args) {
        
     Map<Integer, Integer> hashMap = new HashMap<>();

     Map<Integer, Integer> hashMap1 = new HashMap<>();
        
     hashMap.put(1,1);
     hashMap.get(1);
     hashMap.containsKey(1);
     hashMap.remove(1);
     hashMap.size();

     for (int key: hashMap.keySet()){
        System.out.print(key);  
     }

     for (int value: hashMap.values()){
        System.out.println(value);
     }






     
        
    }

}
