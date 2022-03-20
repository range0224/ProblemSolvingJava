import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int n, m;
    static int arr[][] = new int[210][210];
    static Queue<int[]> que[] = new LinkedList[1010];
    static int s, ex, ey;
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static boolean in_range(int x, int y){
        return x >= 1 && x <= n && y >= 1 && y <= n;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x, y;
        int nx, ny;
        int size;

        for(int i = 0; i < 1010; i++) que[i] = new LinkedList<>();

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        s = sc.nextInt();
        ex = sc.nextInt();
        ey = sc.nextInt();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                que[arr[i][j]].add(new int[]{i, j});
            }
        }

        while(s-->0){
            for(int i = 1; i <= m; i++){
                size = que[i].size();
                while(size-->0){
                    x = que[i].peek()[0];
                    y = que[i].peek()[1];
                    que[i].poll();

                    for(int j = 0; j < 4; j++){
                        nx = x + dx[j];
                        ny = y + dy[j];

                        if(!in_range(nx, ny) || arr[nx][ny] != 0) continue;

                        arr[nx][ny] = i;
                        que[i].add(new int[]{nx, ny});
                    }
                }
            }
        }

        System.out.print(arr[ex][ey]);
    }
}
