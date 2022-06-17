package com.company;
/*
Добавить в класс “Двоичные деревья” следующие методы:
        1. multi, умножающий данные каждого узла на 3.
        2. sum, вычисляющий сумму всех данных в узлах дерева.
        3. count_neg, возвращающий число узлов с отрицательными данными.
        4. height, возвращающий высоту дерева.
        5. find, принимающий параметр d типа Т, и возвращающую указатель на любой узел, содержащий данные d, если такие узлы в дереве есть, и nullptr, если таких узлов нет.
        6. eval, вычисляющий выражение, заданное данным двоичным деревом
        (числа в листьях рассматриваются как операнды, а в промежуточных узлах  как
        коды операций 1 +, 2 - , 3 *, 4 /).
        7. reflect, меняющий дерево на его зеркальное отражение (правые и левые сыновья каждого узла меняются местами).
        8. mult, возвращающий произведение данных в узлах, которых есть оба
        сына.
        9. min, возвращающую минимальное значение данных в узлах дерева.*/

public class Tree { // совокупность узлов
    Node root; //у дерева есть УЗЕЛ КОРЕНЬ. у этого корня, так как он УЗЕЛ, есть какое то значение, то бишь root(value)
    private int treeSize; //у дерева есть размер дерева - количество узлов


    private Node addRecursive(Node current, int value) {
        if (current == null) { // если текущий узел нулл, то создаем новый узел с поданным значением
            return new Node(value);

        }
        if (value < current.value) { // если поданное значение меньше значения у текущего узла, например у корня, который мы получили
            //например, у нашего корня значение 3, а то которое мы хотим добавить 1,
            //то мы берем у ТЕКУЩЕГО корня (нам ведь его подали) ссылку на ЛЕВЫЙ УЗЕЛ и в итоге вся эта хуйня
            //сводится к первому иф, т.к. УЗЕЛ "ЛЕВЫЙ" == НУЛЛ И ТАКИМ ОБРАЗОМ МЫ СОЗДАЕМ НОВЫЙ УЗЕЛ С ЭТИМ ЗНАЧЕНИЕМ
            current.left = addRecursive(current.left, value);
            treeSize++;
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
            treeSize++;
        } else {
            // value already exists
            return current;
        }
        return current;
    }

    // нам адд рекурсив возвращает узел, в свою очередь мы передаем ему текущий узел и значение которое хотим добавиь
    public void add(int value) {
        root = addRecursive(root, value); //root 33
    }

    public static Node simpleAdd(int value, Node current) { //Этот метод я пытаюсь написать сама, остальные я спиздила с сайта.
        if (current == null) { // если я правильно понимаю, спизженный метод recursiveAdd добавляет в дерево сразу в отсортированном виде
            new Node(value);   //и у нас получается красно черное дерево??????
        }                       // так вот, я хотела написать метод простого добавления, чтобы он добавлял от корня потомки в неотсортированном виде
        else {
             if (current.left == null) {
                simpleAdd(value, current.left);
            } else if (current.left!=null && current.right == null) {
                simpleAdd(value, current.right);
            }
        }
        return current;
    }
        public Node find ( int key){ // (предполагается, что дерево не пустое)
            Node current = root; // Начать с корневого узла
            while (current.value != key) // Пока не найдено совпадение
            {
                if (key < current.value) // Двигаться налево?
                    current = current.left;
                else
                    current = current.right; // Или направо?
                if (current == null) // Если потомка нет,
                    return null; // поиск завершился неудачей
            }
            return current; // Элемент найден
        }


        public static boolean containsValue (Node current,int value){
            if (current == null) {
                return false;
            } else if (value == current.value) {
                return true;
            }
            return value < current.value ? containsValue(current.left, value) : containsValue(current.right, value);
        }


        public static void traverseInOrder (Node current){ //типа рекурсивный обход
            if (current != null) {
                traverseInOrder(current.left);
                System.out.print(" " + current.value);
                traverseInOrder(current.right);
            }
        }

    }
