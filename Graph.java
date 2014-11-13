/**
 *图 类的实现，邻接矩阵实现
 *利用Bag类存储邻接表
 *
 */

public class Graph{
    
    private final int V;            //顶点数目
    private int E;                  //边的数目
    private Bag<Integer>[] adj;     //邻接表
    /*构造函数*/
    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int v = 0; v < V; v++){
            adj[v] = new Bag<Integer>();
        }
    }
    //public Graph(InputStream in){
    //    this(in.readInt());
    //    int E = in.readInt();
    //    for(int i = 0; i < E; i++){
    //        int v = in.readInt();
    //        int w = in.readInt();
    //        addEdge(v, w);
    //    }
    //}
    public int V(){  return V;}
    public int E(){  return E;}

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public String toString(){
        String s = V + " vertices," + E + " deges.\n";
        for(int v = 0; v < V; v++){
            s += v + ":";
            for(int w:this.adj(v)){
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }
    public static void main(String[] args){
        Graph g = new Graph(5);
        g.addEdge(1,4);
        g.addEdge(1,3);
        g.addEdge(2,3);
        g.addEdge(4,3);
        g.addEdge(2,4);
        g.addEdge(2,0);
        System.out.println(g.toString());
    }
}
