class Solution {
    public boolean checkPerfectNumber(int num) {
        List <Integer> list = new ArrayList<>();
        for( int i =1; i< num; i++){
            if(num%i == 0){
                list.add(i);
            }
        }

        int sum = 0;
        for(int factor: list){
            sum += factor;
        }

        if(sum == num){
            return true;
        }

        else{
            return false;
        }
    }
}