import java.util.Scanner;

public class Main {
    static int n;
    static int arr[][] = new int[30][30];
    static int ans;
    static boolean visited[] = new boolean[30];

    public static void recur(int cur, int a, int b) {
        if(cur == n){
            ans = Math.min(ans, Math.abs(a - b));
            return;
        }

        recur(cur + 1, a, b);

        visited[cur] = true;
        for(int i = 0; i < n; i++){
            if(visited[i]){
                b += arr[cur][i];
                b += arr[i][cur];
            }else{
                a -= arr[cur][i];
                a -= arr[i][cur];
            }
        }
        recur(cur + 1, a, b);
        visited[cur] = false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int sum;

        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sum += arr[i][j];
            }
        }

        ans = 1 << 30;
        recur(0, sum, 0);

        System.out.print(ans);
    }
}
