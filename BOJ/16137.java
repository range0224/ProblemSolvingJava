import java.util.Scanner;

public class Main {
    static int n, m;
    static int arr[][] = new int[20][20];
    static long dist[][][] = new long[20][20][2];
    static boolean visited[][][] = new boolean[20][20][2];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static boolean in_range(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y){
        int px, py;
        int nx, ny;

        for(int i = 0; i < 2; i++){
            px = x + dx[i];
            py = y + dy[i];
            nx = x - dx[i];
            ny = y - dy[i];

            if((!in_range(nx, ny) || arr[nx][ny] != 0) && (!in_range(px, py) || arr[px][py] != 0)) return true;
        }

        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long mn;
        int x, y, v;
        int nx, ny;
        long nd;

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dist[i][j][0] = 1L << 60;
                dist[i][j][1] = 1L << 60;
            }
        }

        dist[0][0][0] = 0;
        while(true){
            mn = 1L << 60;
            x = 0;
            y = 0;
            v = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    for(int k = 0; k < 2; k++){
                        if(!visited[i][j][k] && mn > dist[i][j][k]){
                            mn = dist[i][j][k];
                            x = i;
                            y = j;
                            v = k;
                        }
                    }
                }
            }

            if(mn == (1L << 60)) break;

            visited[x][y][v] = true;

            for(int i = 0; i < 4; i++){
                nx = x + dx[i];
                ny = y + dy[i];

                if(!in_range(nx, ny)) continue;

                if(arr[nx][ny] == 1){
                    if(dist[nx][ny][v] > dist[x][y][v] + 1){
                        dist[nx][ny][v] = dist[x][y][v] + 1;
                    }
                } else if (arr[nx][ny] == 0) {
                    if(v == 1) continue;

                    if(!canGo(nx, ny)) continue;

                    nd = 0;
                    for(long j = 0; j <= dist[x][y][v]; j += m){
                        nd = j + m;
                    }

                    if(dist[nx][ny][v + 1] > nd){
                        dist[nx][ny][v + 1] = nd;
                    }
                } else{
                    if(arr[x][y] != 1) continue;

                    nd = 0;
                    for(long j = 0; j <= dist[x][y][v]; j += arr[nx][ny]){
                        nd = j + arr[nx][ny];
                    }

                    if(dist[nx][ny][v] > nd){
                        dist[nx][ny][v] = nd;
                    }
                }
            }
        }

        System.out.print(Math.min(dist[n - 1][n - 1][0], dist[n - 1][n - 1][1]));
    }
}
