import java.util.Scanner;
import java.util.Stack;

public class Main{
    static String str;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Stack<Character> st = new Stack<>();

        str = sc.next();

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'P'){
                if(!st.isEmpty() && st.peek() == 'A') st.pop();
                else st.add('P');
            }else{
                if (!st.isEmpty() && st.peek() == 'P') st.pop();
                else{
                    System.out.print("NP");
                    return;
                }
                st.add('A');
            }

            if(st.isEmpty()){
                System.out.print("NP");
                return;
            }
        }

        if(st.size() == 1 && st.peek() == 'P') System.out.print("PPAP");
        else System.out.print("NP");
    }
}
