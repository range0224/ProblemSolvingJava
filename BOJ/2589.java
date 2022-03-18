import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
    static int n, m;
    static char arr[][] = new char[60][60];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static boolean in_range(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static int bfs(int x, int y){
        boolean visited[][] = new boolean[60][60];
        Queue<int[]> que = new LinkedList<>();
        int size;
        int d;
        int nx, ny;

        d = 0;
        que.add(new int[]{x, y});
        visited[x][y] = true;
        while(!que.isEmpty()){
            size = que.size();
            while(size-->0){
                x = que.peek()[0];
                y = que.peek()[1];
                que.poll();

                for(int i = 0; i < 4; i++){
                    nx = x + dx[i];
                    ny = y + dy[i];

                    if(!in_range(nx, ny) || arr[nx][ny] != 'L' || visited[nx][ny]) continue;

                    que.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
            d++;
        }

        return d - 1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s;
        int ans;

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            s = sc.next();
            for(int j = 0; j < m; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 'L') ans = Math.max(ans, bfs(i, j));
            }
        }

        System.out.print(ans);
    }
}
