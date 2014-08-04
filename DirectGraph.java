/**
 * ClassName:     DirectGraph
 * description:  有向图的类
 * Author:        lhb
 * Date:         2014-05-14 08:29:46
 * Version:		 1.0
 *
 */
 
public class  DirectGraph {
    private int V;
    private int E;
    private Bag<Integer>[] adj;

    public DirectGraph(int v){
        this.V = v;
        this. E = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for(int i = 0; i < V; i++){
            adj[i] = new Bag<Integer>();
        }
    }

    public void addEdge(int w, int v){
        adj[w].add(v);
        E++;
    }

    public int V(){
        return V;
    }
    public int E(){
        return E;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public DirectGraph reverse(){
        DirectGraph reverseGraph = new DirectGraph(V);
        for(int v = 0; v < V; v++){
            for(int w : adj(v)){
                reverseGraph.addEdge(w, v);
            }
        }
        return reverseGraph;
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
        DirectGraph dg = new DirectGraph(13);
        dg.addEdge(4, 2);   dg.addEdge(2, 3);   dg.addEdge(3, 2);
        dg.addEdge(6, 0);   dg.addEdge(0, 1);   dg.addEdge(2, 0);
        dg.addEdge(11, 12); dg.addEdge(12, 9);  dg.addEdge(9, 10);
        dg.addEdge(9, 11);  dg.addEdge(8, 9);   dg.addEdge(10, 12);
        dg.addEdge(11, 4);  dg.addEdge(4, 3);   dg.addEdge(3, 5);
        dg.addEdge(7, 8);   dg.addEdge(8, 7);   dg.addEdge(5, 4);
        dg.addEdge(0, 5);   dg.addEdge(6, 4);   dg.addEdge(6, 9);
        dg.addEdge(7, 6);
        System.out.println(dg.toString());  

        DirectGraph reverseGraph = dg.reverse();
        System.out.println(reverseGraph.toString());  
        	
    } 	
} 

