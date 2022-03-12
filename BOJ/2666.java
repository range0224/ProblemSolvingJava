import java.util.Scanner;

public class Main {
    static int n, m;
    static int arr[] = new int[30];

    public static int recur(int cur, int a, int b){
        if(cur == m) return 0;

        if(arr[cur] <= a) return recur(cur + 1, arr[cur], b) + a - arr[cur];
        else if(arr[cur] >= b) return recur(cur + 1, a, arr[cur]) + arr[cur] - b;
        else return Math.min(recur(cur + 1, arr[cur], b) + arr[cur] - a, recur(cur + 1, a, arr[cur]) + b - arr[cur]);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a, b;

        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < m; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print(recur(0, Math.min(a, b), Math.max(a, b)));
    }
}
