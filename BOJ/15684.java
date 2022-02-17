import java.util.Scanner;

public class Main {
    static int n, m, k;
    static boolean visited[][] = new boolean[50][20];
    static int ans;

    public static boolean check(){
        int x, y;

        for(int i = 1; i <= n; i++){
            x = 1;
            y = i;
            while(x <= m){
                if(visited[x][y - 1]) y--;
                else if(visited[x][y]) y++;

                x++;
            }

            if(y != i) return false;
        }

        return true;
    }

    public static void recur(int x, int y, int cnt){
        if(cnt > 3){
            return;
        }

        if(y == n){
            x++;
            y = 1;
        }
        if(x == m + 1){
            if(check()) ans = Math.min(ans, cnt);

            return;
        }

        if(!visited[x][y] && !visited[x][y - 1] && !visited[x][y + 1]){
            visited[x][y] = true;
            recur(x, y + 1, cnt + 1);
            visited[x][y] = false;
        }
        recur(x, y + 1, cnt);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a, b;

        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < k; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            visited[a][b] = true;
        }

        ans = 100;
        recur(1, 1, 0);

        if(ans == 100) System.out.print(-1);
        else System.out.print(ans);
    }
}
