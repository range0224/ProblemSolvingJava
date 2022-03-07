import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    static char arr[][] = new char[5][5];
    static char ox[] = {'X', 'O'};
    static TreeMap<String, Boolean> m = new TreeMap<>();

    public static boolean fin(){
        for(int i = 0; i < 3; i++){
            if(arr[i][0] != '.' && arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) return true;
            if(arr[0][i] != '.' && arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i]) return true;
        }
        if(arr[0][0] != '.' && arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) return true;
        if(arr[0][2] != '.' && arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0]) return true;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(arr[i][j] == '.') return false;
            }
        }

        return true;
    }

    public static void recur(int x){
        String s = "";
        if(fin()){
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    s += arr[i][j];
                }
            }

            m.put(s, true);
            return;
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(arr[i][j] == '.'){
                    arr[i][j] = ox[x];
                    recur(x ^ 1);
                    arr[i][j] = '.';
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                arr[i][j] = '.';
            }
        }

        recur(0);

        while(true){
            str = sc.next();

            if(str.equals("end")) break;

            if(m.getOrDefault(str, false)) System.out.println("valid");
            else System.out.println("invalid");
        }
    }
}
