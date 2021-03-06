package com.jqh.linked;

import com.jqh.inter.Stack;

/**
 * 链表实现栈
 * @param <E>
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> linkedList ;

    public LinkedListStack(){
        linkedList = new LinkedList<>();

    }
    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(linkedList);
        return res.toString();

    }

    public static void main(String[] args) {
        LinkedListStack<String> arrayStack = new LinkedListStack();
        for(int i = 0 ; i < 10; i++){
            arrayStack.push(i+"");
            System.out.println(arrayStack);
        }

        for(int i = 0 ; i < 10; i++){
            arrayStack.pop();
            System.out.println(arrayStack);
        }
    }
}
