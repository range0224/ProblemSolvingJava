import java.util.Scanner;

public class Main {
    static int n;
    static String str;

    public static int check(int s, int e, boolean dif){
        if(s >= e) return 0;

        if(str.charAt(s) != str.charAt(e)){
            if(dif) return 2;
            else if(check(s + 1, e, true) == 0 || check(s, e - 1, true) == 0) return 1;
            else return 2;
        }
        return check(s + 1, e - 1, dif);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            str = sc.next();

            System.out.println(check(0, str.length() - 1, false));
        }
    }
}
