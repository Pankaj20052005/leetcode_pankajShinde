class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 1; i<nums.length; i++){

            if(nums[i] == nums[i-1]){
                continue;
            }

            int curr = nums[i-1] + 1;
            while(curr < nums[i]){
                list.add(curr);
                curr++;
            }
        }

        return list;
    }
}