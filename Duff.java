import java.util.*;

public class Duff{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int days = s.nextInt();
        s.nextLine();
        long totalCost = 0;
        int minSoFar = Integer.MAX_VALUE;

        for(int i = 0; i < days; i+=1){
            if(s.hasNext()){
                String line = s.nextLine();
                String[] strSplit = line.split(" ");
                int meat = Integer.valueOf(strSplit[0]);
                int price = Integer.valueOf(strSplit[1]);

                if (price < minSoFar){
                    minSoFar = price;
                }
                totalCost+=(meat*minSoFar);
            }
        }

        System.out.print(totalCost);
    }
}
