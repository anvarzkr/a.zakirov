Реализация красно-черного дерева.

Демонстрирует следующий код:

        RedBlackTree<String, Integer> redBlackTree = new RedBlackTree<String, Integer>();
        redBlackTree.put("zero", 0);
        redBlackTree.put("one", 1);
        redBlackTree.put("two", 2);
        redBlackTree.put("three", 3);
        System.out.println(redBlackTree.get("zero"));
        System.out.println(redBlackTree.get("one"));
        System.out.println(redBlackTree.get("two"));
        System.out.println(redBlackTree.get("three"));