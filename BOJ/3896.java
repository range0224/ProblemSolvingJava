import java.util.Scanner;

public class Main {
    static boolean prime[] = new boolean[1300000];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int q;
        int n;
        int cnt;

        for(int i = 2; i * i < 1300000; i++){
            if(prime[i]) continue;

            for(int j = i * i; j < 1300000; j += i){
                prime[j] = true;
            }
        }

        q = sc.nextInt();
        while(q-->0){
            n = sc.nextInt();

            if(!prime[n]){
                System.out.println(0);
                continue;
            }

            cnt = 0;
            for(int i = n - 1; prime[i]; i--) cnt++;
            for(int i = n + 1; prime[i]; i++) cnt++;

            System.out.println(cnt + 2);
        }
    }
}
