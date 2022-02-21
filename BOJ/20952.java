import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n, m;
        int arr[] = new int[100010];
        boolean erased[] = new boolean[10];
        int cnt = 0;
        long sum = 0;
        int a;

        for(int i = 0; i < 10; i++) erased[i] = true;

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();

            if(erased[arr[i] % 7]) cnt++;
            erased[arr[i] % 7] = false;
        }
        for(int i = 0; i < m; i++){
            a = sc.nextInt();

            sum += a;
            if(!erased[(int)(7 - sum % 7) % 7]){
                if(cnt == 1){
                    sum -= a;
                    continue;
                }

                cnt--;
            }
            erased[(int)(7 - sum % 7) % 7] = true;
        }

        cnt = 0;
        for(int i = 0; i < n; i++){
            if(!erased[arr[i] % 7]) cnt++;
        }

        System.out.println(cnt);
        for(int i = 0; i < n; i++){
            if(erased[arr[i] % 7]) continue;

            System.out.print((arr[i] + sum) % 1000000007 + " ");
        }
    }
}
