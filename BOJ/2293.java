import java.util.Scanner;

public class Main {
    static int n, m;
    static int arr[] = new int[110];
    static int dp[][] = new int[2][10010];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        dp[0][0] = 1;
        dp[1][0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= m; j++){
                dp[i % 2][j] = dp[(i + 1) % 2][j];
                if(j >= arr[i]) dp[i % 2][j] += dp[i% 2][j - arr[i]];
            }
        }

        System.out.print(dp[(n - 1) % 2][m]);
    }
}
