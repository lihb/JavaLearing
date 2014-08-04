/**
 * ClassName:     DirectCycle
 * description:  判断有向图中是否包含环
 * Author:        lhb
 * Date:         2014-05-14 09:04:37
 * Version:		 1.0
 *
 */
import java.util.*;
import java.util.Stack;
 
public class  DirectCycle {

    private boolean[] marked;
    private boolean[] onStack;
    private Stack  cycle;
    private int[] edgeTo;

    public DirectCycle(DirectGraph dg){
        int V = dg.V();
        marked = new boolean[V];
        onStack = new boolean[V];
        edgeTo = new int[V];
        for(int v = 0; v < V; v++){
            if(!marked[v])
                dfs(dg, v);
        }
    }

    public void dfs(DirectGraph dg, int v){ //dfs算法：一旦我们找到了一条边v——>w，并且w已经在栈中，就找到了一个环。
        marked[v]  = true;
        onStack[v] = true;
        for(int w : dg.adj(v)){
            if(this.hasCycle())
                return;
            else if(!marked[w]){
                edgeTo[w] = v;
                dfs(dg, w);
            }
            else if(onStack[w]){
                cycle = new Stack();
                for(int x = v ; x != w; x = edgeTo[x]){
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }
    public boolean hasCycle(){
        return cycle != null;
    }
    public Iterable<Integer> cycle(){  //返回环中的元素
        return cycle;
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
        DirectCycle dc = new DirectCycle(dg);
        System.out.println("the vertexs in the cycle are:");  
        for(Integer v : dc.cycle()){
            System.out.print(v + " ");  
        } 	
    } 	
} 

