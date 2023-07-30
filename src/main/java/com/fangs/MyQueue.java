package com.fangs;

import java.util.LinkedList;

/**
 * 232. 用栈实现队列
 * @author fangs
 */
public class MyQueue {

    public static void main(String[] args) {
//        ["MyQueue","push","push","push","push","pop","push","pop","pop","pop","pop"]
//        [[],[1],[2],[3],[4],[],[5],[],[],[],[]]
        MyQueue myQueue = new MyQueue();
        myQueue.push(2);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.pop());
        myQueue.push(5);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
    }

    private LinkedList<Integer> pushStack;
    private LinkedList<Integer> readStack;

    public MyQueue() {
        pushStack = new LinkedList<>();
        readStack = new LinkedList<>();
    }

    public void push(int x) {
        while (readStack.size()>0){
            pushStack.push(readStack.pop());
        }
        pushStack.push(x);
    }

    public int pop() {
        while (pushStack.size()>0){
            readStack.push(pushStack.pop());
        }
        return readStack.pop();
    }

    public int peek() {
        while (pushStack.size()>0){
            readStack.push(pushStack.pop());
        }
        return readStack.peek();
    }

    public boolean empty() {
        return pushStack.size()==0 && readStack.size()==0;
    }
}
