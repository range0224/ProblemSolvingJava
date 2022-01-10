import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int arr[][] = new int[1010][1010];
        int prefix[][][] = new int[4][1010][1010];
        int suffix[][][] = new int[4][1010][1010];
        int ans;

        n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(arr[i][j] == 1) {
                    prefix[0][i][j] = prefix[0][i - 1][j - 1] + 1;
                    prefix[1][i][j] = prefix[1][i - 1][j] + 1;
                    prefix[2][i][j] = prefix[2][i - 1][j + 1] + 1;
                    prefix[3][i][j] = prefix[3][i][j - 1] + 1;
                }
            }
        }

        for(int i = n; i >= 1; i--){
            for(int j = n; j >= 1; j--){
                if(arr[i][j] == 1){
                    suffix[0][i][j] = suffix[0][i + 1][j + 1] + 1;
                    suffix[1][i][j] = suffix[1][i + 1][j] + 1;
                    suffix[2][i][j] = suffix[2][i + 1][j - 1] + 1;
                    suffix[3][i][j] = suffix[3][i][j + 1] + 1;
                }
            }
        }

        ans = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 0; k < 4; k++){
                    ans = Math.max(ans, prefix[k][i][j]);
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(arr[i][j] == 2) {
                    ans = Math.max(ans, prefix[0][i - 1][j - 1] + suffix[0][i + 1][j + 1] + 1);
                    ans = Math.max(ans, prefix[1][i - 1][j] + suffix[1][i + 1][j] + 1);
                    ans = Math.max(ans, prefix[2][i - 1][j + 1] + suffix[2][i + 1][j - 1] + 1);
                    ans = Math.max(ans, prefix[3][i][j - 1] + suffix[3][i][j + 1] + 1);
                }
            }
        }

        System.out.print(ans);
    }
}
