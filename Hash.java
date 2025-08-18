
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
        // int[] nums = {1,1,3,3,5,5,7,7};
        // System.out.println(countElements(nums));
        
        // int[][] nums = {{3,1,2,4,5},{1,2,3,4},{3,4,5,6}};
        // List<Integer> ans = Intersection(nums);

        System.out.println(RansomeNote("aabccdd", "abcddd"));

    }

    public void TwoSum(int[] nums, int target){
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

    public int[] TwoSum1(int[] nums, int target){
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

    public int[] TwoSum2(int[] nums, int target){

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

    public char FirstCharacterToAppearTwice(String s){

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

    public char FirstCharacterToAppearTwice1(String s){
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

    public boolean CheckIfSentenceIsPangram(String s){
        // Create a Set and add each character
        Set<Character> seen = new HashSet<>();

        for (char c : s.toCharArray()){
            seen.add(c);
        }
        // return Set size == 26
        return seen.size() == 26;
    }

    public int countElements(int[] arr){

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

    //Intersection of Multiple Arrays
    //nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
    //output = [3,4]
    public List<Integer> Intersection(int[][] nums){

        // For every sub array
        // Add each number to a hashmap
        // Return all the numbers in hashmap that matches the number of subarrays after sorting.
        
        Map<Integer,Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            for (int num : nums[i]){
                count.put(num, count.getOrDefault(num, 0) + 1);
            }
        }
        List<Integer> ans = new ArrayList<>();

        for (int num: count.keySet()){
            if (count.get(num) == nums.length){
                ans.add(num);   
                System.out.println(num + " " + count.get(num));
            }
        }
        Collections.sort(ans);

        return ans;
    }
    
    //  [[2,3],[1,3],[5,4],[6,4]]
    //  [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> list = new ArrayList<>();
        Set<Integer> notlost = new HashSet<Integer>();
        
        List<Integer> notlostlist = new ArrayList<Integer>();
        List<Integer> onematch = new ArrayList<Integer>();
        
        // Add all losers to a hashmap
        Map<Integer, Integer> losers = new HashMap<>();
        for (int i = 0; i < matches.length; i++){
            losers.put(matches[i][1], losers.getOrDefault(matches[i][1],0) + 1);
        }
        
        // If winners are not in the losers hashmap add to array
        for (int i = 0; i < matches.length; i++){
            if (!losers.containsKey(matches[i][0])){
                //System.out.println(matches[i][0]);
                notlost.add(matches[i][0]);
            }
        }

        for (int loser: losers.keySet()){
           // System.out.println(loser + " " + losers.get(loser));
            if (losers.get(loser) == 1){
                onematch.add(loser);
            }
        }
        
        for (int winner: notlost){
            notlostlist.add(winner);
        }
        
        
        Collections.sort(notlostlist);
        Collections.sort(onematch);
        
            
        // check the losers hasmap for 1 and add to array
        list.add(notlostlist);
        list.add(onematch);
        
        return list;
    }

    public static boolean RansomeNote(String magazine, String ransomeNote){

        if (ransomeNote.length() > magazine.length())
            return false;

        // Create a hashmap for magazine
        Map<Character, Integer> magazineMap = new HashMap<>();

        for (char c : magazine.toCharArray()){
            magazineMap.put(c, magazineMap.getOrDefault(c, 0)+1);
        }

        // check if every letter in ransom note exists in hash map
        // If exists reduce count by 1
        // If it doesn't exist return false
        for (char c : ransomeNote.toCharArray()){
            int countInMagazine = magazineMap.getOrDefault(c, 0);
            if (countInMagazine == 0){
                return false;
            }
            else{
                magazineMap.put(c,countInMagazine-1);
            }
        }


        return true;
    }
}
