import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);

            if(c == '(' || c == '{' || c == '['){
                st.push(c);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }

                char a = st.pop();

                if((c == ')' && a != '(') || 
                   (c == '}' && a != '{') || 
                   (c == ']' && a != '[')){
                    return false;
                }   
            }
        }

        return st.isEmpty();
    }
}