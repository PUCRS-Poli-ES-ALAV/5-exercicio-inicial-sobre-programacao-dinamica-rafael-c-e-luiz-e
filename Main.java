/**
 * Main
 */
public class Main {
    static int COUNT = 0;
    public static void main(String[] args) {
        int a[] = new int[5];
        int b[] = new int[9];
        int c[] = new int[17];
        int d[] = new int[33];
        int e[] = new int[129];
        int f[] = new int[1001];
        int g[] = new int[10001];


        COUNT = 0;
        System.out.println("\nFibo rec 4 -------------- " +Fibo_rec(4));
        System.out.println("Iterações: " + COUNT);
        System.out.println("\n");

        COUNT = 0;
        System.out.println("Fibo rec 8-------------- " + Fibo_rec(8));
        System.out.println("Iterações: " + COUNT);
        System.out.println("\n");

        COUNT = 0;
        System.out.println("Fibo rec 16-------------- " + Fibo_rec(16));
        System.out.println("Iterações: " + COUNT);
        System.out.println("\n");

        COUNT = 0;
        System.out.println("Fibo rec 32 -------------- " + Fibo_rec(32));
        System.out.println("Iterações: " + COUNT);
        System.out.println("\n");

        COUNT = 0;
        System.out.println("Fibo 4 -------------- " + Fibo(a, 4));
        System.out.println("Iterações: " + COUNT);
        System.out.println("\n");

        COUNT = 0;
        System.out.println("Fibo 8 -------------- " + Fibo(b, 8));
        System.out.println("Iterações: " + COUNT);
        System.out.println("\n");

        COUNT = 0;
        System.out.println("Fibo 16 -------------- " + Fibo(c, 16));
        System.out.println("Iterações: " + COUNT);
        System.out.println("\n");

        COUNT = 0;
        System.out.println("Fibo 32 -------------- " + Fibo(d, 32));
        System.out.println("Iterações: " + COUNT);
        System.out.println("\n");


        a = new int[5];
        b = new int[9];
        c = new int[17];
        d = new int[33];
        e = new int[129];
        f = new int[1001];
        g = new int[10001];

        COUNT = 0;
        System.out.println("Memoized Fibo 4 -------------- " + MemoizedFibo(a, 4));
        System.out.println("Iterações: " + COUNT);
        System.out.println("\n");

        COUNT = 0;
        System.out.println("Memoized Fibo 8 -------------- " + MemoizedFibo(b, 8));
        System.out.println("Iterações: " + COUNT);
        System.out.println("\n");

        COUNT = 0;
        System.out.println("Memoized Fibo 16 -------------- " + MemoizedFibo(c, 16));
        System.out.println("Iterações: " + COUNT);
        System.out.println("\n");

        COUNT = 0;
        System.out.println("Memoized Fibo 32 -------------- " + MemoizedFibo(d, 32));
        System.out.println("Iterações: " + COUNT);
        System.out.println("\n");

        COUNT = 0;
        System.out.println("Memoized Fibo 128 -------------- " + MemoizedFibo(e, 128));
        System.out.println("Iterações: " + COUNT);
        System.out.println("\n");

        COUNT = 0;
        System.out.println("Memoized Fibo 1000 -------------- " + MemoizedFibo(f, 1000));
        System.out.println("Iterações: " + COUNT);
        System.out.println("\n");

        COUNT = 0;
        System.out.println("Memoized Fibo 10.000 -------------- " + MemoizedFibo(g, 10000));
        System.out.println("Iterações: " + COUNT);
        System.out.println("\n");



        Block block[] = {
                new Block(10, 60),
                new Block(20, 100),
                new Block(30, 120),
                new Block(50, 200)

        };
        COUNT = 0;
        System.out.println("Sack: " + knapSack(block, 70, block.length));
        System.out.println("Iterações: " + COUNT + "\n");


    }

    // 1 ----------------------------------------------------------------
    public static int Fibo_rec(int n) {
        COUNT++;
        int a;
        int b;
        if (n <= 1)
            return n;
        else {
            a = Fibo_rec(n - 1);
            b = Fibo_rec(n - 2);
        }
        return (a + b);
    }

    // 2 ----------------------------------------------------------------
    public static int Fibo(int f[], int n) {
        COUNT++;
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            COUNT++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    // 3 ----------------------------------------------------------------
    public static int MemoizedFibo(int f[], int n) {
        COUNT++;
        for (int i = 0; i <= n; i++) {
            COUNT++;
            f[i] = -1;
        }
        return LookUpFibo(f, n);
    }

    public static int LookUpFibo(int f[], int n) {
        COUNT++;
        if (f[n] >= 0) {
            return f[n];
        }
        if (n <= 1) {
            f[n] = n;
        } else {
            f[n] = LookUpFibo(f, n - 1) + LookUpFibo(f, n - 2);
        }
        return f[n];
    }

    // knapSack ----------------------------------------------------------------

    public static int knapSack(Block[] block, int mWeight, int mValue) {
        COUNT++;
        if ( mValue <= 0 || mWeight <= 0) {
            return 0;
        }

        int[][] sack = new int[mValue + 1][mWeight + 1];
        for (int j = 0; j <= mWeight; j++) {
            COUNT++;
            sack[0][j] = 0;
        }

        for (int i = 1; i <= mValue; i++) {
            COUNT++;
            for (int j = 1; j <= mWeight; j++) {
                COUNT++;
                if (block[i -1].weight > j) {
                    sack[i][j] = sack[i -1][j];
                } else {
                    sack[i][j] = Math.max(
                            sack[i -1][j],
                            sack[i -1][j - block[i -1].weight] + block[i -1].value);
                }
            }
        }
        return sack[mValue][mWeight];
    }


    public static class Block {
        public int weight;
        public int value;

        public Block(int weight, int value){
            this.weight = weight;
            this.value = value;
        }

    }
}
