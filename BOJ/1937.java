import java.util.Scanner;

public class Main {
    static int n;
    static int arr[][] = new int[510][510];
    static int dp[][] = new int[510][510];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static boolean in_range(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static int recur(int x, int y){
        int i;
        int nx, ny;
        int ret = 1;

        if(dp[x][y] != 0) return dp[x][y];

        for(i = 0; i < 4; i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(in_range(nx, ny) && arr[x][y] < arr[nx][ny]){
                ret = Math.max(ret, recur(nx, ny) + 1);
            }
        }

        return dp[x][y] = ret;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i, j;
        int ans;

        n = sc.nextInt();
        for(i = 0; i < n; i++){
            for(j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        ans = 0;
        for(i = 0; i < n; i++){
            for(j = 0; j < n; j++){
                ans = Math.max(ans, recur(i, j));
            }
        }

        System.out.print(ans);
    }
}
