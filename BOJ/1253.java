import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int n;
    static int arr[];

    public static int check(int idx){
        int s, e;

        s = 0;
        e = n - 1;
        while(s < e){
            if(s == idx) s++;
            if(e == idx) e--;
            if(s >= e) break;

            if(arr[s] + arr[e] == arr[idx]) return 1;
            else if(arr[s] + arr[e] > arr[idx]) e--;
            else s++;
        }

        return 0;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt;

        n = sc.nextInt();
        
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);

        cnt = 0;
        for(int i = 0; i < n; i++){
            cnt += check(i);
        }

        System.out.print(cnt);
    }
}
