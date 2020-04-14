package com.magicdate.pesometer.navigation;

public class Node {
    public Node prev, next;
    private Route route;
    private String source, destination;

    public Node(Route route, Node prev, Node next){
        this.route = new Route();
        this.next = next;
        this.prev = prev;
        this.source = prev.destination;

    }

    public void setSource(String source) { this.source = source; }

    public void setDestination(String destination) { this.destination = destination; }

    public String getSource() { return source; }

    public String getDestination() { return destination; }

    public void setRoute(Route route){ this.route = route; }

    public Route getRoute(){ return this.route; }

    public Node getNext(){ return this.next;}

    public Node getPrev(){ return this.prev; }

    public String toString(){ return ""+this.route; }



}
