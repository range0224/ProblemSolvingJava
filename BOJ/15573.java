import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int n, m, k;
    static int arr[][] = new int[1010][1010];
    static boolean visited[][] = new boolean[1010][1010];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static int bfs(int v){
        Queue<int[]> que = new LinkedList<>();
        int x, y;
        int nx, ny;
        int cnt = 0;

        que.add(new int[]{0, 0});
        visited[0][0] = true;
        while(!que.isEmpty()){
            x = que.peek()[0];
            y = que.peek()[1];
            que.poll();

            if(x >= 1 && x <= n && y >= 1 && y <= m) cnt++;

            for(int i = 0; i < 4; i++){
                nx = x + dx[i];
                ny = y + dy[i];

                if(nx >= 0 && nx <= n && ny >= 0 && ny <= m + 1 && !visited[nx][ny] && arr[nx][ny] <= v){
                    que.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return cnt;
    }

    public static boolean check(int v){
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m + 1; j++){
                visited[i][j] = false;
            }
        }

        return bfs(v) >= k;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s, e;
        int mid;
        int ans;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        s = 0;
        e = 1000000;
        ans = 0;
        while(s <= e){
            mid = (s + e) / 2;

            if(check(mid)){
                ans = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }

        System.out.print(ans);
    }
}
