package main;

import java.util.ArrayList;
import java.util.Objects;

public class Task3 {

    /**
     * The idea (not mine :) ) is to store
     * large number in the form of vector
     */
    private ArrayList<Integer> result;
    private int base;
    private Thread compute;
    
    public Task3(int b, boolean inBack){
        base = b;
        if (inBack){
            compute = new Thread(){
                @Override
                public void run(){
                    generateResult();
                }
            };
            compute.start();
        }else{
            generateResult();
        }
    }
    /**
     * Method breaks number into digits
     * It is important to know that number is stored
     * in the opposite order (from end to start)
     * Every digit represents amount of units in the current rank
     * (amount of ones, tens, hundreds etc. but in back order)
     */
    private void generateResult(){
        result = new ArrayList<>();
        result.add(1);
        for (int num = 1; num <= base; num++){

            int x = num;

            result.forEach(n -> result.set(result.indexOf(n), n * x));
            refactor();
            /*result.forEach(n -> System.out.print(n + " "));
            System.out.println();*/
        }
    }
    /**
     * To understand the method it is enough to know
     * that 56 ones is the same as 5 tens and 6 ones
     * or 124 ones is the same as 12 tens and 4 ones or
     * 1 hundred, 2 tens and 4 ones and so on
     * According to distributiveness:
     * if a = b + c then a * X = b * X + c * X
     */
    private void refactor(){

        int size = result.size();

        for (int n = 0; n < size; n++){
            if (result.get(n) > 10){
                if (n == size - 1){
                    result.add(result.get(n) / 10);
                    if (result.get(n + 1) > 10){
                        size++;
                    }
                }else{
                    result.set(n + 1, result.get(n + 1) + result.get(n) / 10);
                }
                result.set(n, result.get(n) % 10);
            }
        }
    }
    public ArrayList<Integer> getResult(){
        if (inProcess()){
            return new ArrayList<>();
        }else{
            return result;
        }
    }
    /**
     * Computation may work in background so
     * the method helps to define whether the result
     * is ready
     */
    public boolean inProcess(){
        return !Objects.isNull(compute) && compute.isAlive();
    }
    public int sumDigits(){
        if (inProcess()){
            return 0;
        }else{

            int res = 0;

            for (int n : result){
                res += n;
            }
            return res;
        }
    }
}
