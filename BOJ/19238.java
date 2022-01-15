import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {
    static int n, m, k;
    static int arr[][] = new int[30][30];
    static int x, y;
    static int p[][] = new int[500][4];
    static int pnum[][] = new int[30][30];
    static ArrayList<int[]> v = new ArrayList<>();
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static boolean in_range(int x, int y){
        return x >= 1 && x <= n && y >= 1 && y <= n;
    }

    public static void getList(){
        Queue<int[]> que = new LinkedList<>();
        boolean visited[][] = new boolean[30][30];
        int size;
        int d;
        int tx, ty;
        int nx, ny;

        v.clear();
        d = 0;
        visited[x][y] = true;
        que.add(new int[]{x, y});
        while(!que.isEmpty()){
            size = que.size();
            while(size-->0){
                tx = que.peek()[0];
                ty = que.peek()[1];
                que.poll();

                if(pnum[tx][ty] != 0){
                    v.add(new int[]{tx, ty, d});
                }

                for(int i = 0; i < 4; i++){
                    nx = tx + dx[i];
                    ny = ty + dy[i];

                    if(!in_range(nx, ny) || arr[nx][ny] == 1 || visited[nx][ny]) continue;

                    que.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }

            if(!v.isEmpty()) break;
            d++;
        }
    }

    public static int get_dist(int sx, int sy, int ex, int ey){
        Queue<int[]> que = new LinkedList<>();
        boolean visited[][] = new boolean[30][30];
        int tx, ty;
        int nx, ny;
        int size;
        int d;

        que.add(new int[]{sx, sy});
        visited[sx][sy] = true;
        d = 0;
        while(!que.isEmpty()){
            size = que.size();
            while(size-->0){
                tx = que.peek()[0];
                ty = que.peek()[1];
                que.poll();

                if(tx == ex && ty == ey) return d;

                for(int i = 0; i < 4; i++){
                    nx = tx + dx[i];
                    ny = ty + dy[i];

                    if(!in_range(nx, ny) || arr[nx][ny] == 1 || visited[nx][ny]) continue;

                    que.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }

            d++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tx, ty;
        int idx;
        int d;

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        x = sc.nextInt();
        y = sc.nextInt();
        for(int i = 1; i <= m; i++){
            for(int j = 0; j < 4; j++){
                p[i][j] = sc.nextInt();
            }

            pnum[p[i][0]][p[i][1]] = i;
        }

        for(int i = 0; i < m; i++){
            getList();

            if(v.isEmpty()){
                System.out.print(-1);
                return;
            }

            tx = 100000;
            ty = 0;
            for(int j = 0; j < v.size(); j++){
                if(tx > v.get(j)[0] || (tx == v.get(j)[0] && ty > v.get(j)[1])){
                    tx = v.get(j)[0];
                    ty = v.get(j)[1];
                }
            }

            idx = pnum[tx][ty];
            d = get_dist(p[idx][0], p[idx][1], p[idx][2], p[idx][3]);

            if(d == -1 || k < v.get(0)[2] + d){
                System.out.print(-1);
                return;
            }

            k += d - v.get(0)[2];
            x = p[idx][2];
            y = p[idx][3];
            pnum[tx][ty] = 0;
        }

        System.out.print(k);
    }
}
