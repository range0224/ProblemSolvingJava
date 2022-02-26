import java.util.Scanner;

public class Main {
    static int n;
    static int arr[][] = new int[100010][2];
    static int prefix[] = new int[1000020];
    static int ans;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int sum;

        n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        for(int i = 0; i < n; i++)
        {
            arr[i][0] += 500010;
            arr[i][1] += 500010;
        }
        arr[n][0] = arr[0][0];
        arr[n][1] = arr[0][1];

        for(int i = 1; i <= n; i++)
        {
            if(arr[i][0] != arr[i - 1][0])
            {
                prefix[Math.min(arr[i][0], arr[i - 1][0])]++;
                prefix[Math.max(arr[i][0], arr[i - 1][0])]--;
            }
        }

        sum = 0;
        for(int i = 0; i < 1000020; i++)
        {
            sum += prefix[i];

            ans = Math.max(ans, sum);
        }

        for(int i = 0; i < 1000020; i++) prefix[i] = 0;

        for(int i = 1; i <= n; i++)
        {
            if(arr[i][1] != arr[i - 1][1])
            {
                prefix[Math.min(arr[i][1], arr[i - 1][1])]++;
                prefix[Math.max(arr[i][1], arr[i - 1][1])]--;
            }
        }

        sum = 0;
        for(int i = 0; i < 1000020; i++)
        {
            sum += prefix[i];

            ans = Math.max(ans, sum);
        }

        System.out.print(ans);
    }
}
