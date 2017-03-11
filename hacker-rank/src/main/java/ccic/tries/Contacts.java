package ccic.tries;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Contacts {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node root = new Node();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();
            if (op.equals("add")) {
                insert(root, contact);
            }
            if (op.equals("find")) {
                System.out.println(getNumberOfPartialWords(root, contact));
            }
        }
    }

    static int getNumberOfPartialWords(Node root, String contact) {
        Node lastChild = getLastChild(root, contact);

        if (lastChild == null) {
            return 0;
        }

        return lastChild.numberOfWords;
    }

    static Node getLastChild(Node root, String contact) {
        Node lastChild = root;
        for (char key : contact.toCharArray()) {
            Node node = lastChild.children.get(key);
            if (node == null) {
                return null;
            }
            lastChild = node;
        }

        return lastChild;
    }

    static void insert(Node root, String contact) {
        Node lastChild = root;
        for (char key : contact.toCharArray()) {
            Node node = lastChild.children.getOrDefault(key, new Node());
            node.numberOfWords++;
            lastChild.children.put(key, node);
            lastChild = node;
        }
        lastChild.isLeaf = true;
    }

    static class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isLeaf;
        int numberOfWords;
    }
}
