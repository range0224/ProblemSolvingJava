import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static int n;
    static int arr[] = new int[20];
    static ArrayList<Integer> v[] = new ArrayList[20];
    static boolean sel[] = new boolean[20];
    static boolean visited[] = new boolean[20];
    static int total;
    static int ans;

    public static int dfs(int cur){
        int ret = 1;

        visited[cur] = true;
        for(int i = 0; i < v[cur].size(); i++){
            if(visited[v[cur].get(i)] || sel[cur] != sel[v[cur].get(i)]) continue;

            ret += dfs(v[cur].get(i));
        }

        return ret;
    }

    public static void recur(int cur, int cnt, int sum){
        if(cur == n + 1){
            if(cnt == 0 || cnt == n) return;

            for(int i = 1; i <= n; i++) visited[i] = false;

            for(int i = 1; i <= n; i++){
                if(visited[i]) continue;

                if(sel[i] && dfs(i) != cnt) return;
                if(!sel[i] && dfs(i) != n - cnt) return;
            }

            ans = Math.min(ans, Math.abs(sum - (total - sum)));

            return;
        }

        sel[cur] = true;
        recur(cur + 1, cnt + 1, sum + arr[cur]);
        sel[cur] = false;
        recur(cur + 1, cnt, sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        int a;

        for(int i = 1; i <= 10; i++) v[i] = new ArrayList<>();

        n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 1; i <= n; i++) {
            x = sc.nextInt();
            for(int j = 0; j < x; j++){
                a = sc.nextInt();

                v[i].add(a);
            }
        }

        for(int i = 1; i <= n; i++) total += arr[i];

        ans = 1 << 30;
        recur(1, 0, 0);

        if(ans == (1 << 30)) ans = -1;
        
        System.out.print(ans);
    }
}
