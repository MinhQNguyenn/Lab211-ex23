
import java.util.ArrayList;
import java.util.Scanner;

class MyLibs {
    static int isChoice(String msg) {
        int choice;
        String temp;
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                System.out.print(msg);
                temp = sc.nextLine();
                while(temp.isEmpty()){
                    System.out.println("Choice can't be empty\n" + msg);
                    temp = sc.nextLine();
                }
                choice = Integer.parseInt(temp);
                while(!(choice >=1 && choice <= 5)){
                    System.out.print("Choice doesn't exist!\n" + msg);
                    temp = sc.nextLine();
                    choice = Integer.parseInt(temp);
                }
                return choice;
            }catch(Exception E){
                System.out.println("Invalid choice!");
            }
        }
    }

    static String isCode(String msg) {
        String temp;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print(msg);
            temp = sc.nextLine();
        }while(temp.isEmpty());
        return temp;
    }

    static boolean isCodeDuplicated(String id, ArrayList<Fruit> fruit) {
        for (int i = 0; i < fruit.size(); i++) {
            if(fruit.get(i).id.compareToIgnoreCase(id) == 0){
                return true;
            }
        }
        return false;
    }

    static String inputStr(String msg) {
        String temp;
        Scanner sc = new Scanner(System.in);  
        System.out.print(msg);
        temp = sc.nextLine();
        return temp;
    }

    static double isPrice(String msg) {
        String temp;
        Scanner sc = new Scanner(System.in);
        double number;
        while(true){
            try{
                System.out.print(msg);
                temp = sc.next();
                number = Double.parseDouble(temp);
                while(number <=0){
                    System.out.print("Invalid price!\n" + msg);
                    temp = sc.next();
                    number = Double.parseDouble(temp);
                }return number;
            }catch(Exception E){
                System.out.println("Invalid input!");
            }
        }
    }

    static int isQuantity(String msg) {
        String temp;
        Scanner sc = new Scanner(System.in);
        int number;
        while(true){
            try{
                System.out.print(msg);
                temp = sc.nextLine();
                number = Integer.parseInt(temp);
                while(number <=0){
                    System.out.print("Invalid quantity!\n" + msg);
                    temp = sc.nextLine();
                    number = Integer.parseInt(temp);
                }return number;
            }catch(Exception E){
                System.out.println("Invalid input!");
            }
        }
    }

    static boolean checkChoice(String msg) {
        String temp;
        char c;
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                System.out.print(msg);
                temp = sc.nextLine();
                while(temp.isEmpty()){
                    System.out.println("Choice can't be empty\n" + msg);
                    temp = sc.nextLine();
                }
                c = temp.charAt(0);
                while(!(c != 'y' || c != 'Y' || c !='N' || c !='n')){
                    System.out.print("Choice does't exist!\n" + msg);
                    temp = sc.nextLine();
                    c = temp.charAt(0);
                }return c == 'Y' || c=='y' ;
            }catch(Exception E){
                System.out.println("Invalid input!");
            }
        }
    }

    static int inpChoice(String msg, int size) {
        int choice;
        String temp;
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                System.out.print(msg);
                temp = sc.nextLine();
                while(temp.isEmpty()){
                    System.out.println("Choice can't be empty\n" + msg);
                    temp = sc.nextLine();
                }
                choice = Integer.parseInt(temp);
                while(!(choice >=1 && choice <= size)){
                    System.out.print("Choice doesn;t exist!\n" + msg);
                    temp = sc.nextLine();
                    choice = Integer.parseInt(temp);
                }
                return choice;
            }catch(Exception E){
                System.out.println("Invalid choice!");
            }
        }
    }

    
}
