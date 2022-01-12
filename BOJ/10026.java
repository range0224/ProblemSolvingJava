import java.util.Scanner;

public class Main {
    static int n;
    static char arr[][] = new char[110][110];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static boolean visited[][] = new boolean[110][110];

    public static boolean in_range(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void dfs(int x, int y){
        int nx, ny;

        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(in_range(nx, ny) && !visited[nx][ny] && arr[x][y] == arr[nx][ny]) dfs(nx, ny);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        int cnt;

        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            str = sc.next();
            for(int j = 0; j < n; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        System.out.print(cnt + " ");

        cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                visited[i][j] = false;
                if(arr[i][j] == 'G') arr[i][j] = 'R';
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }
}
