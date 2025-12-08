package DatastructuresAndAlgorithms.Recursion;

public class Factorial {

    void main() {
        System.out.println(factorial(6));
    }

    public int factorial(int n){

        if(n <= 1){
            return 1;
        }
        return n * factorial(n - 1);
    }
}
