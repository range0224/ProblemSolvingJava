import java.util.Scanner;

public class Main {
    static int arr[] = new int[3];
    static int dp[][] = new int[510][510];

    public static int recur(int a, int b){
        if(dp[a][b] != -1) return dp[a][b];

        dp[a][b] = 0;
        for(int i = 0; i < 3; i++){
            if(a >= arr[i] && recur(a - arr[i], b) == 0) dp[a][b] = 1;
            if(b >= arr[i] && recur(a, b - arr[i]) == 0) dp[a][b] = 1;
        }

        return dp[a][b];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        int a, b;
        String ans = "BA";

        for(int i = 0; i < 3; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < 510; i++){
            for(int j = 0; j < 510; j++){
                dp[i][j] = -1;
            }
        }

        t = 5;
        while(t-->0){
            a = sc.nextInt();
            b = sc.nextInt();

            System.out.println(ans.charAt(recur(a, b)));
        }
    }
}
