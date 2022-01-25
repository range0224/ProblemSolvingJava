import java.util.Scanner;

public class Main {
    static int n, m;
    static int arr[] = new int[510];
    static int prefix[] = new int[510];
    static int suffix[] = new int[510];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans;

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= m; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 1; i <= m; i++){
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }

        for(int i = m; i >= 1; i--){
            suffix[i] = Math.max(suffix[i + 1], arr[i]);
        }

        ans = 0;
        for(int i = 1; i <= m; i++){
            ans += Math.min(prefix[i] - arr[i], suffix[i] - arr[i]);
        }

        System.out.print(ans);
    }
}
