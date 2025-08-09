public class LargestNumber {
    public static void main(String[] args){
        int[] nums = {1,2,5,111,2,839,32,2,7};

        int largestNumber = LargestNumberFromArray(nums);
        System.out.println(largestNumber);
        
    }

    public static int LargestNumberFromArray(int[] nums){
        int maxNum = nums[0];
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > maxNum){
                maxNum = nums[i];
            }
        }
        return maxNum;
    }
}
