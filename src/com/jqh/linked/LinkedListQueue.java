package com.jqh.linked;

import com.jqh.inter.Queue;

/**
 * 链表实现队列
 * @param <E>
 */
public class LinkedListQueue<E> implements Queue<E> {

    // 虚拟的链表头，为添加删除操作统一处理

    private class Node{
        public E e;
        public Node next ;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
            this(null,null);
        }


        @Override
        public String toString() {
            if(e != null)
                return e.toString();
            return null;
        }

    }

    private Node header , tail;
    private int size ;

    public LinkedListQueue() {
        header = tail = null ;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    // 添加到尾部
    @Override
    public void enqueue(E e) {
        if(tail == null){
            tail = new Node(e,null);
            header = tail ;
        }else{
            tail.next = new Node(e,null);
            tail = tail.next ;
        }
        size++;
    }
    // 从头部删除
    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        Node retNode = header;
        header = header.next ;
        retNode.next = null;
        if(header == null)
            tail = null;
        size--;
        return retNode.e ;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Cannot getFront from an empty queue.");
        return header.e;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LinkedListQueue:front ");
        Node curNode = header;
        while (curNode != null){
            builder.append(curNode.e+"->");
            curNode = curNode.next ;
        }
        builder.append("NULL tail");
        return builder.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> arrayQueue = new LinkedListQueue<>();
        for(int i = 0 ; i < 10 ; i++){
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
        }
        for(int i = 0 ; i < 10 ; i++){
            arrayQueue.dequeue();
            System.out.println(arrayQueue);
        }

    }
}
