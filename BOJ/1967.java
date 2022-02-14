import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static int n;
    static ArrayList<int[]> v[] = new ArrayList[10010];
    static int mx, idx;

    public static void dfs(int cur, int dist, int prv){
        if(mx < dist){
            mx = dist;
            idx = cur;
        }

        for(int i = 0; i < v[cur].size(); i++){
            if(v[cur].get(i)[0] == prv) continue;

            dfs(v[cur].get(i)[0], dist + v[cur].get(i)[1], cur);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c;

        n = sc.nextInt();
        for(int i = 1; i <= n; i++) v[i] = new ArrayList<>();

        for(int i = 0; i < n - 1; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();

            v[a].add(new int[]{b, c});
            v[b].add(new int[]{a, c});
        }

        mx = -1;
        dfs(1, 0, 0);
        mx = -1;
        dfs(idx, 0, 0);

        System.out.print(mx);
    }
}
