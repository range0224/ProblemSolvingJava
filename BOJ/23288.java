import java.util.Scanner;

public class Main {
    static int n, m;
    static int arr[][] = new int[30][30];
    static boolean visited[][] = new boolean[30][30];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int dice[] = {1, 6, 4, 3, 5, 2};
    static int ddice[][] = {{5, 4, 2, 3, 0, 1}, {2, 3, 1, 0, 4, 5}, {4, 5, 2, 3, 1, 0}, {3, 2, 0, 1, 4, 5}};
    static int x, y, dir;

    public static boolean in_range(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void rotate(){
        int temp[] = new int[6];

        for(int i = 0; i < 6; i++){
            temp[i] = dice[ddice[dir][i]];
        }

        for(int i = 0; i < 6; i++){
            dice[i] = temp[i];
        }
    }

    public static int dfs(int x, int y){
        int ret = 1;
        int nx, ny;

        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(!in_range(nx, ny) || visited[nx][ny] || arr[nx][ny] != arr[x][y]) continue;

            ret += dfs(nx, ny);
        }

        return ret;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int q;
        int nx, ny;
        int ans = 0;

        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextByte();
            }
        }

        dir = 1;
        while(q-->0){
            nx = x + dx[dir];
            ny = y + dy[dir];

            if(!in_range(nx, ny)) dir = (dir + 2) % 4;

            x += dx[dir];
            y += dy[dir];

            rotate();

            if(arr[x][y] > dice[1]) dir = (dir + 1) % 4;
            else if(arr[x][y] < dice[1]) dir = (dir + 3) % 4;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    visited[i][j] = false;
                }
            }

            ans += arr[x][y] * dfs(x, y);
        }

        System.out.print(ans);
    }
}
