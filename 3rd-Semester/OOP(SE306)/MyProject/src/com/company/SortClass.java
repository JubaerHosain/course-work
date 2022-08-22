package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//comparable vs comparator

class Node implements Comparable<Node> {
    public int a, b;

    public Node(int a, int b) {
        this.a = a;
        this.b = b;
    }


    @Override
    public int compareTo(Node o) {
        if(this.a == o.a)
            return this.b - o.b;
        return this.a - o.a;
    }
}

class Tree {
    public int a, b;

    public Tree(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class SortClass {
    public void printCollection(Collection<Node> collection) {
        for(Node obj: collection) {
            System.out.println(obj.a + " " + obj.b);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortClass sortClass = new SortClass();


        List<Node> list = new ArrayList<>();
        list.add(new Node(2, 4));
        list.add(new Node(-1, 234));
        list.add(new Node(24, 24));
        list.add(new Node(3, 532));
        list.add(new Node(3, 232));

        Collections.sort(list);
        sortClass.printCollection(list);

        Collections.sort(list, Collections.reverseOrder());
        sortClass.printCollection(list);

        List<Tree> list1 = new ArrayList<>();
        list1.add(new Tree(2, 4));
        list1.add(new Tree(-1, 234));
        list1.add(new Tree(24, 24));

        // Collections.sort(list1);
        Collections.shuffle(list1);
        Collections.reverse(list);

        Node node = Collections.max(list);
        System.out.println(node.a + " " + node.b);
        // System.out.println(Collections.max(list1));

    }
}


















