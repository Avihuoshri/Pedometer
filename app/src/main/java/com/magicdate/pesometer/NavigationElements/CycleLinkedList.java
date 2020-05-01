package com.magicdate.pesometer.NavigationElements;

import android.util.Pair;

import java.io.Serializable;
import java.util.LinkedList;

public class CycleLinkedList implements Serializable {// Double Cycle Linked List

    public PathNode head, tail;
    private int size;
    private LinkedList<PathNode> shoppingLists_srcDestOnly;

    // Constructor,  constructs an empty list
    public CycleLinkedList(){
        head = tail = null;
        size = 0;
        shoppingLists_srcDestOnly = new LinkedList<>();
    }

    // Appends the specified element to the end of this list.
    public void add(Path path){
        PathNode prev= null,next = null;
        if (head == null)
        {
            head =new PathNode(path, prev, next);
            tail = head;
            head.next = head.prev = tail;

        }
        else
        {
            PathNode n = new PathNode(path, tail, head);
            tail.next = n;
            tail = n;
            head.prev = tail;
        }
        size++;

    }

    public PathNode getHead(){
        return head;
    }

    public PathNode getNext(PathNode n){
        return n.next;
    }

    public String toString(){
        String s = "[";
        if (head != null){
            s = s + head.toString() + ", ";
            for (PathNode n = head.next; n != head; n=n.next){
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
            shoppingLists_srcDestOnly.add(head);
            for (PathNode n = head.next; n != head; n=n.next){
                int routeSize = n.getPath().getPoints().size();
                Point sourcePoint = n.getPath().getPoints().get(0);
                Point destPoint = n.getPath().getPoints().get(routeSize - 1);
                s = s + n.getSource() + " " + sourcePoint.toString() + " -> " + n.getDestination() + destPoint.toString() + ", ";
                shoppingLists_srcDestOnly.add(n);
            }
            s = s.substring(0, s.length()-2);
        }
        return s+"]";
    }

    public LinkedList<PathNode> getShoppingLists_srcDestOnly() {
        return shoppingLists_srcDestOnly;
    }
}
