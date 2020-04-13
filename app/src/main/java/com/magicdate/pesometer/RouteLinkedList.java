package com.magicdate.pesometer;

class RouteLinkedList {// Double Cycle Linked List

    public Node head, tail;
    private int size;
    // Constructor,  constructs an empty list
    public RouteLinkedList(){
        head = tail = null;
        size = 0;
    }

    // Appends the specified element to the end of this list.
    public void add(Route route){
        Node prev= null,next = null;
        if (head == null)
        {
            head =new  Node(route, prev, next);
            tail = head;
            head.next = head.prev = tail;
        }
        else
        {
            Route n = new Route();
            tail.next.setRoute(n);
            tail.setRoute(n);
            head.prev = tail;
        }
        size++;
    }
    public Node getHead(){
        return head;
    }
    public Node getNext(Node n){
        return n.next;
    }
    public String toString(){
        String s = "[";
        if (head != null){
            s = s + head.toString() + ", ";
            for (Node n = head.next; n != head; n=n.next){
                s = s + n.toString() + ", ";
            }
            s = s.substring(0, s.length()-2);
        }
        return s+"]";
    }
}
