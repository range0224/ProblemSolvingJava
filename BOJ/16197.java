import java.util.Scanner;

public class Main {
    static int n, m;
    static char arr[][] = new char[30][30];
    static int ans = 100;
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static boolean in_range(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void recur(int cnt, int x[], int y[]){
        int nx[] = new int[2];
        int ny[] = new int[2];

        if(in_range(x[0], y[0]) ^ in_range(x[1], y[1])) {
            ans = Math.min(ans, cnt);
            return;
        }
        if(cnt == 10) return;

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 2; j++){
                if(!in_range(x[j], y[j])) continue;

                nx[j] = x[j] + dx[i];
                ny[j] = y[j] + dy[i];

                if(in_range(nx[j], ny[j]) && arr[nx[j]][ny[j]] == '#'){
                    nx[j] = x[j];
                    ny[j] = y[j];
                }
            }

            recur(cnt + 1, nx, ny);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        int x[] = new int[2];
        int y[] = new int[2];
        int idx;

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            str = sc.next();
            for(int j = 0; j < m; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 'o'){
                    x[idx] = i;
                    y[idx] = j;
                    idx++;

                    arr[i][j] = '.';
                }
            }
        }

        recur(0, x, y);
        if(ans == 100) ans = -1;

        System.out.print(ans);
    }
}
