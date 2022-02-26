import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int n, m;
    static int arr[][] = new int[110][110];
    static boolean visited[][][] = new boolean[110][110][4];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int change[] = {0, 1, 3, 0, 2};
    static int ex, ey, edir;

    public static boolean in_range(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x, y, dir;
        int nx, ny, ndir;
        Queue<int[]> que = new LinkedList<>();
        int size;
        int d;

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        x = sc.nextInt() - 1;
        y = sc.nextInt() - 1;
        dir = change[sc.nextInt()];
        ex = sc.nextInt() - 1;
        ey = sc.nextInt() - 1;
        edir = change[sc.nextInt()];

        d = 0;
        que.add(new int[]{x, y, dir});
        visited[x][y][dir] = true;
        while(!que.isEmpty()){
            size = que.size();
            while(size-->0) {
                x = que.peek()[0];
                y = que.peek()[1];
                dir = que.peek()[2];
                que.poll();

                if(x == ex && y == ey && dir == edir){
                    System.out.print(d);
                    return;
                }

                for(int i = 1; i <= 3; i++){
                    nx = x + i * dx[dir];
                    ny = y + i * dy[dir];

                    if(!in_range(nx, ny) || visited[nx][ny][dir]) continue;
                    if(arr[nx][ny] == 1) break;

                    que.add(new int[]{nx, ny, dir});
                    visited[nx][ny][dir] = true;
                }
                for(int i = 1; i <= 3; i += 2){
                    ndir = (dir + i) % 4;

                    if(visited[x][y][ndir]) continue;

                    que.add(new int[]{x, y, ndir});
                    visited[x][y][ndir] = true;
                }
            }
            d++;
        }
    }
}
