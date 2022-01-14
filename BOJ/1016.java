import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean visited[] = new boolean[1000010];
        long s, e;
        int cnt;

        s = sc.nextLong();
        e = sc.nextLong();

        for(long i = 2; i * i <= e; i++){
            for(long j = (s / (i * i)) * (i * i); j <= e; j += i * i){
                if(j >= s) visited[(int)(j - s)] = true;
            }
        }

        cnt = 0;
        for(int i = 0; i <= e - s; i++){
            if(!visited[i]) cnt++;
        }

        System.out.print(cnt);
    }
}
