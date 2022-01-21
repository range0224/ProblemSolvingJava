import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int n, m;
    static int arr[][] = new int[110][110];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static boolean in_range(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<int[]> que = new LinkedList<>();
        int x, y;
        int nx, ny;
        int dist[][] = new int[110][110];
        int mx, cnt;

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist[i][j] = 10000000;
            }
        }

        dist[0][0] = 0;
        que.add(new int[]{0, 0});
        while(!que.isEmpty()){
            x = que.peek()[0];
            y = que.peek()[1];
            que.poll();

            for(int i = 0; i < 4; i++){
                nx = x + dx[i];
                ny = y + dy[i];

                if(!in_range(nx, ny) || dist[nx][ny] <= dist[x][y] + arr[nx][ny]) continue;

                dist[nx][ny] = dist[x][y] + arr[nx][ny];
                que.add(new int[]{nx, ny});
            }
        }

        mx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                mx = Math.max(mx, dist[i][j]);
            }
        }

        cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 1 && dist[i][j] == mx) cnt++;
            }
        }

        System.out.println(mx);
        System.out.print(cnt);
    }
}
