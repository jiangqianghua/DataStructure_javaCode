package com.jqh.array;

import com.jqh.inter.Queue;

/**
 * 循环数组队列
 * @param <E>
 */
public class ArrayLoopQueue<E> implements Queue<E> {

    private E[] data ;
    private int size ;
    // 队列头
    private int front ;
    // 队列尾部,指向最后一个空的元素，有意浪费一个空间
    private int tail ;

    public ArrayLoopQueue(){
        data = (E[])(new Object[10]);
    }
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int getCapacity(){
        return data.length - 1 ;
    }

    @Override
    public void enqueue(E e) {
        if((tail + 1)%data.length == front){
            resize(data.length*2);
        }
        data[tail] = e ;
        size++;
        tail = (tail + 1)%data.length ;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        front = (front + 1)%data.length;
        size--;
        if(size == getCapacity()/4 && getCapacity()/2 != 0 ){
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Cannot getFront from an empty queue.");
        return data[front];
    }

    private void resize(int capacity){
        E[] newData = (E[])(new Object[capacity+1]);
        for(int i = 0 ; i < size ; i++){
            newData[i] = data[(i+front)%data.length];
        }
        data = newData;
        front = 0 ;
        tail = size ;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("ArrayLoopQueue size=%d capacity=%d\n",size,getCapacity()));
        builder.append("front [");
        for(int i = front ; i != tail ; i = (i + 1)%data.length){
            builder.append(data[i]);
            if((i + 1)%data.length != tail){
                builder.append(",");
            }
        }
        builder.append("] tail");
        return builder.toString();
    }

    public static void main(String[] args) {
        ArrayLoopQueue<Integer> arrayLoopQueue = new ArrayLoopQueue<>();
        for(int i = 0 ; i < 10 ; i++){
            arrayLoopQueue.enqueue(i);
            System.out.println(arrayLoopQueue);
        }
        for(int i = 0 ; i < 10 ; i++){
            arrayLoopQueue.dequeue();
            System.out.println(arrayLoopQueue);
        }
    }
}
