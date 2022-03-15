import java.util.Scanner;

public class Main{
    static final int MOD = 1000000000;
    static int n;
    static int dp[][] = new int[110][10];

    public static int recur(int cur, int prv){
        int ret = 0;

        if(cur == n) return 1;

        if(dp[cur][prv] != -1) return dp[cur][prv];

        if(prv - 1 >= 0) ret += recur(cur + 1, prv - 1);
        if(prv + 1 <= 9) ret += recur(cur + 1, prv + 1);

        return dp[cur][prv] = ret % MOD;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int ans;

        n = sc.nextInt();

        for(int i = 0; i < 110; i++){
            for(int j = 0; j < 10; j++){
                dp[i][j] = -1;
            }
        }

        ans = 0;
        for(int i = 1; i <= 9; i++){
            ans += recur(1, i);
            ans %= MOD;
        }

        System.out.print(ans);
    }
}
