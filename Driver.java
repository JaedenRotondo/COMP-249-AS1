// -----------------------------------------------------
 // Assignment 1
 // Question: N/A
 // Written by: Jaeden Rotondo 40160803
 // -----------------------------------------------------
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class Driver {
    static final String password = "password";
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

    public static void optionOne(int conNum, Consumer[] consumerDatabase){
        String pass = "";
        Scanner scanOne = new Scanner(System.in);
        for(int i=0; i<3; i++){
            System.out.println("Enter Password");
        pass = scanOne.next();
            if(loginMethod(pass)){
                System.out.println("Correct password");
                break;
            }
        }
        label1: 
        if(!pass.equals(password)){
            for(int i=0; i<4; i++){
                menuMethod();
                for(int j=0; j<3; j++){
                    System.out.println("Enter Password");
                pass = scanOne.next();
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
        conNum = scanOne.nextInt();
        while(conNum > consumerDatabase.length){
            System.out.print("The following number of consumers cannot be added. Try again : ");
            conNum = scanOne.nextInt(); 
        }
        
        for(int i = 0; i< conNum; i++){
            System.out.println("Please enter the information of the consumer in the following order...");
            System.out.println("Name, Street Number, Street Name, City, Postal Code, Age (in years), Gender (Male = 1) (Female = 2) (Other =3)");
            String ConsumerInput = scanOne.next();
            String[] ConsumerInputArray = ConsumerInput.split(",");
            consumerDatabase[i] = new Consumer(ConsumerInputArray[0], Integer.valueOf(ConsumerInputArray[1]), ConsumerInputArray[2], ConsumerInputArray[3], ConsumerInputArray[4], Integer.valueOf(ConsumerInputArray[5]), ConsumerInputArray[6]);                                            
            
        }
        
    }
    
    
    public static void main(String[] args){
    

        // Display a Welcome message: 
        welcomeMethod();
        
        // Create an array of "num" sized consumers
        System.out.print("Please enter the number of consumers and press enter: ");
        Scanner scan = new Scanner(System.in);
        int conNum = scan.nextInt();
        Consumer[] consumerDatabase = new Consumer[conNum];

        // Prompt User on Actions 
        System.out.println("\n\n");
        int num;

        // If option 1 is chosen: 
        String pass =""; 
        
        do{
            switch(menuMethod()){
                case 1: 
                    optionOne(conNum, consumerDatabase);
                    break; 
                case 2:
                    for(int i =0; i<3; i++){
                        System.out.println("Enter Password");
                        pass = scan.next();
                            if(loginMethod(pass)){
                                System.out.println("correct password");
                                break;
                            }
                    }
                    if(!pass.equals(password)){
                        System.out.println("“Program has detected suspicious activity and will terminate immediately!");
                        System.exit(0); 
                    }else{
                        System.out.println("Enter the Consumer # that you wish to alter");
                        int consumerNum= scan.nextInt();
                        if(consumerNum < 0 || consumerNum > consumerDatabase.length){
                            System.out.println("Consumer # entered does not exist, would you like to try again (Y/N)");
                            if(scan.next().equals("N")){
                                menuMethod(); 
                            }else{
                                System.out.println("exit");
                            }
                        }
                    }
                    break;
                
                case 3: 
                case 4: 
                case 5:
                    System.out.println("Thank you for using Consumer Database");
                    System.out.println("The program will now exit...");
                    System.exit(1);
                    break; 
                default:
            }
        }while(true);
            
        
    }
}
