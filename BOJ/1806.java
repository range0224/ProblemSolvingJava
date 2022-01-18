import java.util.Scanner;

public class Main {
    static int n, m;
    static int arr[] = new int[100010];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s, e;
        int sum;
        int ans;

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
        }

        ans = 1000000;
        s = 1;
        e = 1;
        sum = arr[1];
        while(e <= n){
            if(sum >= m){
                ans = Math.min(ans, e - s + 1);
                sum -= arr[s];
                s++;
            }else{
                e++;
                sum += arr[e];
            }
        }

        if(ans == 1000000) ans = 0;

        System.out.print(ans);
    }
}
