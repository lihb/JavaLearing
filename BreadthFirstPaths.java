/**
 * ClassName:     BreadthFirstPaths
 * description:   广度优先搜索查最短路径
 * Author:        lhb
 * Date:         2014-05-10 22:48:40
 * Version:		 1.0
 *
 */
import java.util.*;
import java.util.Stack;
import java.util.PriorityQueue;

public class  BreadthFirstPaths {
    
    private boolean[] marked = null;
    private int[]     edgeTo = null;
    private int       s;

    public BreadthFirstPaths(Graph g, int s){
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s
        bfs(g, s);
    }

    public void bfs(Graph g, int v){   //非递归形式实现
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        marked[v] = true;
        pq.offer(v);
        while(pq.size()!=0){
            int w = pq.poll();
            for(int  m : g.adj(w)){
                if(!marked[m]){
                    edgeTo[m] = w;
                    marked[m] = true;
                    pq.offer(m);
                }
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Stack pathTo(int v){
        if(!hasPathTo(v)) 
            return null;
        Stack path = new Stack();
        for(int x = v; x != s; x = edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args){
        Graph g = new Graph(6);  // 构造图
        g.addEdge(0, 5);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(1, 2);
        g.addEdge(0, 1);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(0, 2);
        g.addEdge(0,4);
        System.out.println(g.toString());   // 打印出图

        BreadthFirstPaths bfs = new BreadthFirstPaths(g, 0);
        for(int v = 0; v < g.V(); v++){     //打印出从 0 到其他点的路径，路径顺序与构造图的时候添加边的顺序是有关系的。    
            System.out.print(0 +" to "+ v +": "); 
            if(bfs.hasPathTo(v)){
                Stack path = bfs.pathTo(v);
                while(!path.empty()){
                    int x = (Integer)path.pop(); 
                    if(x == 0) 
                        System.out.print(x); 
                    else
                        System.out.print("-" + x); 
                }	
            }
            System.out.println();  
        }
        
    } 	
} 

