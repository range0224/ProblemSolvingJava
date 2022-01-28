import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int n, m;
    static char arr[][] = new char[510][510];
    static boolean near[][] = new boolean[510][510];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int sx, sy;
    static int ex, ey;
    static int dist[][] = new int[510][510];
    static boolean inque[][] = new boolean[510][510];

    public static boolean in_range(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        int x, y;
        int nx, ny;
        int nd;
        Queue<int[]> que = new LinkedList<>();

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            str = sc.next();
            for(int j = 0; j < m; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < 4; k++){
                    nx = i + dx[k];
                    ny = j + dy[k];

                    if(in_range(nx, ny) && arr[nx][ny] == '#') near[i][j] = true;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 'S'){
                    sx = i;
                    sy = j;
                    arr[i][j] = '.';
                }else if(arr[i][j] == 'E'){
                    ex = i;
                    ey = j;
                    arr[i][j] = '.';
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist[i][j] = 100000000;
            }
        }

        dist[sx][sy] = 0;
        que.add(new int[]{sx, sy});
        while(!que.isEmpty()){
            x = que.peek()[0];
            y = que.peek()[1];
            que.poll();

            inque[x][y] = false;

            for(int i = 0; i < 4; i++){
                nx = x + dx[i];
                ny = y + dy[i];

                if(!in_range(nx, ny) || arr[nx][ny] == '#') continue;

                if(near[x][y] && near[nx][ny]) nd = dist[x][y];
                else nd = dist[x][y] + 1;

                if(dist[nx][ny] > nd){
                    dist[nx][ny] = nd;
                    if(!inque[nx][ny]){
                        que.add(new int[]{nx, ny});
                        inque[nx][ny] = true;
                    }
                }
            }
        }

        System.out.print(dist[ex][ey]);
    }
}
