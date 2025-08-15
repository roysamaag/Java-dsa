public class PrefixSum
{
    
    public static void main(String[] args) {
        int[] nums = {1, 6, 3, 2, 7, 2};
        int[][] queries = {{3,0}, {4,2}};
        StorePrefixSums(nums,queries);

        
    }

    // nums = [1, 6, 3, 2, 7, 2]
    public static void StorePrefixSums(int[] nums, int[][] queries){
        int[] prefixes = new int[nums.length];
        
        prefixes[0] = nums[0];

        for (int i = 1; i < nums.length; i++){
            prefixes[i] = nums[i] + prefixes[i-1];
        }

        

        for (int i = 0; i < prefixes.length; i++){
            System.out.println(prefixes[i]);
        }

    }


}
