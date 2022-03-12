import java.util.Scanner;

public class Main {
    static String str;
    static String arr[] = new String[2];
    static int dp[][][] = new int[110][2][110];

    public static int recur(int cur, int x, int y){
        int ret = 0;

        if(cur == str.length()) return 1;

        if(dp[cur][x][y] != -1) return dp[cur][x][y];

        for(int i = y; i < arr[x ^ 1].length(); i++){
            if(arr[x ^ 1].charAt(i) == str.charAt(cur)) ret += recur(cur + 1, x ^ 1, i + 1);
        }

        return dp[cur][x][y] = ret;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        str = sc.next();
        arr[0] = sc.next();
        arr[1] = sc.next();

        for(int i = 0; i < 110; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 110; k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        System.out.print(recur(0, 0, 0) + recur(0, 1, 0));
    }
}
