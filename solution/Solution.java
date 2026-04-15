package solution;
import java.math.*;
public class Solution {
    private boolean isValidCharacter(char a){
         return a>96 && a<123  || a-'0'>= 0 && a-'0'<=9 ? true : false;
    }
    public boolean isPalindrome(String s) {
        if(s.length()<2) return true;

        int l = 0, r = s.length()-1;
        
        s = s.toLowerCase();
        while (true) {
            while (l<r && !isValidCharacter(s.charAt(l))) {
                l+=1;
            }
            if(l>=r) break;

            while (r>l && !isValidCharacter(s.charAt(r))) {
                r-=1;
            }

            System.out.println(s.charAt(l) + " " + s.charAt(r));

            if(l>=r) break;

            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }


    public boolean isPowerOfThree(int n) {
        return n>0 && 1162261467%n==0;
    }

    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }

    
}