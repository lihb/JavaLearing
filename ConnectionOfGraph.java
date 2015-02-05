/**
 * ClassName:	  ConnectionOfGraph 
 * description:   深度优先搜索查看图的连通分量
 * Author:	  lhb
 * Date:	 2014-05-13 13:48:40
 * Version:		 1.0
 *
 */
import java.util.*;
import java.util.Stack;

public class ConnectionOfGraph{

    private boolean[] marked = null;
    private int[] ids = null;
    private int count;

    public ConnectionOfGraph(Graph g){
	marked = new boolean[g.V()];
	ids = new int[g.V()];
	for(int s = 0; s < g.V(); s++){
	     if(!marked[s]){
	         dfs(g, s);
		 count++;
	     }   
	}
    }

    public void dfs(Graph g, int v){
	marked[v] = true;
	ids[v] = count;
	 for(int w : g.adj(v)){
	     if(!marked[w]){
		 dfs(g, w);
	      }     
    	 }	
    }

    public boolean connected(int v, int w){
    	return ids[v] == ids[w];
    }

    public int id(int v){
    	return ids[v];
    }

    public int count(){
    	return count;
    }

    public static void main(String[] args){
        Graph g = new Graph(13);
	g.addEdge(0, 6);
	g.addEdge(0, 2);
	g.addEdge(0, 1);
	g.addEdge(0, 5);
	g.addEdge(3, 5);
	g.addEdge(3, 4);
	g.addEdge(4, 5);
	g.addEdge(4, 6);
	g.addEdge(7, 8);
	g.addEdge(9, 10);
	g.addEdge(9, 11);
	g.addEdge(9, 11);
	g.addEdge(9, 12);
	System.out.println(g.toString());
	ConnectionOfGraph cg = new ConnectionOfGraph(g);
	int M = cg.count();
	System.out.println(M +"components");
	Bag<Integer>[] components = (Bag<Integer>[]) new Bag[M];
	for(int i = 0; i < M; i++){
	    components[i] = new Bag<Integer>();
	}
	for(int v = 0; v < g.V(); v++){
	     components[cg.id(v)].add(v);    
	}
	for(int i = 0; i < M; i++){
	     for(int v: components[i]){
	     	System.out.print(v + " ");
	     }
	     System.out.println();

	}
   }
}
