import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int dp[] = new int[1000010];
    static ArrayList<Integer> v = new ArrayList<>();

    public static void get_list(int x){
        int arr[] = new int[10];
        int idx = 0;

        while(x > 0){
            arr[idx++] = x % 10;
            x /= 10;
        }

        v.clear();
        for(int i = idx - 1; i >= 0; i--){
            x = 0;
            for(int j = i; j >= 0; j--){
                x *= 10;
                x += arr[j];

                v.add(x);
            }
        }

        Collections.sort(v);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        for(int i = 1; i <= 1000000; i++){
            get_list(i);

            dp[i] = -1;
            for(int j = 0; j < v.size(); j++){
                if(v.get(j) == 0 || v.get(j) == i) continue;

                if(dp[i - v.get(j)] == -1) {
                    dp[i] = v.get(j);
                    break;
                }
            }
        }

        n = sc.nextInt();

        System.out.print(dp[n]);
    }
}
