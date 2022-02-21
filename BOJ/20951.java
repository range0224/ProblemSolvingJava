import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static final int MOD = 1000000007;
    static int n, m;
    static ArrayList<Integer> v[] = new ArrayList[100010];
    static long dp[][] = new long[100010][10];

    public static long dfs(int cur, int cnt){
        long ret = 0;

        if(cnt == 7) return 1;

        if(dp[cur][cnt] != -1) return dp[cur][cnt];

        for(int i = 0; i < v[cur].size(); i++){
            ret += dfs(v[cur].get(i), cnt + 1);
            ret %= MOD;
        }

        dp[cur][cnt] = ret;
        return ret;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a, b;
        long ans;

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++) v[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            v[a].add(b);
            v[b].add(a);
        }

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < 10; j++){
                dp[i][j] = -1;
            }
        }

        ans = 0;
        for(int i = 1; i <= n; i++){
            ans += dfs(i, 0);
            ans %= MOD;
        }

        System.out.print(ans);
    }
}
