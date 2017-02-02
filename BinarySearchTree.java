/**
 * This class serves as a container class. It has methods for inserting nodes and serching the tree.
 * 
 * @Xuan Duong 
 * 
*/
public class BinarySearchTree {
   private Node root, temp;
   
   //Constructor
   public BinarySearchTree (){
      root = null;

   }
      
     public void insert (String w) {
      temp = new Node (w);//create new Node for the string
      //check to see if the tree is empty
      if (root == null) {
         root = temp;
         root.setFrequency(temp.getNum());
         //Output first added word
         System.out.println("Frequency: 1");
      }else root.add(temp);//start recursive insert, setting the root as the initial subroot
   }
   
     
      public void search (String w) {
      temp = new Node (w);
      if (root == null) System.out.println("Word is not found!");
      else root.find(temp);
   }
   
      
      public void printPreOrder (){
      System.out.println("\nPrint Pre-Order");
      preOrder(root);
   }

   
   public void printInOrder () {
      System.out.println("\nPrint In-Order");
      inOrder(root);
   }

  
   public void printPostOrder () {
      System.out.println("\nPrint Post-Order");
      postOrder(root);
   }

      public void preOrder (Node n) {
      if (n == null) return;
      n.result(n); //print root
      preOrder(n.getLeft()); //left child
      preOrder(n.getRight()); //right child
   }

  
   public void inOrder (Node n) {
      if (n == null) return;
      preOrder(n.getLeft()); //left child
      n.result(n); //root
      preOrder(n.getRight());    //right child
   }

   
   public void postOrder(Node n) {
      if (n == null) return;
      preOrder(n.getLeft()); //left child
      preOrder(n.getRight()); //right child
      n.result(n); //root
   }
}

