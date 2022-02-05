import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int n;
    static long arr[];
    static long ans[] = new long[3];
    static long mn = 1L << 60;

    public static void check(int idx){
        int s, e;

        s = 0;
        e = n - 1;
        while(s < e){
            if(s == idx) s++;
            if(e == idx) e--;
            if(s >= e) break;

            if(mn > Math.abs(arr[idx] + arr[s] + arr[e])){
                mn = Math.abs(arr[idx] + arr[s] + arr[e]);
                ans[0] = arr[idx];
                ans[1] = arr[s];
                ans[2] = arr[e];
            }

            if(arr[idx] + arr[s] + arr[e] > 0) e--;
            else s++;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for(int i = 0; i < n; i++){
            check(i);
        }

        Arrays.sort(ans);

        System.out.print(ans[0] + " " + ans[1] + " " + ans[2]);
    }
}
