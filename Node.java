/**
 * This class is made up of Node objects. Each node references 2 chidren and contain the string entered by the user and the frequency of that string
 * 
 * @Xuan Duong
 *  */
public class Node {
   private Node left, right;
   public String name;
   private int number, FRQ;//numbers represent word and FRQ: frenquency
   private int [] fre = new int [16]; //temporary frequency for f (main frequency in Node)

   //Constructor
   public Node (String n) {
      //set left, right child = null
      left = right = null;
      name = n;
      //Swap words for numbers for easier readibility
            switch (name) {
         case "Amok": number = 0; break;
         case "Nirvana": number = 1; break;
         case "Levin": number = 2; break;
         case "Minotaur": number = 3; break;
         case "Naif": number = 4; break;
         case "Brevet": number = 5; break;
         case "Dehort": number = 6; break;
         case "Costive": number = 7; break;
         case "Boffin": number = 8; break;
         case "Hoyle": number = 9; break;
         case "Scion": number = 10; break;
         case "Pissoir": number = 11; break;
         case "Looby": number = 12; break;
         case "Kvell": number = 13; break;
         case "Redact": number = 14; break;
         case "Pi": number = 15; break;
      }
      FRQ = 0; //set initial frequency = 0;
   }
   

   //add() method
   public void add (Node n) {
      if (n.getName().compareToIgnoreCase(name) == 0) { //if word were added before
         setFrequency(n.getNum()); //set (increase) the temporary frequency
         setMainFrequency(n.getNum()); //set main frequency
         System.out.println("Name '" +n.getName()+ "' was added before. Frequency: " +FRQ);
      }else if (n.getName().compareToIgnoreCase(name) < 0) {   //adding new word to left
         if (left == null) { //check if left child is available
            left = n;   //adding to theleft
            left.setFrequency(n.getNum());   //set temporary frequency
            left.setMainFrequency(n.getNum()); //set main frequency
            System.out.println("Frequency: 1");
         }else {
            left.add(n);   //Recursive call, set new subroot to left child
         }
      }else { //adding new word to right
         if (right == null) { //check if right child is available
            right = n; //adding to right
            right.setFrequency(n.getNum()); //set temporary frequency
            right.setMainFrequency(n.getNum()); //set main frequency
            System.out.println("Frequency: 1");
         }else {
            right.add(n); //Recursive call, set new subroot to right child
         }
      }
   }

   
   public void find (Node n) {
      if (n.getName().compareToIgnoreCase(name) == 0) { //if word found
          System.out.println("Word '" +n.getName()+ "' is found.\nFrequency: " +FRQ);
      }

	  else if (n.getName().compareToIgnoreCase(name) < 0) {   //check if the finding word in left or right
         if (left != null) //check if there is left child
            left.find(n); //Recursive call
         else //if there is not a left child then output
            System.out.println("Word '" +n.getName()+ "' is not found!");
      }
      else {
         if (right != null) //check if there is a right child
            right.find(n); //Recursive call
         else //if there is no right child then output
            System.out.println("Word '" +n.getName()+ "' is not found!");
      }
   }
   
	//set temporary frenquency
   public void setFrequency(int n) {
      fre[n]++;   
   }

   //get temporary frenquency
   public int getFrequency(int n) {
      return fre[n]; 
   }

   //set main frequency
   public void setMainFrequency(int n) {
      FRQ = fre[n]; 
   }

   //get main frequency
   public int getMainFrequency() {
      return FRQ; 
   }

   //get the number represents the word
   public int getNum() {
      return number; 
   }

   //get the name
   public String getName() {
      return name;   
   }

   //get left child
   public Node getLeft() {
      return left;   
   }

   //get Right child
   public Node getRight() {
      return right; 
   }

      public void result(Node n) {
      //print out the result
      System.out.println ("Name : " +n.getName()+ ". Frequency: "+n.getMainFrequency());
   }
}