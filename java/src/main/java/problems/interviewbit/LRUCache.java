package problems.interviewbit;

import java.util.*;

public class LRUCache {


    /*static class Node{
        public int key;
        public int value;
        public Node next;
        public Node pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<>();
    private Node head = null;
    private Node end = null;


    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }
        else{
            Node created = new Node(key, value);
            if(map.size() >= capacity){
                System.out.println("Removing : ");
                map.remove(end.key);
                remove(end);
                setHead(created);
            }
            else{
                setHead(created);
            }
            map.put(key, created);
        }

    }

    public void setHead(Node n){
        n.next = head;
        n.pre = null;
        if(head != null)
            head.pre = n;
        head = n;
        if(end == null)
            end = head;
    }

    public void remove(Node n){
        if(n.pre != null)
            n.pre.next = n.next;
        else
            head = n.next;

        if(n.next != null)
            n.next.pre = n.pre;
        else
            end = n.pre;
    }*/


    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        //Have dummy head and tail node
        head = new DLinkedNode();
        // head.prev = null;

        tail = new DLinkedNode();
        // tail.next = null;

        head.next = tail;
        tail.prev = head;
    }


    private void addNode(DLinkedNode node) {
        /**
         * Always add the new node right after head.
         */
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node){
        /**
         * Remove an existing node from the linked list.
         */
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node){
        /**
         * Move certain node in between to the head.
         */
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        /**
         * Pop the current tail.
         */
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        // move the accessed node to the head;
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            ++size;

            if(size > capacity) {
                // pop the tail
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            // update the value.
            node.value = value;
            moveToHead(node);
        }
    }

}
