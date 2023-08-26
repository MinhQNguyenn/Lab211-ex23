import java.util.ArrayList;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
       int choice;
       //Used to contain list of total fruits in the stock
       ArrayList <Fruit> fruit = new ArrayList<>();
       //Create 2 hashtable: 1- to store the list of fruits, 2- to store the customer's order
       Hashtable<Integer, Fruit> ht1 = new Hashtable<>();
       Hashtable<String, ArrayList> ht2 = new Hashtable<>();
       do{
           Menu.displayOptions();
           choice = MyLibs.isChoice("Please enter your choice: ");
           switch(choice){
               case 1:
                   Menu.createFruit(fruit);
                   break;
               case 2:
                   Menu.viewOrder(ht2);
                   break;
               case 3:
                   Menu.shopping(fruit, ht1, ht2);
                   break;
           }
       }while(choice != 4);
}
}
