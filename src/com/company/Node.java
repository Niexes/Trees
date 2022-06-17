package com.company;

public class Node {
    int value; // УЗЕЛ. У УЗЛА ЕСТЬ ВНУТРИ КАКОЕ ТО ИНТОВОЕ ЗНАЧЕНИЕ. А ЕЩЕ У НЕГО ЕСТЬ ЛЕВЫЙ И ПРАВЫЙ УЗЕЛ
    Node left;
    Node right;

    Node(int value) { //конструктор узла
        this.value = value;
        right = null;
        left = null;
    }

}
