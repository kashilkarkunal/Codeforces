import java.util.*;
import java.lang.*;

// Codeforces 651A

public class Joysticks{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        String line = s.nextLine();
        String[] arr = line.split(" ");

        int a = Integer.valueOf(arr[0]);
        int b = Integer.valueOf(arr[1]);

        int count = countSeconds(a, b);
        System.out.print(count);
    }

    public static int countSeconds(int a, int b){
        if( a <= 1 && b <= 1){
            return 0;
        }

        int count = 0;
        while(true){
            int max = Math.max(a,b);
            int sec = 0;
            if(max % 2 == 0)
                sec = (max - 2)/2;
            else
                sec = (max - 1)/2;

            if(sec == 0){
                break;
            }
            if(a > b){
                a-=(2*sec);
                b+=sec;
            }else{
                a+=sec;
                b-=(2*sec);
            }
            count+=sec;
        }
        return count + 1;
    }
}
