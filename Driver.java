// -----------------------------------------------------
 // Assignment 1
 // Question: N/A
 // Written by: Jaeden Rotondo 40160803
 // -----------------------------------------------------
import java.util.Scanner;

public class Driver {
    
    // Every time this method is called, the menu will print and the last number entered by the user will be returned as "num"
    public static int menuMethod(){
        int num;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("What do you want to do?\n\t1. Enter a new Consumer (password required) \n\t2. Change information of a Consumer (password required) \n\t3. Display all Consumers similar to a given consumer \n\t4. Display all Consumers with given age and location \n\t5. Quit \nPlease enter your choice > ");
            
            num = scan.nextInt();
            
        }while(num != 1 && num !=2&& num !=3&& num !=4 && num !=5);
        return num;
    }

    public static void welcomeMethod(){
        System.out.println("*********************************************");
		System.out.println("              Consumer Database              ");
		System.out.println("*********************************************");
        System.out.println("");
    }

    public static boolean loginMethod(Object pass){
        final String password = "password";
            if(pass.equals(password)){
                return true;
            }else return false;
    }

    public static void main(String[] args){
        final String password = "password";
        Consumer consumer1 = new Consumer(152, "Upper Canada Drive", "Toronto", "M2P2A3", 19, "male", "SINGLE");
        Consumer consumer2 = new Consumer(152, "Wagwan", "Toronto", "M2P2A3", 19, "male", "SINGLE");
        System.out.println(consumer1.toString()); 
        System.out.println(consumer2.toString());     
        System.out.println(consumer2.equals(consumer1));
    

        // Display a Welcome message: 
        welcomeMethod();
        
        // Create an array of "num" sized consumers
        System.out.print("Please enter the number of consumers and press enter: ");
        Scanner scan = new Scanner(System.in);
        int conNum = scan.nextInt();
        Consumer[] consumerDatabase = new Consumer[conNum];

        // Prompt User on Actions 
        System.out.println("\n\n");
        int num = menuMethod();

        // If option 1 is chosen: 
        String pass =""; 
        if(num == 1){
            for(int i=0; i<3; i++){
                System.out.println("Enter Password");
            pass = scan.next();
                if(loginMethod(pass)){
                    System.out.println("correct password");
                    break;
                }
            }
            label1: 
            if(!pass.equals(password)){
                for(int i=0; i<4; i++){
                    menuMethod();
                    for(int j=0; j<3; j++){
                        System.out.println("Enter Password");
                    pass = scan.next();
                        if(loginMethod(pass)){
                            System.out.println("correct password");
                            break label1;
                        }
                    }
                   
                }
                if(!pass.equals(password)){
                    System.out.println("“Program has detected suspicious activity and will terminate immediately!");
                    System.exit(0); 
                }
            }
            System.out.print("How many users would you like to add? ");
            conNum = scan.nextInt(); 
            if(conNum <= consumerDatabase.length){
                System.out.println("Please enter the information of the consumer in the following order...");
            }
            while(conNum > consumerDatabase.length){
                System.out.print("The following number of consumers cannot be added. Try again : ");
                conNum = scan.nextInt(); 
            }
            
        }
            System.out.println("option 1 exited succesful");
        // If option 2 is chosen: 
        if(num == 2){

        }

        // If option 3 is chosen:
        if(num == 3){

        }
        // If option 4 is chosen:
        if(num == 4){
            
        }
        
        // If option 3 is chosen:
        if(num == 5){
            
        }
    }
}
