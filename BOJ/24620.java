import java.util.Scanner;

public class Main{
    static int n;
    static int arr[] = new int[100010];

    public static boolean check(int x){
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += arr[i];

            if(sum > x) return false;

            sum %= x;
        }

        return true;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t;
        int sum;
        int ans;

        t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            sum = 0;
            for(int i = 0; i < n; i++){
                sum += arr[i];
            }

            ans = 0;
            for(int i = 1; i <= sum; i++){
                if(sum % i == 0 && check(i)){
                    ans = n - sum / i;
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
