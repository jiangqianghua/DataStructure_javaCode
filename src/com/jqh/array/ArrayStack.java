package com.jqh.array;

import com.jqh.inter.Stack;

/**
 * 数组实现栈
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {
    private Array<E> data ;
    private int size ;

    public ArrayStack(){
        data = new Array<>();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void push(E e) {
        data.addLast(e);
    }

    @Override
    public E pop() {
        return data.removeLast();
    }

    @Override
    public E peek() {
        return data.getLast();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Arraystack "));
        builder.append("[");
        for(int i = 0 ; i < data.getSize() ; i++){
            builder.append(data.get(i));
            if(i != data.getSize() -1){
                builder.append(",");
            }
        }
        builder.append("] top");
        return builder.toString();
    }

    public static void main(String[] args) {
        ArrayStack<String> arrayStack = new ArrayStack();
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
