import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int dp[][] = new int[1010][1010];

    public static int recur(int cur, int idx, int n, int m, int arr[], int arr2[]){
        if(cur == n) return 0;

        if(dp[cur][idx] != -1) return dp[cur][idx];

        dp[cur][idx] = 10000000;
        for(int i = idx; i < m; i++){
            dp[cur][idx] = Math.min(dp[cur][idx], recur(cur + 1, i + 1, n, m, arr, arr2) + Math.abs(arr[cur] - arr2[i]));
        }

        return dp[cur][idx];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        int arr[];
        int arr2[];

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        arr2 = new int[m];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < m; i++){
            arr2[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        Arrays.sort(arr2);

        for(int i = 0; i < 1010; i++){
            for(int j = 0; j < 1010; j++){
                dp[i][j] = -1;
            }
        }

        if(n <= m) System.out.print(recur(0, 0, n, m, arr, arr2));
        else System.out.print(recur(0, 0, m, n, arr2, arr));
    }
}
