class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,new ArrayList<>(), candidates, target, 0);
        return result;
    }

    static void backtrack(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int index){
        if(target<0){
            return;
        }

        if(target == 0){
            result.add(new ArrayList<>(cur));
            return;
        }
        for(int i = index; i< candidates.length; i++){
            cur.add(candidates[i]);
            backtrack(result, cur, candidates, target - candidates[i], i);
            cur.remove(cur.size()-1);
        } 
    }
}