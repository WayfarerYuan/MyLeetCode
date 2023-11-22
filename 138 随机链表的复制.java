import java.util.ArrayList;
import java.util.List;

class Main138 {
    public static void main(String[] args) {
        Solution138 solution = new Solution138();
        Node head = new Node(7);
        Node cur = head;
        cur.next = new Node(13);
        cur = cur.next;
        cur.next = new Node(11);
        cur = cur.next;
        cur.next = new Node(10);
        cur = cur.next;
        cur.next = new Node(1);
        cur = cur.next;
        cur.random = head;
        cur = head.next;
        cur.random = cur.next.next;
        cur = cur.next;
        cur.random = head;
        cur = cur.next;
        cur.random = head.next.next;
        cur = solution.copyRandomList(head);
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution138 {
    public Node copyRandomList(Node head) {
        // Node copyHead = new Node(0);
        // Node cur = head;
        // Node copyCur = copyHead;

        // while (cur != null) {
        //     Node copyNext = new Node(0);
        //     copyCur.next = copyNext;
        //     copyCur = copyCur.next;

        //     copyCur.val = cur.val;
        //     cur = cur.next;
        // }

        // cur = head;
        // copyCur = copyHead.next;
        // while (cur != null) {
        //     if (cur.random == null) {
        //         copyCur.random = null;
        //     } else {
        //         int randomsVal = cur.random.val;
        //         Node searchNode = copyHead;
        //         while (searchNode != null) {
        //             if (searchNode.val == randomsVal) {
        //                 copyCur.random = searchNode;
        //                 break;
        //             }
        //             searchNode = searchNode.next;
        //         }
        //     }
        //     cur = cur.next;
        //     copyCur = copyCur.next;
        // }
        // return copyHead.next;
        List<Node> ogList = new ArrayList<>();
        Node cur = head;
        while (cur != null) {
            ogList.add(cur);
            cur = cur.next;
        }
        List<Node> newList = new ArrayList<>();
        Node newHead = new Node(0);
        Node newCur = newHead;
        for (Node ogNode: ogList) {
            newCur.next = new Node(ogNode.val);
            newCur = newCur.next;
            newList.add(newCur);
        }
        newCur = newHead.next;
        for (Node ogNode: ogList) {
            if (ogNode.random == null) {
                newCur.random = null;
            } else {
                int randomsIndex = ogList.indexOf(ogNode.random);
                newCur.random = newList.get(randomsIndex);
            }
            newCur = newCur.next;
        }
        return newHead.next;
    }
}