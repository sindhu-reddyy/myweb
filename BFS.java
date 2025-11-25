import java.util.*;
class BFS{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int e=sc.nextInt();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int start=sc.nextInt();
        bfs(adj,n,start);
    }
    static void bfs(List<List<Integer>> adj,int n,int start){
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited=new boolean[n];
        q.add(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int p=q.poll();
            System.out.print(p+" ");
            for(int i:adj.get(p)){
                if(!visited[i]){
                    q.add(i);
                    visited[i]=true;

                }
                
            }
            for(int i:adj.get(p)){
                if(!visited[i]){
                    q.add(i);
                    visited[i]=true;

                }
                
            }
        }
    }
}