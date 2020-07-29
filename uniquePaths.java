// Time Complexity : Exponential --> O(2^(m,n))
// Space Complexity : O(M*N)   recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
 /* 
 Bruteforce:
 1. We have two decisions to make at every point --> right/down
 2. Take care of edge cases last row/column.
 */
class Solution {
    public int uniquePaths(int m, int n) {
        if(m < 2 && n < 2) return 1;
        return helper(0,0,m,n);      
    }
    private int helper(int i, int j, int m, int n){
        if(j==(n-1) && i==(m-1))
            return 0;
        if(j==(n-1) || i==(m-1))
            return 1;
        int right = helper(i+1,j,m,n);
        int down = helper(i,j+1,m,n);
        return right+down;
    }
}




// Time Complexity : O(M*N) 
// Space Complexity : O(M*N)     
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

 /* 
 DP:
 1. Bottom-up approach.
 2. At 1 st point, the number of paths to reach bottom will be --> number of paths from its right + down
 */

class Solution {
    public int uniquePaths(int m, int n) {
        if(m < 2 && n < 2) return 1;
        
        int[][] dp = new int[m][n];
      
        for(int i=m-1 ; i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==(m-1) && j==(n-1)){
                    dp[i][j] = 0;
                }
                else if(i==(m-1) || j==(n-1)){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = dp[i][j+1]+ dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
}







// Time Complexity : O(M*N) 
// Space Complexity : O(M*N)     
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

 /* 
 DP:
 1. Top-down approach.
 2. At any point, the number of paths to reach bottom will be --> number of paths from its (top + left)
 */

class Solution {
    public int uniquePaths(int m, int n) {
        if(m < 2 && n < 2) return 1;
        
        int[][] dp = new int[m][n];
      
        for(int i=0 ; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0){
                    dp[i][j] = 0;
                }
                else if(i==0 || j==0){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = dp[i][j-1]+ dp[i-1][j]; //left +top
                }
            }
        }
        return dp[m-1][n-1];
    }
}

