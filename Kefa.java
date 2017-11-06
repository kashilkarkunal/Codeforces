import java.util.*;

public class Kefa{

    static int result = 0;
    public static class Park{
        ArrayList<Integer> adjList;
        public Park(){
            adjList = new ArrayList<Integer>();
        }
    }
    static int[] nodes;
    static boolean[] visited;
    static Park[] parks;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int n = Integer.parseInt(line.split(" ")[0]);
        int m = Integer.parseInt(line.split(" ")[1]);

        line = sc.nextLine();
        nodes = new int[n];
        visited = new boolean[n];

        String[] arr = line.split(" ");
        for(int i = 0; i < n; i+=1){
            nodes[i] = Integer.parseInt(arr[i]);
            visited[i] = false;
        }

        parks = new Park[n];
        for(int i = 0; i < n - 1; i +=1){
            line = sc.nextLine();
            int key = Integer.parseInt(line.split(" ")[0]);
            int value = Integer.parseInt(line.split(" ")[1]);
            if(parks[key -1] == null)
                parks[key -1] = new Park();

            if(parks[value -1] == null)
                parks[value -1] = new Park();

            parks[key - 1].adjList.add(value);
            parks[value - 1].adjList.add(key);
        }

        visited[0] = true;
        dfs(1, m, 0);
        System.out.print(result);

    }

    private static void dfs(int currentNode, int m, int cats){

        if(nodes[currentNode - 1] == 1){
            cats +=1;
        }else{
            cats = 0;
        }
        ArrayList<Integer> adjList = parks[currentNode -1].adjList;

        if(cats > m){
            return;
        }
        if(adjList.size() == 1 && currentNode != 1){
            result+=1;
            return;
        }


        for(Integer adj : adjList){
            
            if(visited[adj - 1]){
                continue;
            }
            visited[adj - 1] = true;
            dfs(adj, m, cats);
        }
        return;
    }
}
