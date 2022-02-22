import java.util.Scanner;

public class Main {
    static int n, m;
    static int arr[] = new int[10010];

    public static boolean check(long x){
        long sum = 0;

        for(int i = 0; i < m; i++){
            sum += x / arr[i] + 1;
        }

        return sum >= n;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long s, e;
        long mid;
        long ans;
        long sum;

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < m; i++){
            arr[i] = sc.nextInt();
        }

        s = 0;
        e = 20000000000000L;
        ans = 0;
        while(s <= e){
            mid = (s + e) / 2;

            if(check(mid)){
                ans = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }

        sum = 0;
        for(int i = 0; i < m; i++){
            sum += ans / arr[i];
            if(ans % arr[i] != 0) sum++;
        }

        for(int i = 0; i < m; i++){
            if(ans % arr[i] == 0){
                sum++;

                if(sum == n){
                    System.out.print(i + 1);
                    return;
                }
            }
        }
    }
}
