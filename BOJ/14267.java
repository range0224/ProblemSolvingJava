import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static int n, m;
    static ArrayList<Integer> v[] = new ArrayList[100010];
    static int arr[] = new int[100010];
    static int ans[] = new int[100010];

    public static void dfs(int cur, int sum){
        sum += arr[cur];

        ans[cur] = sum;
        for(int i = 0; i < v[cur].size(); i++){
            dfs(v[cur].get(i), sum);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 100010; i++) v[i] = new ArrayList<>();

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextInt();
        for(int i = 2; i <= n; i++){
            v[sc.nextInt()].add(i);
        }
        for(int i = 0; i < m; i++){
            arr[sc.nextInt()] += sc.nextInt();
        }

        dfs(1, 0);

        for(int i = 1; i <= n; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
