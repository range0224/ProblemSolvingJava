import java.util.Scanner;

public class Main {
    static int n, m;
    static int arr[][] = new int[210][210];
    static int par[] = new int[210];

    public static int find(int x){
        if(par[x] == x) return x;
        else return par[x] = find(par[x]);
    }

    public static void union_(int a, int b){
        a = find(a);
        b = find(b);

        par[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int prv, cur;

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++) par[i] = i;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(sc.nextInt() == 1) union_(i, j);
            }
        }

        prv = sc.nextInt();
        for(int i = 1; i < m; i++){
            cur = sc.nextInt();

            if(find(prv) != find(cur)){
                System.out.print("NO");
                return;
            }
            prv = cur;
        }

        System.out.print("YES");
    }
}
