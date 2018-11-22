package com.jqh.array;

public class Array<E> {

    private E[] data;

    // size是指向数组下一个元素的索引，也可以用来计算当前存放元素的个数
    private int size ;

    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0 ;
    }

    public  Array(){
        this(10);
    }

    public int getSize(){
        return size ;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getCapacity(){
        return data.length;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("get fail! index is of out array");
        }
        return data[index];
    }

    public int find(E e){
        for(int i = 0 ; i < size ; i++){
            if(data[i].equals(e)){
                return i ;
            }
        }
        return -1;
    }

    public boolean container(E e){
        for(int i = 0 ; i < size ; i++){
            if(data[i].equals(e)){
                return true ;
            }
        }
        return false;
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

    public void add(int index , E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("set fail! index is of out array");
        }

        if(size == data.length){
            resize(data.length * 2);
        }

        for(int i = size  ; i > index ; i--){
            data[i] = data[i-1];
        }
        data[index] = e ;
        size++ ;

    }

    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("remove fail! index is of out array");
        }
        E ret = data[index];
        for(int i = index ; i < size - 1 ; i++){
            data[i] = data[i + 1];
        }
        size-- ;
        //  懒惰模式缩容，size为容量的四分之一且不等于1时候，开始缩小一半容量
        if(size == data.length/4 && data.length/2 != 0){
            resize(data.length/2);
        }
        return ret ;
    }

    public E removeLast(){
        return remove(size-1);
    }
    public E removeFirst(){
        return remove(0);
    }

    public void removeElement(E e){
        int i = find(e);
        if(i != -1)
            remove(i);
    }
    /**
     * 改变容量
     * @param newCapacity
     */
    private void resize(int newCapacity){
        E[] newData = (E[])(new Object[newCapacity]);
        for(int i = 0 ; i < size ; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append("[");
        for(int i = 0 ; i < size ; i++){
            res.append(data[i]);
            if(i != size-1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        System.out.println("start add......");
        for(int i = 0 ; i < 20; i++){
            array.addLast(i);
            System.out.println(array);
        }
        System.out.println("start del......");
        for(int i = 0 ; i < 20; i++){
            array.removeLast();
            System.out.println(array);
        }
    }
}
