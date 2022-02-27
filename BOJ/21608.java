import java.util.Scanner;

public class Main {
    static int n;
    static int arr[][] = new int[30][30];
    static int v[][] = new int[410][4];
    static int order[] = new int[410];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    static boolean in_range(int x, int y){
        return x >= 1 && x <= n && y >= 1 && y <= n;
    }

    static boolean best_friend(int x, int y)
    {
        int i;

        for (i = 0; i < 4; i++)
        {
            if (v[x][i] == y) return true;
        }

        return false;
    }

    static void set_seat(int idx)
    {
        int i, j, k;
        int x = 0, y = 0;
        int nx, ny;
        int friends, empty;
        int tf, te;

        friends = -1;
        empty = 0;
        for (i = 1; i <= n; i++)
        {
            for (j = 1; j <= n; j++)
            {
                if (arr[i][j] != 0) continue;

                tf = 0;
                te = 0;
                for (k = 0; k < 4; k++)
                {
                    nx = i + dx[k];
                    ny = j + dy[k];

                    if (!in_range(nx, ny)) continue;

                    if (arr[nx][ny] == 0) te++;
                    else if (best_friend(idx, arr[nx][ny])) tf++;
                }

                if (friends < tf || (friends == tf && empty < te))
                {
                    friends = tf;
                    empty = te;
                    x = i;
                    y = j;
                }
            }
        }

        arr[x][y] = idx;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x;
        int ans = 0;
        int cnt;
        int score[] = {0, 1, 10, 100, 1000};
        int nx, ny;

        n = sc.nextInt();
        for(int i = 1; i <= n * n; i++){
            x = sc.nextInt();
            for(int j = 0; j < 4; j++){
                v[x][j] = sc.nextInt();
            }

            order[i] = x;
        }

        for (int i = 1; i <= n * n; i++)
        {
            set_seat(order[i]);
        }

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                cnt = 0;
                for (int k = 0; k < 4; k++)
                {
                    nx = i + dx[k];
                    ny = j + dy[k];

                    if (!in_range(nx, ny)) continue;

                    if (best_friend(arr[i][j], arr[nx][ny])) cnt++;
                }

                ans += score[cnt];
            }
        }

        System.out.print(ans);
    }
}
