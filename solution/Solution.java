package solution;

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

      public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n==1) return;
        
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.print("\n");
        // }
        
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
        
        int l =0, r=n-1;
        while(l<r){
            for(int i=0;i<n;i++){
                int tmp = matrix[i][l];
                matrix[i][l]=matrix[i][r];
                matrix[i][r] = tmp;
            }
            
            l++;
            r--;
        }
        
        
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.print("\n");
        // }
    }

    public int firstBadVersion(int n) {
        
        int l =1, r=n;
        while(true){
            if(l==r || l+1==r) break;
            int m = l + (r-l)/2;
            if(isBadVersion(m)){
                r = m;
            }else {
                l=m;
            } 

        }
        
        if(isBadVersion(l)) return l;
        return r;
        
    }

    
}