package com.magicdate.pesometer.navigation;

import android.util.Log;

public class RouteLinkedList {// Double Cycle Linked List

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
            Node n = new Node(route, tail, head);
            tail.next = n;
            tail = n;
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


    public String sourceDestToString() {
        String s = "[";
        if (head != null){
            s = s + head.getSource() + " -> " + head.getDestination() + ", ";
            for (Node n = head.next; n != head; n=n.next){
                int routeSize = n.getRoute().getPoints().size();
                Point sourcePoint = n.getRoute().getPoints().get(0);
                Point destPoint = n.getRoute().getPoints().get(routeSize - 1);
                s = s + n.getSource() + " " + sourcePoint.toString() + " -> " + n.getDestination() + destPoint.toString() + ", ";
            }
            s = s.substring(0, s.length()-2);
        }
        return s+"]";
    }
}
