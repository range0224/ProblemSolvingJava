import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    static int n;
    static ArrayList<Integer> v = new ArrayList<>();
    static int arr[][] = new int[210][2];
    static int dp[] = new int[210];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        int ans;

        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            v.add(a * 1010 + b);
            if(a != b) v.add(b * 1010 + a);
        }

        Collections.sort(v);

        for(int i = 0; i < v.size(); i++){
            arr[i][0] = v.get(i) / 1010;
            arr[i][1] = v.get(i) % 1010;
        }

        ans = 0;
        for(int i = 0; i < v.size(); i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[j][1] <= arr[i][1] && dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;
            }

            ans = Math.max(ans, dp[i]);
        }

        System.out.print(ans);
    }
}
