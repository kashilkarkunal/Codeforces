import java.util.*;

public class Bakery{
    static class Node{
        int label;
        int cost;

        Node(int value, int weight){
            this.label = value;
            this.cost = weight;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        int n, m, k;
        n = Integer.parseInt(line1.split(" ")[0]);
        m = Integer.parseInt(line1.split(" ")[1]);
        k = Integer.parseInt(line1.split(" ")[2]);

        if(k == 0 || k == n){
            System.out.print(-1);
            return;
        }

        boolean[] storageLocations = new boolean[n];
        ArrayList<ArrayList<Node>> adjList = new ArrayList();
        for(int i = 0; i < n; i+=1){
            adjList.add(new ArrayList());
        }
        for(int i = 0; i < m; i+=1){
            line1 = sc.nextLine();
            String[] edge = line1.split(" ");
            int v1 = Integer.parseInt(edge[0]);
            int v2 = Integer.parseInt(edge[1]);
            int weight = Integer.parseInt(edge[2]);

            ArrayList<Node> v1AdjList = adjList.get(v1 - 1);
            if(v1AdjList == null){
                v1AdjList = new ArrayList();
            }
            v1AdjList.add(new Node(v2 - 1, weight));

            ArrayList<Node> v2AdjList = adjList.get(v2 - 1);
            if(v2AdjList == null){
                v2AdjList = new ArrayList();
            }
            v2AdjList.add(new Node(v1 - 1, weight));
        }

        line1 = sc.nextLine();
        String[] storage = line1.split(" ");
        for(int i = 0; i < k; i+=1){ 
            storageLocations[Integer.parseInt(storage[i]) -1] = true;
        }

        int result = Integer.MAX_VALUE;
        boolean noBakeryLocation = true;
        for(int i = 0; i < n; i+=1){
            if(!storageLocations[i]){
                if(adjList.get(i).size() == 0){
                    continue;
                }
                int distanceToStorage = shortestPath(new Node(i, 0), adjList, n, storageLocations);
                if(distanceToStorage == -1){
                    continue;
                }
                noBakeryLocation = false;
                result = Math.min(result, distanceToStorage);
            }
        }
        if(noBakeryLocation){
            System.out.print(-1);
            return;
        }
        System.out.print(result);
    }

    private static int shortestPath(Node startNode, ArrayList<ArrayList<Node>> adjList, int n, boolean[] storageLocations){
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];
        boolean connectedToStorage = false;

        for(int i = 0; i < n; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> heap = new PriorityQueue<Node>(n, new Comparator<Node>(){
            public int compare(Node a, Node b){
                if(a.cost == b.cost){
                    return a.label - b.label;
                }
                return a.cost - b.cost;
            }
        });
        heap.add(startNode);
        while(!heap.isEmpty()){
            Node node = heap.poll();
            if(node == startNode){
                distance[node.label] = 0;
            }
            if(visited[node.label]) continue;
            visited[node.label] = true;
            ArrayList<Node> adj = adjList.get(node.label);
            for(Node adjNode :adj){
                if(storageLocations[adjNode.label]){
                    connectedToStorage = true;
                }
                if(distance[node.label] + adjNode.cost < distance[adjNode.label]){
                    distance[adjNode.label] = distance[node.label] + adjNode.cost;
                }
                heap.add(new Node(adjNode.label, distance[adjNode.label]));
            }
        }
        if(!connectedToStorage){
            return -1;
        }
        int minStorageLocation = Integer.MAX_VALUE;
        for(int i = 0; i < n; i+=1){
            if(storageLocations[i] && distance[i] < minStorageLocation){
                minStorageLocation = distance[i];
            }
        }
        return minStorageLocation;
    }
}
