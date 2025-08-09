public class Palindrome {
    public static void main(String[] args){
        // System.out.print(IsPalindrome("racecar"));

        int[] nums = {1,4,5,7,13};
        System.out.print(TwoSumSorted(nums, 123));
    }

    public static boolean IsPalindrome(String s){
        int first = 0;
        int last = s.length()-1;

        while (first < last){
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


}
