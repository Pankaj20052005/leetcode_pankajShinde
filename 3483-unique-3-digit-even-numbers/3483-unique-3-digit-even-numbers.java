import java.util.*;

class Solution {
    public int totalNumbers(int[] digits) {
        Arrays.sort(digits); 
        Set<Integer> result = new HashSet<>();
        boolean[] used = new boolean[digits.length];
        
        backtrack(digits, new ArrayList<>(), result, used);
        
        return result.size();
    }

    public void backtrack(int[] digits, List<Integer> current, Set<Integer> result, boolean[] used) {
        if (current.size() == 3) {
            if (current.get(2) % 2 == 0) {
                int num = current.get(0) * 100 + current.get(1) * 10 + current.get(2);
                result.add(num);
            }
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (used[i]) continue;

            if (i > 0 && digits[i] == digits[i - 1] && !used[i - 1]) continue;

            if (current.isEmpty() && digits[i] == 0) continue;

            used[i] = true;
            current.add(digits[i]);

            backtrack(digits, current, result, used);

            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}