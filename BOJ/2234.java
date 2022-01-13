import java.util.Scanner;

public class Main {
    static int n, m;
    static int arr[][] = new int[60][60];
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {-1, 0, 1, 0};
    static boolean visited[][] = new boolean[60][60];
    static int roomNum[][] = new int[60][60];
    static int roomSize[] = new int[4000];

    public static boolean in_range(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static int dfs(int x, int y, int num){
        int ret = 1;
        int nx, ny;

        visited[x][y] = true;
        roomNum[x][y] = num;
        for(int i = 0; i < 4; i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(in_range(nx, ny) && !visited[nx][ny] && (arr[x][y] & (1 << i)) == 0) ret += dfs(nx, ny, num);
        }

        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mx;
        int mx2;
        int cnt;
        int size;
        int nx, ny;

        m = sc.nextInt();
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        mx = 0;
        cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j]){
                    size = dfs(i, j, cnt);
                    mx = Math.max(mx, size);
                    roomSize[cnt] = size;
                    cnt++;
                }
            }
        }

        mx2 = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < 4; k++){
                    nx = i + dx[k];
                    ny = j + dy[k];

                    if(in_range(nx, ny) && roomNum[i][j] != roomNum[nx][ny]){
                        mx2 = Math.max(mx2, roomSize[roomNum[i][j]] + roomSize[roomNum[nx][ny]]);
                    }
                }
            }
        }

        System.out.println(cnt);
        System.out.println(mx);
        System.out.print(mx2);
    }
}
