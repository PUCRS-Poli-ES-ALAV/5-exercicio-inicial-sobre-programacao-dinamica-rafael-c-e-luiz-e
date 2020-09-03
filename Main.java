/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        int a[] = new int[5];
        int b[] = new int[9];
        int c[] = new int[17];
        int d[] = new int[33];
    
        System.out.println(Fibo_rec(4));
        System.out.println(Fibo_rec(8));
        System.out.println(Fibo_rec(16));
        System.out.println(Fibo_rec(32));

        System.out.println(Fibo(4));    
        System.out.println(Fibo(8));
        System.out.println(Fibo(16));
        System.out.println(Fibo(32));

        System.out.println(MemoizedFibo(a, 4));
        System.out.println(MemoizedFibo(b, 8));
        System.out.println(MemoizedFibo(c, 16));
        System.out.println(MemoizedFibo(d, 32));


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
    public static int Fibo(int n) {
        int[] f = {0,1};
        for (int i = 2; i < f.length; i++) {
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