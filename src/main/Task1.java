package main;

public class Task1{

    private int pairs;

    public Task1(int p){
        pairs = p;
    }
    /**
     * Starting point for computing valid combinations
     */
    public int computeValid(){
        
        int valid = 0;
        
        valid = countValid("", 0);
        return valid;
    }
    /**
     * Recursive method that generates all posible
     * combinations for the given number of brace pairs
     * @param cur - current string in the generation chain
     * @param valid - accumulator
     * @return - total number of valid combinations
     */
    private int countValid(String cur, int valid){

        int left = 0;
        int right = 0;
        int len = cur.length();

        if (cur.length() < pairs * 2){
            //Defining amount of left/right braces
            for (int i = 0; i < len; i++){
                if (cur.charAt(i) == '('){
                    left++;
                }else if (cur.charAt(i) == ')'){
                    right++;
                }
            }
            if (left < pairs){
                valid = countValid(cur.concat("("), valid);
            }
            if (right < pairs){
                valid = countValid(cur.concat(")"), valid);
            }
        }
        if (len == pairs * 2 && checkValid(cur)){
            //System.out.println(cur);
            return ++valid;
        }else{
            return valid;
        }
    }
    /**
     * Method checks whether the combination of braces is valid
     * @param str
     * @return
     */
    private boolean checkValid(String str){

        int len = str.length();
        int total = 0;

        for (int i = 0; i < len; i++){
            if (str.charAt(i) == '('){
                total++;
            }else if (str.charAt(i) == ')'){
                total--;
            }
            if (total < 0){
                return false;
            }
        }
        return total == 0;
    }
}