
public class SlidingWindow {
    public static void main(String[] args){
        //System.out.print(IsPalindrome("able was i ere I saw elba"));
 
        //int[] nums = {1,4,5,7,13};
        //System.out.print(TwoSumSorted(nums, 123));

        // int[] arr1 = {1,3,5,7,9};
        // int[] arr2 = {2,4,6,8,10};
        // MergeTwoSortedArrays(arr1,arr2);

        //IsSubsequence("ace","abcde");
        //ReverseString();

        //int[] nums = {3, 1, 2, 7, 4, 2, 1, 1, 5};
        //SortedSquares(arr);
        //LongestSubarray(nums, 8);

        // int[] nums = {1,12,-5,-6,50,3};
        // FindMaxAverageSubArray(nums, 4);
        
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};

        MaxConsecutiveOnes(nums, 3);



    }

    // Given an array of positive integers nums and an integer k, 
    // find the length of the longest subarray whose sum is 
    // less than or equal to k. 
    public static void LongestSubarray(int[] nums, int k){
        int left = 0;
        int curr = 0; // current sum
        int ans = 0; // longest subarray

        for (int right = 0; right < nums.length; right++){
            curr += nums[right] ;
            while (curr > k){
                curr -= nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1 );
        }

        System.out.println(ans);

    }

    // You are given a binary string s (a string containing only "0" and "1"). 
    // You may choose up to one "0" and flip it to a "1". 
    // What is the length of the longest substring achievable that contains only "1"?
    // For example, given s = "1101100111", the answer is 5. If you perform the flip at index 2,
    // the string becomes 1111100111.
    

    // You are given an integer array nums consisting of n elements, and an integer k.
    // Find a contiguous subarray whose length is equal to k that has the maximum
    // average value and return this value. Any answer with a calculation error less than 10^5 will be accepted.
    // Input: nums = [1,12,-5,-6,50,3], k = 4
    // Output: 12.75000
    // Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
    public static void FindMaxAverageSubArray(int[] nums, int k){

        double curr = 0;    
        double ans = 0;
        for (int i = 0; i < k; i++){
            curr += nums[i];
        }

        ans = curr/k;

        for (int i = k; i < nums.length; i++){
            curr += nums[i];
            curr -= nums[i-k];
            ans = Math.max(ans, curr/4);
        }
        
        System.out.println(ans);

    }

    // Given a binary array nums and an integer k, return the maximum number 
    // of consecutive 1's in the array if you can flip at most k 0's.
    // Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
    // Output: 6
    // Explanation: [1,1,1,0,0,1,1,1,1,1,1]
    public static void MaxConsecutiveOnes(int[] nums, int k){
        int left = 0;
        int occur = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++){
            if (nums[right] == 0){
                occur++;
            }
            while (occur > k){
                if (nums[left] == 0){
                    occur--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        System.out.println(ans);

    }
}