import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int n, l;
    static int arr[];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x;
        int cnt;

        n = sc.nextInt();
        l = sc.nextInt();

        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        x = -1;
        cnt = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] > x){
                x = arr[i] + l - 1;
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
