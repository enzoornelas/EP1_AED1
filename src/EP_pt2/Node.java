package EP_pt2;

public class Node {
    private Integer element;
    private Node next;

    public Node(Integer s, Node n){
        element = s;
        next = n;
    }

    public Integer getElement(){ return element; }
    public Node getNext(){ return next; }
    public void setElement(Integer newElement){ element = newElement; }
    public void setNext(Node newNext){ next = newNext; }
}