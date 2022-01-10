import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int x;
        long sum = 0;
        int mx = 0;

        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            x = Integer.parseInt(br.readLine());

            sum += x;
            mx = Math.max(mx, x);
        }

        sum -= mx;

        if(mx > sum) System.out.print(mx - sum);
        else System.out.print((sum + mx) % 2);
    }
}
