import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    static int n;
    static int arr[] = new int[110];
    static boolean visited[] = new boolean[110];

    public static boolean dfs(int cur, int start){
        if(cur == start) return true;

        visited[cur] = true;
        return !visited[arr[cur]] && dfs(arr[cur], start);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> ans = new ArrayList<>();

        n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 1; i <= n; i++){
            Arrays.fill(visited, false);

            if(dfs(arr[i], i)) ans.add(i);
        }

        System.out.println(ans.size());
        for(int i = 0; i < ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }
}
