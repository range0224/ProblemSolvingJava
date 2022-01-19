import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void recur(int n, int s, int e, int v){
        if(n == 0) return;

        recur(n - 1, s, v, e);
        sb.append(s + " " + e + "\n");
        recur(n - 1, v, e, s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        n = sc.nextInt();

        sb.append((1 << n) - 1 + "\n");
        recur(n, 1, 3, 2);

        System.out.print(sb);
    }
}
