package lesson_3;

public class lec3 { // list

    public static void main(String[] args) {
        List myList = new List();
        myList.add(5);
        System.out.println(myList.find(5));
    }
}
class List{
    Node head;
    Node tail;
    public void add(int value){
        Node node = new Node();
        node.value = value;
        if (head == null){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previus = tail;
            tail = node;
        }
    }
    public void add(int value, Node node){
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previus = node;
        if (next == null){
            tail = newNode;
        } else {
            next.previus = newNode;
            newNode.next = next;
        }
    }
    public void delete(Node node){
        Node previus = node.previus;
        Node next = node.next;
        if(previus == null){
            next.previus = null;
            head = next;
        } else {
            if (next == null) {
                previus.next = null;
                tail = previus;
            } else {
                previus.next = next;
                next.previus = previus;
            }
        }
    }

    public void revert(){
        if(head != null && head.next != null){
            revert(head.next, head);
        }
    }
    private void revert(Node currentNode, Node previusNode){
        if(currentNode.next == null){
            head = currentNode;
        } else {
            revert(currentNode.next, currentNode);
        }
        currentNode.next = previusNode;
    }
//    public void revert(){
//        Node currentNode = head;
//        while(currentNode != null){
//            Node next = currentNode.next;
//            Node previus = currentNode.previus;
//            currentNode.next = previus;
//            currentNode.previus = next;
//            if (previus == null){
//                tail = currentNode;
//            }
//            if (next == null){
//                head = currentNode;
//            }
//            currentNode = next;
//        }
//    }
    public Node find(int value){
        Node currentNode = head;
        while(currentNode != null){
            if(currentNode.value == value){
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }
    public class Node{
        int value;
        Node next;
        Node previus;
    }

}
