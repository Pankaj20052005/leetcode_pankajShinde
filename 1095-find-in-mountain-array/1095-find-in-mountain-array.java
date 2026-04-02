/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        int left = binarySearch(mountainArr, target, 0, peak, true);
        if(left != -1){
            return left;
        }

        return binarySearch(mountainArr, target, peak+1, mountainArr.length()-1, false);
    }

    static int findPeak(MountainArray mountainArr){
        int low = 0;
        int high = mountainArr.length()-1;

        while(low < high){
            int mid = low + (high - low) / 2;
            if(mountainArr.get(mid) < mountainArr.get(mid+1)){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
    static int binarySearch(MountainArray mountainArr, int target, int low, int high, boolean asc){
        while(low <= high){
            int mid = low + (high - low)/2;
            int val = mountainArr.get(mid);

            if(val == target){
                return mid;
            }

            if(asc){
                if(val < target) low = mid+1;
                else high = mid-1;
            }else{
                if(val < target) high = mid-1;
                else low = mid+1;
            }
        }
        return -1;
    }
}