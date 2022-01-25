import java.util.Scanner;

public class Main {
    static int n, m;
    static int arr[][] = new int[10][10];
    static boolean visited[][] = new boolean[10][10];
    static int ans = 0;
    static int dx[] = {0, 1};
    static int dy[] = {1, 0};

    public static boolean in_range(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void recur(int x, int y, int sum){
        int temp;

        if(y == m){
            x++;
            y = 0;
        }
        if(x == n){
            ans = Math.max(ans, sum);
            return;
        }

        if(visited[x][y]) recur(x, y + 1, sum);
        else{
            for(int dir = 0; dir < 2; dir++) {
                temp = 0;
                for (int i = 0; i < 10; i++) {
                    if (!in_range(x + i * dx[dir], y + i * dy[dir]) || visited[x + i * dx[dir]][y + i * dy[dir]]) {
                        for (int j = 0; j < i; j++) visited[x + j * dx[dir]][y + j * dy[dir]] = false;
                        break;
                    }

                    visited[x + i * dx[dir]][y + i * dy[dir]] = true;
                    temp *= 10;
                    temp += arr[x + i * dx[dir]][y + i * dy[dir]];
                    recur(x, y + 1, sum + temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            x = sc.nextInt();
            for(int j = m - 1; j >= 0; j--){
                arr[i][j] = x % 10;
                x /= 10;
            }
        }

        recur(0, 0, 0);

        System.out.print(ans);
    }
}
