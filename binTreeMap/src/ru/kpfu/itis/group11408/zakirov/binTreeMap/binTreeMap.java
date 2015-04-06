package ru.kpfu.itis.group11408.zakirov.binTreeMap;

/**
 * Created by Anvar on 04.04.2015.
 */
public class binTreeMap<K extends Comparable, V> {
    private Node<K, V> root = null;
    private int size = 0;

    public void put(K key, V value){
        Node<K, V> newNode = new Node<>(key, value);
        if (size++ == 0){
            root = newNode;
        }else{
            Node<K, V> currentNode = root;
            while (true){
                if (newNode.getKey().compareTo(currentNode.getKey()) > 0){
                    if (currentNode.hasRight()){
                        currentNode = currentNode.getRight();
                    }else{
                        currentNode.setRight(newNode);
                        break;
                    }
                }else if (newNode.getKey().compareTo(currentNode.getKey()) < 0){
                    if (currentNode.hasLeft()){
                        currentNode = currentNode.getLeft();
                    }else{
                        currentNode.setLeft(newNode);
                        break;
                    }
                }else{
                    newNode.setRight(currentNode.getRight());
                    newNode.setLeft(currentNode.getLeft());
                    currentNode = newNode;
                }
            }
        }
    }

    public V get(K key){
        if (size == 0){
            return null;
        }else{
            Node<K, V> currentNode = root;
            while (true){
                if (key.compareTo(currentNode.getKey()) > 0){
                    if (currentNode.hasRight()){
                        currentNode = currentNode.getRight();
                    }else{
                        return null;
                    }
                }else if (key.compareTo(currentNode.getKey()) < 0){
                    if (currentNode.hasLeft()) {
                        currentNode = currentNode.getLeft();
                    }else{
                        return null;
                    }
                }else{
                    return currentNode.getValue();
                }
            }
        }
    }

    public boolean hasKey(K key){
        if (size == 0){
            return false;
        }else{
            Node<K, V> currentNode = root;
            while (true){
                if (key.compareTo(currentNode.getKey()) > 0){
                    if (currentNode.hasRight()){
                        currentNode = currentNode.getRight();
                    }else{
                        return false;
                    }
                }else if (key.compareTo(currentNode.getKey()) < 0){
                    if (currentNode.hasLeft()){
                        currentNode = currentNode.getLeft();
                    }else{
                        return false;
                    }
                }else{
                    return true;
                }
            }
        }
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public class Node<K, V>{
        private K key;
        private V value;
        private Node<K, V> left = null;
        private Node<K, V> right = null;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node<K, V> getRight() {
            return right;
        }

        public boolean hasLeft(){
            return this.left != null;
        }

        public boolean hasRight(){
            return this.right != null;
        }

        public void setRight(Node<K, V> right) {
            this.right = right;
        }

        public Node<K, V> getLeft() {
            return left;
        }

        public void setLeft(Node<K, V> left) {
            this.left = left;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
