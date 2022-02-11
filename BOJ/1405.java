import java.util.Scanner;

public class Main {
    static int n;
    static int arr[] = new int[4];
    static double ans = 0;
    static boolean visited[][] = new boolean[50][50];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {-1, 1, 0, 0};

    public static void recur(int cur, int x, int y, double sum){
        int nx, ny;

        if(cur == n){
            ans += sum;
            return;
        }

        for(int i = 0; i < 4; i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(visited[nx][ny]) continue;

            visited[nx][ny] = true;
            recur(cur + 1, nx, ny, sum * (arr[i] / 100.0));
            visited[nx][ny] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i = 0; i < 4; i++){
            arr[i] = sc.nextInt();
        }

        visited[20][20] = true;
        recur(0, 20, 20, 1);

        System.out.printf("%.12f", ans);
    }
}
