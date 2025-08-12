import java.util.ArrayList;
import java.util.List;

public class TwoPointers {
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

    public static boolean IsPalindrome(String s){
        int first = 0;
        int last = s.length()-1;

        while (first < last){
            if (s.charAt(first) == ' ')
            {
               first += 1;
               break;
            }
            if (s.charAt(last) == ' ')
            {
               first -= 1;     
               break;
            }

            if (s.charAt(first) != s.charAt(last)){
                return false;
            }
            first += 1;
            last -= 1;
        }

        return true;
    }

    public static boolean TwoSumSorted(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1 ;

        while (left < right){
            int currentSum = nums[left] + nums[right];
            if (currentSum == target){
                return true;
            }

            if (currentSum > target){
                right -= 1;
            }
            else{
                left += 1;
            }            
        }

        return false;
    }

    public static void MergeTwoSortedArrays(int[] arr1, int[] arr2)
    {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length)
        {
            if (arr1[i] < arr2[j])
            {
               ans.add(arr1[i]);     
               i++;
            }
            else
            {
                ans.add(arr2[j]); 
                j++;    
            }
        }

        // Add the remaing items from the bigger array
        while (i < arr1.length)
        {
            ans.add(arr1[i]);
            i++;
        }
        while (j < arr2.length)
        {
            ans.add(arr2[j]);
            j++;
        }

        for (Integer item : ans) {
            System.out.println(ans.get(item-1));

        }
    }

    // Given two strings s and t, return true if s is a subsequence of t,
    // or false otherwise.
    public static void IsSubsequence(String s, String t)
    {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()){
            if (s.charAt(i) == t.charAt(j))
            {
                i++;
            }
            j++;
        }
        System.out.println(i == s.length());
    }

    public static void ReverseString()
    {
        String[] myStrArr = {"h", "a", "n", "n","a","h"};

        int left = 0;
        int right = myStrArr.length - 1;

        while (left < right)
        {
            String temp = myStrArr[left];
            myStrArr[left] = myStrArr[right];
            myStrArr[right] = temp;
            left++;
            right--;
        }

        for (String string : myStrArr) {
            System.out.print(string);
        }




    }

    // Given an integer array nums sorted in 
    // non-decreasing order, return an array 
    // of the squares of each number sorted in non-decreasing order.
    // Squaring each element and sorting the new array
    // is very trivial, could you
    // find an O(n) solution using a different approach?
    public static void SortedSquares(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--){
            if (Math.abs(nums[left]) < Math.abs(nums[right])){
               ans[i] = nums[right];
               right--;
            }
            else{
                ans[i] = nums[left];
                left++;
            }
            ans[i] = ans[i] * ans[i];
        }

        // Print array 
        for (int i = 0; i < ans.length ; i++){
            System.out.println(ans[i]);
        }


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
