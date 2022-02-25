import java.util.Scanner;

public class Main {
    static int n, m;
    static int arr[][] = new int[510][510];
    static int dp[][] = new int[510][510];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static boolean in_range(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static int recur(int x, int y){
        int ret = 0;
        int nx, ny;

        if(x == n - 1 && y == m - 1) return 1;

        if(dp[x][y] != -1) return dp[x][y];

        for(int i = 0; i < 4; i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(!in_range(nx, ny) || arr[nx][ny] >= arr[x][y]) continue;

            ret += recur(nx, ny);
        }

        return dp[x][y] = ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }

        System.out.print(recur(0, 0));
    }
}
