package com.jqh.linked;

/**
 * 链表结构
 */
public class LinkedList<E> {

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

    private Node dummyHeader;
    private int size ;

    public LinkedList(){
        dummyHeader = new Node();
        size = 0 ;
    }

    public int getSize(){
        return size ;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int find(E e){
        Node node = dummyHeader ;
        for(int i = 0 ; i < size ; i++){
            node = node.next;
            if(node.e.equals(e)){
                return i;
            }
        }
        return -1 ;
    }
    public E getFirst(){
        if(isEmpty())
            throw new IllegalArgumentException("can getFirst for empty linklist");
        Node node = dummyHeader.next;
        return node.e ;
    }

    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");
        Node node = dummyHeader ;
        for(int i = 0 ; i <= index ; i++){
            node = node.next;
        }
        return node.e ;
    }

    public E getLaset(){
        if(isEmpty())
            throw new IllegalArgumentException("can getLaset for empty linklist");
        return get(size-1);
    }

    public void add(int index ,E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("add failed. Illegal index.");

        Node node = new Node(e,null);
        Node preNode = dummyHeader ;
        for(int i = 0 ; i < index ; i++){
            preNode = preNode.next ;
        }
        node.next = preNode.next ;
        preNode.next= node ;
        size++;
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

    public E remove(int index){
        if(isEmpty()){
            throw new IllegalArgumentException("can't remove for empty linklist");
        }
        Node preNode = dummyHeader ;
        for(int i = 0 ; i < index ; i++){
            preNode = preNode.next;
        }
        Node curNode = preNode.next ;
        preNode.next = curNode.next;
        curNode.next = null ;
        size--;
        return curNode.e;
    }
    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size);
    }

    public void removeElement(E e){
        if(isEmpty())
            throw new IllegalArgumentException("can't removeElement for empty removeElement");
        int index = find(e);
        if(index == -1){
            throw new IllegalArgumentException("can't removeElement for no this element");
        }
        remove(index);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("linkedList:");
        Node curNode = dummyHeader ;
        for(int i = 0 ; i < size ; i++){
            curNode = curNode.next;
            builder.append(curNode);
            if(i != size-1){
                builder.append("->");
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0 ; i < 10; i++ ){
            linkedList.addLast(i);
            System.out.println(linkedList);
        }

        linkedList.removeElement(2);
        System.out.println(linkedList);
    }

}
