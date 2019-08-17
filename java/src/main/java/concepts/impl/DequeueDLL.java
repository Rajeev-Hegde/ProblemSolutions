package concepts.impl;

import java.util.ArrayList;
import java.util.List;

//Implementation of Deque using Doubly linked list
public class DequeueDLL<E>{


    public Node<E> head;
    public Node<E> tail;


    private static class Node<E>{
        public E value;
        public Node<E> next;
        public Node<E> prev;

        public Node(E value) {
            this.value = value;
            this.next= null;
            this.prev= null;
        }
    }


    public void addFirst(E value ){
        Node<E> elem = new Node<>(value);
        if(head== null){
            head= elem;
            tail=elem;
        }
        else{
            elem.next = head;
            elem.prev= null;
            head.prev = elem;
            head = elem;
        }
    }

    public void addLast(E value){
        Node<E> elem = new Node<>(value);
        if(tail == null){
            head= elem;
            tail=elem;
        }
        else{
            elem.next= null;
            elem.prev= tail;
            tail.next = elem;
            tail = elem;
        }
    }

    public Node<E> removeFirst(){
        if(head==null)
            return  null;
        else{
            Node<E> firstElem = this.head;
            head = firstElem.next;
            if(firstElem==tail)
                tail= head;
            head.prev= null;
            firstElem.next=null;
            return firstElem;
        }
    }

    public Node<E> removeLast(){
        if(tail == null)
            return null;
        else {
            Node<E> lastElement = this.tail;
            tail = lastElement.prev;
            if(lastElement == head)
                head= tail;
            if(tail!=null)
                tail.next=null;
            lastElement.prev= null;
            return lastElement;
        }
    }


    public E peekFist(){
        if(this.head == null)
            return  null;
        else
            return this.head.value;
    }

    public E peekLast() {
        if(this.tail == null)
            return  null;
        else
            return this.tail.value;
    }



    public List<E> getAllValues(){
        if(head== null)
            return new ArrayList<>();
        else{
            List<E> res = new ArrayList<>();
            Node<E> iterator = head;
            while(iterator!=null){
                res.add(iterator.value);
                iterator= iterator.next;
            }
            return res;
        }
    }



    public static void main(String[] args) {
        DequeueDLL<Integer> dequeueDLL = new DequeueDLL<>();
        dequeueDLL.addFirst(2);
        dequeueDLL.addFirst(1);
        dequeueDLL.addLast(3);
        dequeueDLL.addFirst(0);
        System.out.println(dequeueDLL.peekLast());
        dequeueDLL.addLast(5);
        dequeueDLL.removeLast();
        dequeueDLL.addLast(4);
        dequeueDLL.addLast(5);
        System.out.println(dequeueDLL.getAllValues());
        dequeueDLL.removeLast();
        System.out.println(dequeueDLL.getAllValues());
        dequeueDLL.removeFirst();
        System.out.println(dequeueDLL.getAllValues());
        dequeueDLL.removeLast();
        dequeueDLL.removeLast();
        dequeueDLL.removeLast();
        dequeueDLL.removeLast();
        System.out.println(dequeueDLL.getAllValues());
        dequeueDLL.addLast(5);
        System.out.println(dequeueDLL.getAllValues());

    }
}
