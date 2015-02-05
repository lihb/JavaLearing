import java.util.Iterator;
/**
 *Bag类：用链表的形式实现
 *主要功能有，往里面添加元素，判断是否为空，bag的大小和迭代。
 */

public class Bag<Item> implements Iterable<Item>{

    /*私有类*/
    private class Node{
        Item item;
        Node next;
    }
    
    private Node first;  //链表的首结点
    private int N;       //size

    /* 往背包里添加元素的方法*/
    public void add(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    /*判断背包是否为空*/
    public boolean isEmpty(){
        return (N == 0);
    }

    /*返回背包中元素的数量*/
    public int size(){
        return N;
    }
    
    /*实现可迭代性能*/
    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    /* 需实现Iterator接口*/
    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){
            return current != null;
        }
        public void remove(){}

        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}

