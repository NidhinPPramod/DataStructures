import java.util.HashMap;
import java.util.*;

public class freqStack {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node top = null;

    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public void display() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
    }

    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void count() {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        Node temp = top;
        Node cc = null;
        int count = 0;
        while (temp.next != null) {
            cc = temp;
            while (cc != null) {
                if (temp.data == cc.data) {
                    count = count + 1;
                    cc = cc.next;
                } else {
                    cc = cc.next;
                }
            }
            hm.put(temp.data, count);
            temp = temp.next;
            while (hm.containsKey(temp.data) && temp.next != null) {
                temp = temp.next;
            }
            count = 0;
        }
        System.out.println(hm);
        int maxValueInMap = (Collections.max(hm.values()));
        System.out.println("Most Occurence is for:" + getKey(hm, maxValueInMap));
    }

    public static void main(String[] args) {
        freqStack f = new freqStack();
        f.push(20);
        f.push(20);
        f.push(20);
        f.push(30);
        f.push(30);
        f.push(10);
        f.push(20);
        f.push(10);
        f.push(30);
        f.push(10);
        f.display();
        f.count();
    }
}
