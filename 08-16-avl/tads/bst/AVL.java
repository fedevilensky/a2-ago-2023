package tads.bst;

public class AVL<T extends Comparable<T>> implements BST<T> {
    private class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
        int height = 1;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> root;
    private int elements;

    @Override
    public void insert(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            elements++;
            return new Node<T>(data);
        }
        if (data.compareTo(node.data) == 0) {
            return node;
        }
        if (data.compareTo(node.data) < 0) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }

        node.height = 1 + max(height(node.left), height(node.right));

        // checkear balanceo
        int bf = balanceFactor(node);
        if(bf > 1){
            // hacia la derecha-?
            int bfRight = balanceFactor(node.right);
            if(bfRight > 0){
                // hacia derecha-derecha
                return leftRotation(node);
            } else { //bfRight < 0
                // hacia derecha-izquierda
                return rightLeftRotation(node);
            }

        } else if(bf < -1){
            // hacia la izquierda-?
            int bfLeft = balanceFactor(node.left);
            if(bfLeft < 0){
                //hacia izquierda-izquierda
                return rightRotation(node);
            } else { // bfLeft > 0
                // hacia izquierda-derecha
                return leftRightRotation(node);
            }
        } else {
            return node;
        }

    }

    private Node<T> leftRotation(Node<T> node) {
        /*
         *       z                      y
         *      / \                    / \
         *      a  y         =>       z   c
         *        / \                / \
         *       b   c              a   b 
         */
        Node<T> z = node;
        Node<T> y = node.right;
        
        z.right = y.left;
        y.left = z;

        z.height = 1 + max(height(z.left), height(z.right));
        y.height = 1 + max(height(y.left), height(y.right));

        return y;
    }

    private int balanceFactor(Node<T> node) {
        return height(node.left) - height(node.right);
    }

    private int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    private int height(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return node.height;
        }
    }

    @Override
    public void remove(T data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public boolean contains(T data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public int height() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'height'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

}
