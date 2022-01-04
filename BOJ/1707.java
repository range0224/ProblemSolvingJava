import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static int n, m;
    static ArrayList<Integer> v[];
    static boolean ans;
    static int color[];

    public static void dfs(int cur, int c){
        int nxt;

        color[cur] = c;

        for(int i = 0; i < v[cur].size(); i++){
            nxt = v[cur].get(i);

            if(color[nxt] == c) {
                ans = false;
                return;
            } else if(color[nxt] == -1){
                dfs(nxt, c ^ 1);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t;
        int a, b;

        t = sc.nextInt();
        while(t-->0){
            n = sc.nextInt();
            m = sc.nextInt();

            v = new ArrayList[n + 1];
            for(int i = 1; i <= n; i++) v[i] = new ArrayList<>();

            for(int i = 0; i < m; i++){
                a = sc.nextInt();
                b = sc.nextInt();

                v[a].add(b);
                v[b].add(a);
            }

            color = new int[n + 1];
            for(int i = 1; i <= n; i++) color[i] = -1;

            ans = true;
            for(int i = 1; i <= n; i++){
                if(color[i] == -1) dfs(i, 1);
            }

            if(ans) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
