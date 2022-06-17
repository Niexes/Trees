package com.company;

public class Main {

    public static void main(String[] args) {
        Tree nt = new Tree();
        Tree heh = new Tree();

        nt.add(33);
        nt.add(3);
        nt.add(32);
        nt.add(11);
        nt.add(5);
        nt.add(20);
        nt.add(43);
        nt.add(7);
        nt.add(16);
        nt.traverseInOrder(nt.root);
        nt.add(22);
        System.out.println();
        nt.traverseInOrder(nt.root);
        System.out.println();
        heh.simpleAdd(555, heh.root);
        heh.simpleAdd(424, heh.root);
        heh.traverseInOrder(heh.root);
    }
}
