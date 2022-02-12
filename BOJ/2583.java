import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n, m, k;
    static int arr[][] = new int[110][110];
    static boolean visited[][] = new boolean[110][110];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static boolean in_range(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static int dfs(int x, int y){
        int nx, ny;
        int ret = 1;

        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(in_range(nx, ny) && !visited[nx][ny] && arr[nx][ny] == 0) ret += dfs(nx, ny);
        }

        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c, d;
        ArrayList<Integer> v = new ArrayList<>();

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        while(k-->0){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            d = sc.nextInt();

            for(int i = b; i < d; i++){
                for(int j = a; j < c; j++){
                    arr[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && arr[i][j] == 0){
                    v.add(dfs(i, j));
                }
            }
        }

        Collections.sort(v);

        System.out.println(v.size());
        for(int i = 0; i < v.size(); i++){
            System.out.print(v.get(i) + " ");
        }
    }
}
