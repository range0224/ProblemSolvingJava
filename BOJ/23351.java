import java.util.Scanner;

public class Main{
    static int n, m, a, b;
    static int arr[] = new int[110];

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int idx;
        int cnt;

        n = sc.nextInt();
        m = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();

        for(int i = 0; i < n; i++){
            arr[i] = m;
        }

        idx = 0;
        cnt = 0;
        while(arr[n - 1] > 0){
            for(int i = idx; i < idx + a; i++){
                arr[i] += b;
            }
            idx = (idx + a) % n;

            for(int i = 0; i < n; i++) arr[i]--;

            cnt++;
        }

        System.out.print(cnt);
    }
}
