package queue_stack.bai_tap;

import object_and_class.bai_tap.Phuong_Trinh_Bac_2;

public class QueueCircleLinkedList {
    static class Node{
        int data;
        Node link;
    }
    static class Queue{
        Node front;
        Node rear;
    }

    static void enQueue(Queue element,int value){
        Node temp = new Node();
        temp.data = value;
        if(element.front == null){
            element.front = element.rear = temp;
        } else {
            element.rear.link = temp;
        }
        element.rear = temp;
        element.rear.link = element.front;
    }
    static int deQueue(Queue element){
        int hold = 0;
        if (element.front == null){
            System.out.println("Queue Empty");
        } else if (element.front == element.rear){
            hold = element.front.data;
            element.front = null;
            element.rear = null;
        } else {
            hold = element.front.data;
            element.front = element.front.link;
            element.rear.link = element.front;
        } return hold;
    }
    static void displayQueue(Queue element){
        Node temp = element.front;
        while(temp.link != element.front){
            System.out.println(temp.data);
            temp = temp.link;
        }
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        Queue newQueue = new Queue();
        newQueue.rear = null;
        newQueue.front = null;
        enQueue(newQueue,10);
        enQueue(newQueue,12);
        enQueue(newQueue,13);
        displayQueue(newQueue);
    }
}
