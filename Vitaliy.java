import java.util.*;

public class Vitaliy{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        String config = s.nextLine();
        HashMap<Character, Integer> doorMap = new HashMap();
        HashMap<Character, Integer> keyMap = new HashMap();

        for(int i = 0; i < config.length(); i+=1){
            Character ch = config.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                insertKey(doorMap, ch);
            }else{
                insertKey(keyMap, ch);
            }
        }

        int result = 0;
        for(Character ch : doorMap.keySet()){
            Character lower_ch = Character.toLowerCase(ch);
            if(keyMap.containsKey(lower_ch)){
                result+=Math.max(0, doorMap.get(ch) - keyMap.get(lower_ch));
            }else{
                result+=(doorMap.get(ch) - 0);
            }
        }
        System.out.print(result);
    }

    private static void insertKey(HashMap<Character, Integer> map, Character key){
        if(map.containsKey(key)){
            int val = map.get(key);
            map.put(key, val+=1);
        }else{
            map.put(key, 1);
        }
    }
}
