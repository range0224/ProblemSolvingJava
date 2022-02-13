import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int n;
    static int arr[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum;

        n = sc.nextInt();
        arr = new int[n + 1];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        arr[n] = 10000000;

        Arrays.sort(arr);

        sum = 0;
        for(int i = 0; i <= n; i++){
            if(arr[i] > sum + 1){
                System.out.print(sum + 1);
                return;
            }

            sum += arr[i];
        }
    }
}
