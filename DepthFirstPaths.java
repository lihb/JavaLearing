/**
 * ClassName:     DepthFirstPaths
 * description:   深度优先搜索查找某点的所有路径
 * Author:        lhb
 * Date:         2014-05-10 21:04:14
 * Version:		 1.0
 *
 */
import java.util.*;
import java.util.Stack;

public class  DepthFirstPaths {

    private boolean[] marked = null;   // 标记数组，已访问过则标记为真
    private int[] edgeTo = null;       // 走过的边的数组
    private int s;                      // 从 s 点开始查找
    public  DepthFirstPaths(Graph G, int s){  // 构造函数
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs_digui(G, s);
    }

    public void dfs_digui(Graph g, int v){   // 递归形式实现
        marked[v] = true;
        for(int w : g.adj(v)){
            if(!marked[w]){
                edgeTo[w] = v;
                dfs_digui(g, w);
            }
        }	
    }

    public void dfs(Graph g, int s){  // 非递归方式
        Stack stack = new Stack();
        marked[s] = true;
        stack.push(s);
        while(!stack.empty()){
           int[] temp = g.adj(s);
           int v = temp[temp.length-1];
           marker[v] =true;
           edgeTo[v] = s;
        }
    }

    public boolean hasPathTo(int w){
        return marked[w];
    }

    public Stack pathsTo(int w){
        if(!hasPathTo(w)) return null;
        Stack path = new Stack();
        for(int x = w; x != s; x = edgeTo[x]){
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
        System.out.println(g.toString());   // 打印出图

        DepthFirstPaths dfp = new DepthFirstPaths(g, 0);
        for(int v = 0; v < g.V(); v++){     //打印出从 0 到其他点的路径，路径顺序与构造图的时候添加边的顺序是有关系的。    
            System.out.print(0 +" to "+ v +": "); 
            if(dfp.hasPathTo(v)){
                Stack path = dfp.pathsTo(v);
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

