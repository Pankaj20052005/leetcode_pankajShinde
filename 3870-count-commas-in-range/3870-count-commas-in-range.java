class Solution {
    public int countCommas(int n) {
        // int ans = 0;
        // if(n < 1000){
        //     ans = 0;
        // }

        // else if(n >= 1000 && n <= 100000){
        //     ans = n - 999;
        // }
        
        // return ans;

        if(n >= 1000) return n - 999;

        else return 0;
    }
}