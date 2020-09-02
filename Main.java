/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        
    }

    // 1 --------------------------------
    public static int Fibo_rec(int n) {
        int a;
        int b;
        if (n <= 1)
            return n;
        else{
            a = Fibo_rec(n-1);
            b = Fibo_rec(n-2);
        }
        return (a + b);
    }
    // 2 --------------------------------
    public static int Fibo(int n) {
        int[] f = {0,1};
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i-1] - f[i-2];
        }
        return f[n];
    }

    // 3 --------------------------------



}