import java.util.Scanner;

public class Main {
    static int n, m;
    static int arr[] = new int[500010];
    static int prefix[] = new int[500010];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        int mn;
        int cnt;

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            x = sc.nextInt();

            if(i % 2 == 0){
                arr[1]++;
                arr[x + 1]--;
            }else{
                arr[m - x + 1]++;
            }
        }

        for(int i = 1; i <= m; i++){
            prefix[i] = prefix[i - 1] + arr[i];
        }

        mn = 1000000;
        for(int i = 1; i <= m; i++){
            mn = Math.min(mn, prefix[i]);
        }

        cnt = 0;
        for(int i = 1; i <= m; i++){
            if(prefix[i] == mn) cnt++;
        }

        System.out.print(mn + " " + cnt);
    }
}
