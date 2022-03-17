import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    static int n, m;
    static int arr[] = new int[300010];
    static ArrayList<Integer> v = new ArrayList<>();

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int ans;

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 1; i < n; i ++){
            v.add(arr[i] - arr[i - 1]);
        }

        Collections.sort(v);

        ans = arr[n - 1] - arr[0];
        for(int i = 0; i < m - 1; i++){
            ans -= v.get(v.size() - i - 1);
        }

        System.out.print(ans);
    }
}
