#include <bst.cpp>

template <class T>
class Node {
        T data;
        Node<T>* left;
        Node<T>* right;
        int height = 1;

        Node(T data) {
            this->data = data;
        }
    };

template <class T>
class AVL: public BST<T> {
private:
    Node<T>* root = null;
    int elements = 0;

Node<T>* insert(Node<T>* node, T data) {
        if (node == null) {
            elements++;
            return new Node<T>(data);
        }
        if (data ==node->data) {
            return node;
        }
        if (data < node->data) {
            node->left = insert(node->left, data);
        } else {
            node->right = insert(node->right, data);
        }

        node->height = 1 + max(height(node->left), height(node->right));

        // checkear balanceo
        int bf = balanceFactor(node);
        if(bf > 1){
            // hacia la derecha-?
            int bfRight = balanceFactor(node->right);
            if(bfRight > 0){
                // hacia derecha-derecha
                return leftRotation(node);
            } else { //bfRight < 0
                // hacia derecha-izquierda
                return rightLeftRotation(node);
            }

        } else if(bf < -1){
            // hacia la izquierda-?
            int bfLeft = balanceFactor(node->left);
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

    Node<T>* leftRotation(Node<T>* node) {
        /*
         *       z                      y
         *      / \                    / \
         *      a  y         =>       z   c
         *        / \                / \
         *       b   c              a   b 
         */
        Node<T>* z = node;
        Node<T>* y = node->right;
        
        z->right = y->left;
        y->left = z;

        z->height = 1 + max(height(z->left), height(z->right));
        y->height = 1 + max(height(y->left), height(y->right));

        return y;
    }

    int balanceFactor(Node<T>* node) {
        return height(node->left) - height(node->right);
    }

    int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    int height(Node<T>* node) {
        if (node == nullptr) {
            return 0;
        } else {
            return node->height;
        }
    }


    
    void insert(T data) override{
        root = insert(root, data);
    }

    
    void remove(T data) override{
        
    }
    boolean contains(T data) override{
        
    }
    int height() override{
        
    }
    int size() override{
        
    }

}
