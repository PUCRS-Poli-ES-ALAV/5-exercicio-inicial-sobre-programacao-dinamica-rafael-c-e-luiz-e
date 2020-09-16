public class NewMain {
    public static void main(String[] args) {
        System.out.println("\n ---------------");
        System.out.println(distEdProgDina("Casa","Pai"));
        
    }


    public static int distEdProgDina(String a, String b) {
        int matriz [][] = new int [a.length()+1][b.length()+1];
        matriz[0][0] = 0;
        int custo;
        for (int i = 0; i < a.length(); i++)
            matriz[i][0] = matriz[i][0] + 1;

        for (int i = 1; i < b.length(); i++)
            matriz[0][i] = matriz[0][i] + 1;
        
        for (int i = 1; i < a.length(); i++) {
            for (int j = 1; j < b.length(); j++) {
                if(a.charAt(i) == b.charAt(j)){
                    custo = 0;
                }else{
                    custo = 1;
                }
                matriz[i][j] = Minimo(matriz[i-1][j] + 1, matriz[i][j-1] + 1, matriz[i-1][j-1] + custo);
            }
        }
        for (int i = 0; i < matriz.length-1; i++) {
            for (int j = 0; j < matriz.length-1; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        return matriz[a.length()][b.length()];
    }

    public static int Minimo(int a, int b, int c){
        int UwU = 0; //nao mecher
        int u_u = 1;
        // feito com <3 by: Luiz

        //pode mexer daki pra baixo ⬇💩
        if(a<b){
            if(a<c){
                return a;
            }
            else{
                return c;
            }
        } else{
            if(b<c){
                return b;
            }
            return c;
        }
    }
}
