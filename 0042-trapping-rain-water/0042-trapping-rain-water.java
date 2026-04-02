class Solution {
    public int trap(int[] height) {
        int len = height.length;
        
        int[] lmax = new int[len];
        int[] rmax = new int[len];

        lmax[0] = height[0];
        rmax[len - 1] = height[len - 1];

        // Fill lmax
        for (int i = 1; i < len; i++) {
            lmax[i] = Math.max(lmax[i - 1], height[i]);
        }

        // Fill rmax
        for (int i = len - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], height[i]);
        }

        int water = 0;
        for (int i = 0; i < len; i++) {
            water += Math.min(lmax[i], rmax[i]) - height[i];
        }

        return water;
    }
}