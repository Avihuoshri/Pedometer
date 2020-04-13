package com.magicdate.pesometer;
class Node {
    public Node prev, next;
    private Route route;
    public Node(Route route, Node prev, Node next){
        this.route = new Route();
        this.next = next;
        this.prev = prev;
    }
    public String toString(){ return ""+this.route; }
    public void setRoute(Route route){ this.route = route; }
    public Route getRoute(){ return this.route; }
    public Node getNext(){ return this.next;}
    public Node getPrev(){ return this.prev; }
}
