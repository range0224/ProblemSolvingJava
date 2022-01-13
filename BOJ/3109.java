import java.util.Scanner;

public class Main {
    static int n, m;
    static char arr[][] = new char[10010][510];
    static boolean visited[][] = new boolean[10010][510];

    public static boolean in_range(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static boolean dfs(int x, int y){
        if(y == m - 1) return true;

        visited[x][y] = true;
        for(int i = -1; i <= 1; i++){
            if(in_range(x + i, y + 1) && arr[x + i][y + 1] == '.' && !visited[x + i][y + 1] && dfs(x + i, y + 1)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        int cnt;

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            str = sc.next();
            for(int j = 0; j < m; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        cnt = 0;
        for(int i = 0; i < n; i++){
            if(dfs(i, 0)) cnt++;
        }

        System.out.print(cnt);
    }
}
