import java.util.*;

public class SimpleGame{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        
        String[] s = line.split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        System.out.print(chooseNumber(m, n));

    }

    private static int chooseNumber(int m, int n){
        if(m == 1 && m < n){
            return m + 1;
        }else if(m == 1){
            return m;
        }
        if( n - m >= m){
            return m + 1;
        }else{
            return m - 1;
        }
    }
}
