import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

class Menu {

    //Display the options for users to choose from
    static void displayOptions() {
        System.out.println("FRUIT SHOP SYSTEM"
                        + "\n1. Create Fruit"
                        + "\n2. View Orders"
                        + "\n3. Shopping (for buyer)"
                        + "\n4. Exit");
    }

    //creat fruit to insert to put in the stock
    static void createFruit(ArrayList<Fruit> fruit) {
        String id, name, origin;
        double price;
        int quantity;
        boolean choice;
        do {
            //Check code duplication
            do {
                id = MyLibs.isCode("Please enter the fruit id: ");
            } while(MyLibs.isCodeDuplicated(id, fruit));
            name = MyLibs.inputStr("Please enter the name of the fruit: ");
            price = MyLibs.isPrice("Please enter the price of the fruit: ");
            quantity = MyLibs.isQuantity("Please enter the quantity of the fruit: ");
            origin = MyLibs.inputStr("Please enter the origin of the fruit: ");
            fruit.add(new Fruit(id, name, origin, price, quantity));
            choice = MyLibs.checkChoice("Do you want to continue(Y/N): ");
        } while (choice);
        displayFruit(fruit);
    }

    //View the order of the customers
    static void viewOrder(Hashtable<String, ArrayList> ht2) {
        String temp;
        for (Map.Entry m:ht2.entrySet()) {
            System.out.println("Customer: " + m.getKey());
            displayOrder(ht2.get(m.getKey()));
        }
    }

    //Display a shopping list for customer to order from and store the information
    static void shopping(ArrayList<Fruit> fruit, Hashtable<Integer, Fruit> ht1, Hashtable<String, ArrayList> ht2) {
        int choice, quantity;
        boolean order;
        String name;
        //Used to temporarily store the list of fruits ordered by the user
        ArrayList <Fruit> temporary = new ArrayList<>();
        //Input the value from the fruit to the hashtable along with its number
        for (int i = 0; i < fruit.size(); i++) {
                ht1.put((i + 1), fruit.get(i));
            }
        //Display the fruit list and create order for user
        do{
            displayShoppingList(fruit);
            choice = MyLibs.inpChoice("Please choose: ", ht1.size());
            do {
                quantity = MyLibs.isQuantity("Please input quantity: ");
                if (ht1.get(choice).quantity < quantity) 
                    System.out.println("Insufficient amount of fruits.");
            } while (ht1.get(choice).quantity < quantity);
            //Reduce the quantity of fruits based on the amount taken
            adjustQuantity(quantity, choice, ht1, fruit); 
            //Add the fruit to the list of customer's order
            temporary.add(new Fruit(ht1.get(choice).name, ht1.get(choice).price, quantity));
            order = MyLibs.checkChoice("Do you want to order now (Y/N): ");
        }while(!order);
        displayOrder(temporary);
        name = MyLibs.inputStr("Input your name: ");
        ht2.put(name, temporary);
    }
    
    //Adjust the quantity of fruits in the stock after an order has been placed
    private static void adjustQuantity(int quantity, int choice, Hashtable <Integer, Fruit> ht, ArrayList <Fruit> fruit){
        int temp;
        //Change the amount of fruit left within the list
        temp = ht.get(choice).getQuantity();
        ht.get(choice).setQuantity(temp - quantity);
        for (int i = 0; i < fruit.size(); i++) {
            if(fruit.get(i).name.compareToIgnoreCase(ht.get(choice).name) == 0){
                fruit.get(i).setQuantity(temp - quantity);
                break;
            }
        }
    }
    
    
    //Display the total number of fruits in the stock (F1, F3)
    private static void displayFruit(ArrayList<Fruit> fruit){
        System.out.println("ID\tName\tPrice\tQuantity\tOrigin");
        for (int i = 0; i < fruit.size(); i++) {
            System.out.println(fruit.get(i).id +"\t" + fruit.get(i).name + "\t" +fruit.get(i).price 
                                + "\t   " + fruit.get(i).quantity + "\t\t" + fruit.get(i).origin);
        }
    }
    
    //Display option of fruit for user to order from (F3)
    private static void displayShoppingList(ArrayList <Fruit> fruit){
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |  ");
        for (int i = 0; i < fruit.size(); i++) {
            System.out.printf("%6d%20s%18s%12.2f\n",(i+1), fruit.get(i).name, fruit.get(i).getOrigin(), fruit.get(i).getPrice());
        }
    }
    
    //Display the user's order through arraylist
    private static void displayOrder(ArrayList <Fruit> fruit){
        double total = 0;
        System.out.println("Product | Quantity | Price | Amount");
        for (int i = 0; i < fruit.size(); i++) {
            System.out.printf("%d. %2s%5d%11.1f%c%12.1f%c\n", (i+1), fruit.get(i).getName(), fruit.get(i).getQuantity(), fruit.get(i).getPrice(), '$',
                                (fruit.get(i).getQuantity() * fruit.get(i).getPrice()), '$');
            total += fruit.get(i).getQuantity() * fruit.get(i).getPrice();
        }
        System.out.println("Total: " + total + "$");
    }
}
