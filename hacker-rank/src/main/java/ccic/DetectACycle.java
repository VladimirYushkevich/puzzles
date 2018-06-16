package ccic;

import java.util.HashSet;
import java.util.Set;

public class DetectACycle {
    class Node {
        int data;
        Node next;
    }

    boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }

        Set<Node> nodes = new HashSet<>();

        Node current = head;
        while (current.next != null) {
            current = current.next;
            if (nodes.contains(current)) {
                return true;
            }
            nodes.add(current);
        }

        return false;
    }
}
