package task1;

import java.util.Scanner;

/**
 * Created by anderson on 09/05/17.
 */
public class Solution {

    public static final int LOW_LIMIT = 1;
    public static final int TOP_LIMIT = 1000;

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Receive the input
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        solution.solution(number);
    }

    public void solution(int N){
        // Validate input
        validateInput(N);

        // Iterate print the results
        for (int i = 1; i <= N; i++){
            boolean replaced = false;
            if (isDivisibleByThree(i)) {
                replaced = true;
                System.out.print("Fizz");
            }
            if (isDivisibleByFive(i)) {
                replaced = true;
                System.out.print("Buzz");
            }
            if (isDivisibleBySeven(i)){
                replaced = true;
                System.out.print("Woof");
            }

            if (replaced) {
                System.out.println();
            } else {
                System.out.println(i);
            }
        }
    }

    private static void validateInput(int number) {
        if (number < LOW_LIMIT || number > TOP_LIMIT){
            throw new RuntimeException("Invalid number! It should by between 1 and 1000!");
        }
    }

    private boolean isDivisibleByThree(int n){
        return n % 3 == 0 ? true : false;
    }

    private boolean isDivisibleByFive(int n){
        return n % 5 == 0 ? true : false;
    }

    private boolean isDivisibleBySeven(int n){
        return n % 7 == 0 ? true : false;
    }

}
