import java.util.Scanner;

public class Main {
    static int n;
    static int a[] = new int[100010];
    static int b[] = new int[100010];
    static int pos[] = new int[100010];
    static boolean visited[] = new boolean[100010];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int idx;
        int cnt;

        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            b[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            pos[a[i]] = i;
        }

        idx = 0;
        cnt = 0;
        for(int i = 0; i < n; i++){
            while(visited[idx]) idx++;

            if(b[i] == a[idx]) idx++;
            else{
                visited[pos[b[i]]] = true;
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
