import java.util.Scanner;

public class Main{
    static int n;
    static int arr[][] = new int[110][2];
    static boolean visited[] = new boolean[110];

    public static void dfs(int cur){
        visited[cur] = true;

        for(int i = 0; i < n; i++){
            if(!visited[i] && Math.abs(arr[cur][0] - arr[i][0]) + Math.abs(arr[cur][1] - arr[i][1]) <= 1000) dfs(i);
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t;

        t = sc.nextInt();
        while(t-->0) {
            n = sc.nextInt() + 2;
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) visited[i] = false;

            dfs(0);

            if(visited[n - 1]) System.out.println("happy");
            else System.out.println("sad");
        }
    }
}
