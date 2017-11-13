import java.util.*;

public class Criminals{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();

        int cities = Integer.parseInt(line1.split(" ")[0]);
        int police = Integer.parseInt(line1.split(" ")[1]) - 1;

        int [] criminals = new int[cities];

        String[] arr = line2.split(" ");
        for(int i = 0; i < cities; i+=1){
            criminals[i] = Integer.parseInt(arr[i]);
        }
        
        int result = criminals[police];
        for(int i = 1; i < cities; i+=1){
            int criminalLeft = -1;
            int criminalRight = -1;
            if(police - i >= 0){
                criminalLeft = criminals[police - i];
            }

            if(police + i < cities){
                criminalRight = criminals[police + i];
            }

            if(criminalLeft == -1 && criminalRight == -1){
                break;
            }

            if(criminalLeft == criminalRight){
                result+=(2*criminalLeft);
            }

            if(criminalLeft == -1 || criminalRight == -1){
                result+=(Math.max(criminalLeft, criminalRight));
            }
        }
        System.out.print(result);
    }
}
