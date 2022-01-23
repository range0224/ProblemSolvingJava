import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    static int n, m;
    static ArrayList<int[]> v = new ArrayList<>();
    static int par[] = new int[100010];

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
        int a, b, c;
        int s, e;

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < m; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();

            v.add(new int[]{a, b, c});
        }
        s = sc.nextInt();
        e = sc.nextInt();

        Collections.sort(v, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return Integer.compare(a[2], b[2]);
            }
        });

        for(int i = 1; i <= n; i++) par[i] = i;

        for(int i = m - 1; i >= 0; i--){
            union_(v.get(i)[0], v.get(i)[1]);

            if(find(s) == find(e)){
                System.out.print(v.get(i)[2]);
                return;
            }
        }
    }
}
