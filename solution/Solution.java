package solution;

import java.util.*;

public class Solution {

    /*---- Problem 1: Valid Palindrome ------*/ 
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

    /*---- Problem 2: Power of Three ------*/
    public boolean isPowerOfThree(int n) {
        return n>0 && 1162261467%n==0;
    }

    /*---- Problem 3: House Robber ------*/
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

        /*---- Problem 4: Rotate Image ------*/
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

    /*---- Problem 5: First Bad Version ------*/

    private boolean isBadVersion(int m){
        return true;
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

    /*---- Problem 6: Group Anagram ------*/

    public boolean isAnagram(String s1, String s2){
        if(s1.length()!=s2.length()) return false;
        int[] arr = new int[26];
        for(int i=0;i<s1.length();i++){
            arr[s1.charAt(i)-'a'] ++;
        }

        for(int i=0;i<s2.length();i++){
            if(arr[s2.charAt(i)-'a'] ==0) return false;
            arr[s2.charAt(i)-'a']--;
        }

        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        List<List<String>> res = new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(strs[i]);
            map.put(s, list);
        }

        for(String k: map.keySet()){
            res.add(map.get(k));
        }
        return res;
    }

    /*---- Problem 7: Increasing Triplet Subsequence ------*/
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=first) first=nums[i];
            else if(nums[i]<=second) second = nums[i];
            else return true;
        }
        
        return false;
        
    }

    /*---- Problem 8: Jump Game II ------*/
    public int jump(int[] nums) {
        int n = nums.length-1;
        int maxFar =0, currEnd=0, jump =0;
        for(int i=0;i<n;i++){
           maxFar = Math.max(maxFar, i+nums[i]);
           if(maxFar>=n) return jump+1;

           if(i==currEnd){
            jump+=1;
            currEnd = maxFar;
           }
        }

        return jump;
    }

    /*---- Problem 9: Candy ------*/

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] cans = new int[n];
        
        Arrays.fill(cans, 1);

        for (int i=1;i<n;i++){
            if (ratings[i]>ratings[i-1]) cans[i] = cans[i-1]+1;
        }

        for (int i=n-2;i>=0;i--){
            if (ratings[i]>ratings[i+1] && cans[i]<=cans[i+1]) cans[i] = cans[i+1]+1;
        }

        int res=0;
        for (int i=0;i<n;i++){
            System.out.print(cans[i] + " ");
            res+=cans[i];
        }

        return res;
    }

    /*---- Problem 10: Remove Boxes ------*/
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];

        return removeBoxHelper(boxes, 0, n-1, 0, dp);
    }

    private int removeBoxHelper(int[] boxes, int i, int j, int k, int[][][] dp){
        if(i>j) return 0;
        if(dp[i][j][k]>0) return dp[i][j][k];

        int i0=i, k0=k;
        for(;i+1<=j && boxes[i+1] == boxes[i]; i++, k++);

        int res = (k+1)*(k+1) + removeBoxHelper(boxes, i+1, j, 0, dp);

        for(int m=i+1; m<=j;m++){
            if(boxes[i]==boxes[m]){
                res = Math.max(res, removeBoxHelper(boxes, i+1, m-1, 0, dp) +removeBoxHelper(boxes, m, j, k+1, dp));
            }
        }
        dp[i0][j][k0] = res;
        return res;
    }
    
}
