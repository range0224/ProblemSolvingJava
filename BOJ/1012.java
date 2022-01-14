import java.util.Scanner;

public class Main {
    static int n, m;
    static int arr[][];
    static boolean visited[][];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static boolean in_range(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void dfs(int x, int y){
        int i;
        int nx, ny;

        visited[x][y] = true;
        for(i = 0; i < 4; i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(in_range(nx, ny) && arr[nx][ny] == 1 && !visited[nx][ny]) dfs(nx, ny);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        int q;
        int x, y;
        int cnt;

        t = sc.nextInt();
        while(t-->0){
            n = sc.nextInt();
            m = sc.nextInt();
            q = sc.nextInt();

            arr = new int[60][60];
            while(q-->0){
                x = sc.nextInt();
                y = sc.nextInt();

                arr[x][y] = 1;
            }

            visited = new boolean[60][60];
            cnt = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(arr[i][j] == 1 && !visited[i][j]){
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }
}
