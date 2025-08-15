
import java.util.HashMap;
import java.util.Map;

public class Hash
{
    public static void main(String[] args) {
        
    //  Map<Integer, Integer> hashMap = new HashMap<>();

    //  Map<Integer, Integer> hashMap1 = new HashMap<>();
        
    //  hashMap.put(1,1);
    //  hashMap.get(1);
    //  hashMap.containsKey(1);
    //  hashMap.remove(1);
    //  hashMap.size();

    //  for (int key: hashMap.keySet()){
    //     System.out.print(key);  
    //  }

    //  for (int value: hashMap.values()){
    //     System.out.println(value);
    //  }
    int[] nums = {5,2,7,10,3,9};
    TwoSum(nums,8);
    }

    public static void TwoSum(int[] nums, int target){
        Map<Integer, Integer> hashMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (hashMap.containsKey(complement)){
                int[] pair = new int[] {hashMap.get(complement), i };

                System.out.println(pair[0] +" "+ pair[1]);
                //return;
            }
            hashMap.put(nums[i],i);
        }

        for (int key: hashMap.keySet()){
            System.out.println("Key: " + Integer.toString(key) + " Value: " + Integer.toString(hashMap.get(key)));
        }

    }

}
