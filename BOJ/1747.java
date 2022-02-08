import java.util.Scanner;

public class Main {
    static int n;
    static boolean isPrime[] = new boolean[1200000];

    public static boolean isPalin(int x){
        int arr[] = new int[10];
        int idx;

        idx = 0;
        while(x > 0){
            arr[idx++] = x % 10;
            x /= 10;
        }

        for(int i = 0; i < idx; i++){
            if(arr[i] != arr[idx - i - 1]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 2; i < 1200000; i++) isPrime[i] = true;

        for(int i = 2; i * i < 1200000; i++){
            if(!isPrime[i]) continue;

            for(int j = i * i; j < 1200000; j += i){
                isPrime[j] = false;
            }
        }

        n = sc.nextInt();
        for(int i = n; i < 1200000; i++){
            if(isPrime[i] && isPalin(i)){
                System.out.println(i);
                break;
            }
        }
    }
}
