import java.util.Scanner;

public class Main {
    static boolean visited[][] = new boolean[1510][1510];

    public static boolean recur(int a, int b, int c){
        int arr[] = new int[]{a, b, c};

        if(a == b && b == c) return true;

        if(visited[a][b]) return false;

        visited[a][b] = true;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(arr[i] == arr[j]) continue;

                if(arr[i] < arr[j]) {
                    arr[j] -= arr[i];
                    arr[i] *= 2;
                    if(recur(arr[0], arr[1], arr[2])) return true;
                    arr[i] /= 2;
                    arr[j] += arr[i];
                }else{
                    arr[i] -= arr[j];
                    arr[j] *= 2;
                    if(recur(arr[0], arr[1], arr[2])) return true;
                    arr[j] /= 2;
                    arr[i] += arr[j];
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c;

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        if(recur(a, b, c)) System.out.print(1);
        else System.out.print(0);
    }
}
