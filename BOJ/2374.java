import java.util.Scanner;

public class Main {
    static int n;
    static int arr[] = new int[1010];

    public static long recur(int s, int e, int v){
        int idx;
        int mx;

        if(s > e) return 0;

        mx = -1;
        idx = s;
        for(int i = s; i <= e; i++){
            if(mx < arr[i]){
                mx = arr[i];
                idx = i;
            }
        }

        return recur(s, idx - 1, mx) + recur(idx + 1, e, mx) + v - mx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mx;

        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        mx = -1;
        for(int i = 0; i < n; i++){
            mx = Math.max(mx, arr[i]);
        }

        System.out.print(recur(0, n - 1, mx));
    }
}
