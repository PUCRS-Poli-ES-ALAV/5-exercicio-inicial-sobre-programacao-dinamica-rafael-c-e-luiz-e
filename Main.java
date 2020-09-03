/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        int a[] = new int[5];
        int b[] = new int[9];
        int c[] = new int[17];
        int d[] = new int[33];
        int e[] = new int[129];
        int f[] = new int[1001];
        int g[] = new int[10001];


    
        System.out.println("\nFibo rec 4 -------------- " +Fibo_rec(4));
        System.out.println("Fibo rec 8-------------- " + Fibo_rec(8));
        System.out.println("Fibo rec 16-------------- " + Fibo_rec(16));
        System.out.println("Fibo rec 32 -------------- " + Fibo_rec(32) + "\n");

        System.out.println("Fibo 4 -------------- " + Fibo(a, 4));    
        System.out.println("Fibo 8 -------------- " + Fibo(b, 8));
        System.out.println("Fibo 16 -------------- " + Fibo(c, 16));
        System.out.println("Fibo 32 -------------- " + Fibo(d, 32) + "\n");

        System.out.println("Memoized Fibo 4 -------------- " + MemoizedFibo(a, 4));
        System.out.println("Memoized Fibo 8 -------------- " + MemoizedFibo(b, 8));
        System.out.println("Memoized Fibo 16 -------------- " + MemoizedFibo(c, 16));
        System.out.println("Memoized Fibo 32 -------------- " + MemoizedFibo(d, 32));
        System.out.println("Memoized Fibo 128 -------------- " + MemoizedFibo(e, 128));
        System.out.println("Memoized Fibo 1000 -------------- " + MemoizedFibo(f, 1000));
        System.out.println("Memoized Fibo 10.000 -------------- " + MemoizedFibo(g, 10000) + "\n");



    }

    // 1 ----------------------------------------------------------------
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
    // 2 ----------------------------------------------------------------
    public static int Fibo(int f[], int n) {
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < n; i++) {
            f[i] = f[i-1] - f[i-2];
        }
        return f[n];
    }

    // 3 ----------------------------------------------------------------
    public static int MemoizedFibo (int f[], int n){
        for(int i=0; i<n; i++){
            f[i] = -1;
        }
        return LookUpFibo(f, n);
    }

    public static int LookUpFibo(int f[], int n){
        if(f[n] >= 0){
            return f[n];
        }
        if (n<=1){
            f[n] = n;
        }
        else{
            f[n] = LookUpFibo(f, n-1) + LookUpFibo(f, n-2);
        }
        return f[n];
    }
}