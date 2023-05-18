package simplilearn;

import java.util.Arrays;

public class LIS {
    public static void main(String[] args) {
        int[] nums = {55, 88, 33, 77, 99, 11, 44, 66};
        int[] lis = findLongestIncreasingSubsequence(nums);
        
        System.out.println("Longest increasing subsequence:");
        for (int num : lis) {
            System.out.print(num + " ");
        }
    }

    public static int[] findLongestIncreasingSubsequence(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // dynamic programming[i] stores the length of the LIS ending at index i
        Arrays.fill(dp, 1); // initialize all LIS lengths to 1
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        
        // Find the maximum LIS length
        int maxLisLength = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxLisLength) {
                maxLisLength = dp[i];
            }
        }
        
        // Construct the LIS using the LIS lengths
        int[] lis = new int[maxLisLength];
        int lisIndex = maxLisLength - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == maxLisLength) {
                lis[lisIndex] = nums[i];
                lisIndex--;
                maxLisLength--;
            }
        }
        
        return lis;
    }
}