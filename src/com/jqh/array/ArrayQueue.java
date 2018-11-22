package com.jqh.array;

import com.jqh.inter.Queue;

/**
 * 第一个版本,每次取出头，后面元素往前面移动，效率很低
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> data ;

    public ArrayQueue(){
        data = new Array<>();
    }
    @Override
    public int getSize() {
        return data.getSize();
    }

    public int getCapacity(){
        return data.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    @Override
    public E dequeue() {
        return data.removeFirst();
    }

    @Override
    public E getFront() {
        return data.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Queue ");
        builder.append("Front [");
        for(int i = 0 ; i < data.getSize() ; i++){
            builder.append(data.get(i));
            if(i != data.getSize() -1)
                builder.append(",");
        }

        builder.append("] tail");
        return builder.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
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
