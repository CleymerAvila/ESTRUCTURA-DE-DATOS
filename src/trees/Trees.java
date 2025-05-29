package trees;

import trees.AVL.AVLTree;
import trees.BTS.BST;
import trees.BTS.BinarySearchTree;
import trees.BTS.Employee;

import java.util.Arrays;

public class Trees {

    public static void main(String[] args) {

//        BST tree = new BST();
//
//        System.out.println("El Arból se encuentra vacio?: " + tree.isEmpty());
//
//        tree.exists(10);
//        tree.insert(4);
//        tree.insert(2);
//        tree.insert(6);
//        tree.insert(1);
//        tree.insert(3);
//        tree.insert(5);
//        tree.insert(7);
//
//        System.out.println("\nImpresión datos en InOrden");
//        tree.inOrderTraversal(tree.getRoot());
//        System.out.println("\nImpresión datos en PreOrden");
//        tree.preOrderTraversal(tree.getRoot());
//        System.out.println("\nImpresión datos en PostOrden");
//        tree.posOrderTraversal(tree.getRoot());
//
//        verifyExistence(tree, 10);
//        verifyExistence(tree, 4);
//        verifyExistence(tree, 2);
//
//        System.out.println("\nEliminar el numero 4 en el arbol");
//        tree.delete(4);
//        System.out.println("\nImpresión datos en InOrden");
//        tree.inOrderTraversal(tree.getRoot());
//        System.out.println("\nEliminar el numero 1 en el arbol");
//        tree.delete(1);
//        System.out.println("\nImpresión datos en InOrden");
//        tree.inOrderTraversal(tree.getRoot());
//        System.out.println("\nEliminar el numero 5 en el arbol");
//        tree.delete(5);
//        System.out.println("\nImpresión datos en InOrden");
//        tree.inOrderTraversal(tree.getRoot());

//        // --------------  RECURSIVE TREE WITH EMPLOYEE OBJECT  ------------------
//
//        Employee em1 = new Employee(20, "Cleymer Avila", "ENGINEER SYSTEM", "A-193");
//        Employee em2 = new Employee(32, "Yenis del Carmen", "COOK", "A-200");
//        Employee em3 = new Employee(11, "Adolfo Avila Pushaina", "ACCOUNTANT", "A-172");
//        Employee em4 = new Employee(15, "Dario Gomez Guzman", "HUMAN RESOURCE", "A-300");
//        Employee em5 = new Employee(80, "Maria Cardenas Olivas", "MARKETING", "A-188");
//        Employee em6 = new Employee(21, "Daniel Tarragona Contreras", "POLICE", "A-201");
//
//        BinarySearchTree btsRec = new BinarySearchTree();
//
//        Arrays.asList(em1, em2, em3, em4, em5, em6).forEach(btsRec::insert);
//
//
//        System.out.println("\nEn InOrden: ");
//        btsRec.inOrderTraversal();
//        System.out.println("\nEn PreOrden: ");
//        btsRec.preOrderTraversal();
//        System.out.println("\nEn PosOrden: ");
//        btsRec.posOrderTraversal();
//
//        // Elementos hojas del arbol son: 15, 21, 80
//        // btsRec.delete(80);
//        System.out.println("\nArbol en PosOrden despues de eliminar 80");
//        btsRec.posOrderTraversal();
//       // btsRec.delete(11);
//        System.out.println("\nArbol en PosOrden despues de eliminar 11");
//        btsRec.posOrderTraversal();
//       // btsRec.delete(32);
//        System.out.println("\nArbol en PosOrden despues de eliminar 32");
//        btsRec.posOrderTraversal();
//        //btsRec.delete(20);
//        System.out.println("\nArbol en PosOrden despues de eliminar 20");
//        btsRec.posOrderTraversal();
//
//        System.out.println("Es hoja el empleado 44 "+ btsRec.isLeaf(44));
//        // System.out.println("Existe el empleado "+ btsRec.get(44) + ": "+ btsRec.exists(44) );

        //

        AVLTree<String> tree = new AVLTree<>();

        tree.insert("G");
        tree.insert("B");
        tree.insert("E");
        tree.insert("F");
        tree.insert("H");
        tree.insert("I");
        tree.insert("J");
        tree.insert("C");
        tree.insert("D");
        tree.insert("A");

        tree.insert("A");


        traversalDFS(tree);

//        System.out.println("\nExiste el dato B: "+ tree.exists("X"));
//        System.out.println("El arbol esta vacio? " + tree.isEmpty());
//        System.out.println("Altura del arbol? " + tree.height());
        System.out.println("\nEliminado el valor A: ");
        tree.delete("A");
        traversalDFS(tree);
        System.out.println("\nEliminado el valor H: ");
        tree.delete("H");
        traversalDFS(tree);
    }

    private static void traversalDFS(AVLTree tree){
        System.out.println("\nDatos en InOrden: ");
        tree.inOrderTraversal();
        System.out.println("\nDatos en posOrden: ");
        tree.posOrderTraversal();
        System.out.println("\nDatos en preOrden: ");
        tree.preOrderTraversal();
    }

    public static void verifyExistence(BST tree, int data){
        System.out.println();
        if (tree.exists(data)){
            System.out.printf("\nEl dato %d se encuentra en el Arbol.", data);
        } else {
            System.out.printf("\nEl dato %d NO se encuentra en el Arbol.", data);
        }
    }

    public static void search(BinarySearchTree bts, long id){
        if (bts.exists(id)){
            System.out.println("Empleaado [" + id + "] encontrado: " + bts.get(id));
        } else {
            System.out.println("El empleado no fue encontrado: "+ id);
        }
    }
}
