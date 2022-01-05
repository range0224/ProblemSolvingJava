import java.util.Scanner;

public class Main {
    static int n;
    static int arr[] = new int[100010];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t;
        String str;
        String s;
        int idx;
        int x;
        boolean rev;
        int l, r;

        t = sc.nextInt();
        while(t-->0){
            str = sc.next();
            n = sc.nextInt();
            s = sc.next();

            x = 0;
            idx = 0;
            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    x *= 10;
                    x += s.charAt(i) - '0';
                }else{
                    arr[idx++] = x;
                    x = 0;
                }
            }

            l = 0;
            r = n - 1;
            rev = false;
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == 'R') rev = !rev;
                else{
                    if(rev) r--;
                    else l++;
                }
            }

            if(l > r + 1){
                sb.append("error");
            } else if(rev){
                sb.append("[");
                for(int i = r; i >= l; i--){
                    sb.append(arr[i]);
                    if(i != l) sb.append(",");
                }
                sb.append("]");
            }else{
                sb.append("[");
                for(int i = l; i <= r; i++){
                    sb.append(arr[i]);
                    if(i != r) sb.append(",");
                }
                sb.append("]");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
