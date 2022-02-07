import java.util.Scanner;

public class Main {
    static int n;
    static int arr[] = new int[400];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        int ans;
        int mx;
        int cnt;

        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            for(int j = a; j <= b; j++){
                arr[j]++;
            }
        }

        ans = 0;
        cnt = 0;
        mx = 0;
        for(int i = 1; i <= 366; i++){
            if(arr[i] == 0){
                ans += cnt * mx;
                cnt = 0;
                mx = 0;
            }else{
                cnt++;
                mx = Math.max(mx, arr[i]);
            }
        }

        System.out.print(ans);
    }
}
