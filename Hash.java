
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    // int[] nums = {5,2,7,10,3,9};
    // int[] pair = TwoSum2(nums,8);
    // System.out.println(pair[0]);
    // System.out.println(pair[1]);

        //System.out.println(FirstCharacterToAppearTwice1("abc1defy21"));
        //System.out.println(CheckIfSentenceIsPangram("thequickbrrownfoxjumpsovethelazydog"));
        int[] nums = {1,1,3,3,5,5,7,7};
        System.out.println(countElements(nums));

    }

    public static void TwoSum(int[] nums, int target){
        Map<Integer, Integer> hashMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (hashMap.containsKey(complement)){
                int[] pair = new int[] {hashMap.get(complement), i };

                System.out.println(pair[0] +" "+ pair[1]);
                return;
            }
            hashMap.put(nums[i],i);
        }

        for (int key: hashMap.keySet()){
            System.out.println("Key: " + Integer.toString(key) + " Value: " + Integer.toString(hashMap.get(key)));
        }

    }

    public static int[] TwoSum1(int[] nums, int target){
        // hashMap
        Map<Integer, Integer> hashMap = new HashMap<>();
        
        // for every number 
        for (int i = 0; i < nums.length; i++){
            // Get complement 
            int complement = target - nums[i];
            // Lookup in hashMap
            if (hashMap.containsKey(complement)){
                return new int[]{hashMap.get(complement), i};        
            }

            // If not in hashMap add the number
            hashMap.put(nums[i], i );

        }
        return new int[]{-1, -1};

    }

    public static int[] TwoSum2(int[] nums, int target){

        // Create hashMap
        Map<Integer, Integer> hashMap = new HashMap<>();

        // For every number in array add to hashMap if complement not present
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            
            // If present return the index of the complement and the current index
            if (hashMap.containsKey(complement)){
                return new int[] {hashMap.get(complement), i};
            }
            hashMap.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }

    public static char FirstCharacterToAppearTwice(String s){

        // Create a HashMap
        Map<Character, Integer> hashMap = new HashMap<>();

        // For every char add to HashMap

        for (char c : s.toCharArray()){
            if (hashMap.containsKey(c)){
                return c;
            }
            hashMap.put(c,0);
        }

        // If present return the char since it occurs again

        return ' ';
    }

    public static char FirstCharacterToAppearTwice1(String s){
        // Create Set
        Set<Character> set = new HashSet<>();
        
        // Add each char in Set if not present
        for (int i = 0; i < s.length(); i++){
            char letter = s.charAt(i);
            // If present return char
            if (set.contains(letter)){
                return letter;
            }
            set.add(letter);
        }

        return ' ';
    }

    public static boolean CheckIfSentenceIsPangram(String s){
        // Create a Set and add each character
        Set<Character> seen = new HashSet<>();

        for (char c : s.toCharArray()){
            seen.add(c);
        }
        // return Set size == 26
        return seen.size() == 26;
    }

    public static int countElements(int[] arr){

        Set<Integer> set = new HashSet<>();
        
        int count = 0;
        
        for (int i = 0; i < arr.length; i++){
            set.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++){
            if (set.contains(arr[i] + 1))
                count++;
        }

        return count;
    }
}
