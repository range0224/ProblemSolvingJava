import java.util.Scanner;

public class Main {
    static int n, m;
    static int arr[] = new int[250010];
    static long prefix[] = new long[250010];
    static long suffix[] = new long[250010];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long ans;
        int idx;

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        prefix[0] = 0;
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1];

            if(arr[i] <= arr[i - 1]) prefix[i] += arr[i - 1] - arr[i];
            else prefix[i] += m - arr[i] + arr[i - 1];
        }

        suffix[n - 1] = 0;
        for(int i = n - 2; i >= 0; i--){
            suffix[i] = suffix[i + 1];

            if(arr[i] <= arr[i + 1]) suffix[i] += arr[i + 1] - arr[i];
            else suffix[i] += m - arr[i] + arr[i + 1];
        }

        ans = 1L << 60;
        idx = 0;
        for(int i = 0; i < n; i++){
            if(ans > Math.max(prefix[i], suffix[i])){
                ans = Math.max(prefix[i], suffix[i]);
                idx = i;
            }
        }

        System.out.println(idx + 1);
        System.out.print(ans);
    }
}
