package lesson_3;

public class hm3 {

    public static void main(String[] args) {
        oList list1 = new oList();
        dList list2 = new dList();
        for (int i = 1; i < 10; i++) {
            list1.pushFront(i);
            list2.pushBack(i);
        }
        System.out.println("Односвязный лист");
        list1.print();
        list1.reverse();
        list1.print();

        System.out.println();
        System.out.println("Двухсвязный лист");
        list2.print();
        list2.reverse();
        list2.print();
    }
}

class oList{
    Node head;
    static class Node{
        int value;
        Node next;
    }
    public void reverse(){
        if(head != null && head.next != null){
            Node last = head;
            reverse(head.next, head);
            last.next = null;
        }

    }
    private void reverse(Node currentNode, Node previusNode){
        if(currentNode.next == null){
            head = currentNode;
        } else {
            reverse(currentNode.next, currentNode);
        }
        currentNode.next = previusNode;
    }

    public void pushFront(int value){
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }


    public void popFront(){
        if(head != null){
            head = head.next;
        }
    }

    public void print(){
        Node node = head;
        while(node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public boolean find(int value){
        Node node = head;
        while(node != null){
            if(node.value == value){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void pushBack(int value){
        Node node = new Node();
        node.value = value;

        if(head == null){
            head = node;
        }else{
            Node cur = head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }

    }

    public void popBack(){
        if(head != null){
            if(head.next == null){
                head = null;
            }else {
                Node cur = head;
                while (cur.next.next != null) {
                    cur = cur.next;
                }
                cur.next = null;
            }
        }
    }

}

class dList{
    Node head;
    Node tail;
    class Node{
        int value;
        Node next;
        Node prev;
    }

    public void reverse(){
        Node cur = head;
        while(cur != null){
            Node next = cur.next;
            Node prev = cur.prev;
            cur.next = prev;
            cur.prev = next;
            if (prev == null){
                tail = cur;
            }
            if (next == null){
                head = cur;
            }
            cur = next;
        }
    }

    public void pushFront(int value){
        Node node = new Node();
        node.value = value;

        if(head == null){
            tail = node;
        }else{
            node.next = head;
            head.prev = node;
        }
        head = node;
    }

    public void popFront(){
        if(head != null && head.next != null){
            head = head.next;
        }else{
            tail = null;
            head = null;
        }
    }

    public void print(){
        Node node = head;
        while(node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public boolean find(int value){
        Node node = head;
        while(node != null){
            if(node.value == value){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void pushBack(int value){
        Node node = new Node();
        node.value = value;

        if(tail == null){
            head = node;
        }else{
            node.prev = tail;
            tail.next = node;
        }
        tail = node;

    }

    public void popBack(){
        if(tail != null && tail.prev != null){
            tail = tail.prev;
            tail.next = null;
        }else{
            tail = null;
            head = null;
        }
    }

    public void sort(){
        boolean needSort = true;
        do{
            needSort = false;
            if(head != null) {
                Node node = head;
                while (node != null && node.next != null) {
                    if(node.value > node.next.value){
                        Node before = node.prev;
                        Node cur = node;
                        Node next = node.next;
                        Node after = next.next;

                        cur.next = after;
                        cur.prev = next;
                        next.next = cur;
                        next.prev = before;

                        if(after != null){
                            after.prev = cur;
                        }else{
                            tail = cur;
                        }

                        if(before != null){
                            before.next = next;
                        }else{
                            head = next;
                        }

                        needSort = true;
                    }
                    node = node.next;
                }
            }
        }while(needSort);
    }

}

