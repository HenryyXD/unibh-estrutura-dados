package Btree;

//Implemente o álgoritmo para manipúlação de uma árvore binária.
//Crie a estrutura básica do nó de uma árvore binária;
//Crie a estrutura para a Raiz da árvore;
//Construir o algoritmo que permite realizar a inserção de novos nós.
//Construir o algoritmo que permite remover os nós.
//Criar o algoritmo para imprimir a o árvore em órdem.
public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree btree = new BinaryTree();
        btree.insert(43);
        btree.insert(89);
        btree.insert(82);
        btree.insert(90);
        btree.insert(100);
        btree.insert(79);
        btree.insert(66);
        btree.insert(77);
        btree.insert(11);
        btree.insert(32);
        btree.insert(61);
        btree.insert(43);
        btree.insert(16);
        btree.insert(51);
        btree.insert(55);

        btree.printOrdered();

        System.out.print("\n");
        btree.remove(43);
        btree.remove(100);

        btree.printOrdered();
    }
}


class BinaryTree {
    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            insert(root, value);
        }
    }

    public void remove(int value) {
        if (root == null)
            return;

        root = remove(root, value);
    }

    public void printOrdered() {
        printOrdered(root);
    }

    private void printOrdered(Node current) {
        if(current.left != null)
            printOrdered(current.left);

        System.out.print(current.value + ", ");

        if (current.right != null)
            printOrdered(current.right);
    }

    private void insert(Node current, int value) {
        if (value == current.value)
            return;

        if (value < current.value) {
            if (current.left == null) {
                current.left = new Node(value);
            } else {
                insert(current.left, value);
            }
        } else {
            if (current.right == null) {
                current.right = new Node(value);
            } else {
                insert(current.right, value);
            }
        }
    }

    private Node remove(Node current, int value) {
       if (current == null)
           return null;

       if (value < current.value)
           current.left = remove(current.left, value);
       else if (value > current.value)
           current.right = remove(current.right, value);
       else {
           if (current.left == null) return current.right;
           if (current.right == null) return current.left;
           current.value = minValue(current.right);
           current.right = remove(current.right, current.value);
       }

       return current;
    }

    private int minValue(Node current) {
        return current.left == null ? current.value : minValue(current.left);
    }
}