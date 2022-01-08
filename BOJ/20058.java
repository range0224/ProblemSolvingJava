import java.util.Scanner;

public class Main {
    static int n;
    static int arr[][] = new int[100][100];
    static int tarr[][] = new int[100][100];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static boolean visited[][] = new boolean[100][100];

    public static void rotate(int sx, int ex, int sy, int ey){
        for(int i = sx; i <= ex; i++){
            for(int j = sy; j <= ey; j++){
                tarr[i][j] = arr[ex - (j - sy)][i - sx + sy];
            }
        }

        for(int i = sx; i <= ex; i++){
            for(int j = sy; j <= ey; j++){
                arr[i][j] = tarr[i][j];
            }
        }
    }

    public static boolean in_range(int x, int y){
        return x >= 0 && x < (1 << n) && y >= 0 && y < (1 << n);
    }

    public static void melt(){
        int nx, ny;
        int cnt;

        for(int i = 0; i < (1 << n); i++){
            for(int j = 0; j < (1 << n); j++){
                cnt = 0;
                for(int k = 0; k < 4; k++) {
                    nx = i + dx[k];
                    ny = j + dy[k];

                    if (in_range(nx, ny) && arr[nx][ny] > 0) cnt++;
                }

                tarr[i][j] = arr[i][j];
                if(arr[i][j] > 0 && cnt < 3) tarr[i][j]--;
            }
        }

        for(int i = 0; i < (1 << n); i++){
            for(int j = 0; j < (1 << n); j++){
                arr[i][j] = tarr[i][j];
            }
        }
    }

    public static int dfs(int x, int y){
        int ret = 1;
        int nx, ny;

        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(in_range(nx, ny) && !visited[nx][ny] && arr[nx][ny] > 0) ret += dfs(nx, ny);
        }

        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q;
        int x;
        int sum;
        int mx;

        n = sc.nextInt();
        q = sc.nextInt();
        for(int i = 0; i < (1 << n); i++){
            for(int j = 0; j < (1 << n); j++){
                arr[i][j] = sc.nextInt();
            }
        }

        while(q-->0){
            x = sc.nextInt();

            for(int i = 0; i < (1 << n); i += (1 << x)){
                for(int j = 0; j < (1 << n); j += (1 << x)){
                    rotate(i, i + (1 << x) - 1, j, j + (1 << x) - 1);
                }
            }

            melt();
        }

        sum = 0;
        for(int i = 0; i < (1 << n); i++){
            for(int j = 0; j < (1 << n); j++){
                sum += arr[i][j];
            }
        }

        mx = 0;
        for(int i = 0; i < (1 << n); i++){
            for(int j = 0; j < (1 << n); j++){
                if(arr[i][j] > 0 && !visited[i][j]) mx = Math.max(mx, dfs(i, j));
            }
        }

        System.out.println(sum);
        System.out.print(mx);
    }
}
