import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int n, m;
    static int arr[];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int ans;

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        ans = 0;
        for(int i = n - 1; i >= n - m; i--){
            ans += arr[i];
        }

        ans -= m * (m - 1) / 2;

        System.out.print(ans);
    }
}
