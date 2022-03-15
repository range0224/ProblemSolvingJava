import java.util.Scanner;

public class Main{
    static int n, m;
    static int arr[][] = new int[1010][1010];
    static int dp[][] = new int[1010][1010];

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i - 1][j - 1], dp[i][j - 1])) + arr[i][j];
            }
        }

        System.out.print(dp[n][m]);
    }
}
