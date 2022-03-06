import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int n, m;
    static TreeSet<Integer> s = new TreeSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t;

        t = Integer.parseInt(bf.readLine());
        while(t-->0){
            s.clear();

            n = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            for(int i = 0; i < n; i++){
                s.add(Integer.parseInt(st.nextToken()));
            }
            m = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            for(int i = 0; i < m; i++){
                if(s.contains(Integer.parseInt(st.nextToken()))) sb.append("1\n");
                else sb.append("0\n");
            }
        }

        System.out.print(sb);
    }
}
