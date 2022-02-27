import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int n, m;
    static char arr[][] = new char[30][30];
    static int p[][] = new int[20][2];
    static int dist[][] = new int[20][20];
    static int d[][] = new int[30][30];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static boolean visited[] = new boolean[30];
    static int idx;
    static int ans;

    public static boolean in_range(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void bfs(int x, int y){
        int nx, ny;
        Queue<int[]> que = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                d[i][j] = 1000000;
            }
        }

        d[x][y] = 0;
        que.add(new int[]{x, y});
        while(!que.isEmpty()){
            x = que.peek()[0];
            y = que.peek()[1];
            que.poll();

            for(int i = 0; i < 4; i++){
                nx = x + dx[i];
                ny = y + dy[i];

                if(!in_range(nx, ny) || d[nx][ny] <= d[x][y] + 1 || arr[nx][ny] == 'x') continue;

                d[nx][ny] = d[x][y] + 1;
                que.add(new int[]{nx, ny});
            }
        }
    }

    public static void recur(int cur, int cnt, int sum){
        if(cnt == idx - 1){
            ans = Math.min(ans, sum);
            return;
        }

        for(int i = 1; i < idx; i++){
            if(visited[i]) continue;

            visited[i] = true;
            recur(i, cnt + 1, sum + dist[cur][i]);
            visited[i] = false;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s;

        while(true){
            m = sc.nextInt();
            n = sc.nextInt();

            if(n == 0 && m == 0) break;

            for(int i = 0; i < n; i++){
                s = sc.next();
                for(int j = 0; j < m; j++){
                    arr[i][j] = s.charAt(j);
                }
            }

            idx = 1;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(arr[i][j] == '*') {
                        p[idx][0] = i;
                        p[idx][1] = j;
                        idx++;
                    } else if(arr[i][j] == 'o'){
                        p[0][0] = i;
                        p[0][1] = j;
                    }
                }
            }

            for(int i = 0; i < idx; i++){
                bfs(p[i][0], p[i][1]);
                for(int j = 1; j < idx; j++){
                    dist[i][j] = d[p[j][0]][p[j][1]];
                }
            }

            ans = 1000000;
            recur(0, 0, 0);

            if(ans == 1000000) ans = -1;

            System.out.println(ans);
        }
    }
}
