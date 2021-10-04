/** 
 * Assignment 1
 * Question: N/A
 * Written by: Jaeden Rotondo 40160803
 * -----------------------------------------------------
 * GENERAL EXPLANATION OF THE PROGRAM
 * This program was designed for a marketing company in order to keep track of their consumer base
 * The program, which runs solely on the command line, allows users to do the following: 
 * Add consumers, alter the data found within each consumer, find consumers based on their age, gender and education status
 * The program is secured via password protected options at the menu
 * @author Jaeden Rotondo
 * 
 */
 

import java.util.Arrays;
import java.util.Scanner;


public class Driver {
    static final String password = "password"; // Constant password

    // Every time this method is called, the menu will print and the last number
    // entered by the user will be returned as "num"
    private static int consumerCount = 0; // The number of users already inputted into the system

    public static int getConsumerCount() {
        return consumerCount;
    }

    public static void setConsumerCount(int consumerCount) {
        Driver.consumerCount = consumerCount;
    }

    public static int menuMethod() { // Menu
        int num = 0;
        Scanner scanMenu = new Scanner(System.in);
        while (num != 1 && num != 2 && num != 3 && num != 4 && num != 5) {
            System.out.print(
                    "What do you want to do?\n\t1. Enter a new Consumer (password required) \n\t2. Change information of a Consumer (password required) \n\t3. Display all Consumers similar to a given consumer \n\t4. Display all Consumers with given age and location \n\t5. Quit \nPlease enter your choice > ");
            num = scanMenu.nextInt();
        }
        return num;
    }

    public static void welcomeMethod() { // Welcome Message
        System.out.println("*********************************************");
        System.out.println("              Consumer Database              ");
        System.out.println("*********************************************");
        System.out.println("");
    }

    public static boolean loginMethod(Object pass) { // Login Method
        final String password = "password";
        if (pass.equals(password)) {
            return true;
        } else
            return false;
    }

    public static void optionOne(int conNum, Consumer[] consumerDatabase) { // Option 1 from Menu (Enter new consumers)
        String pass = "";
        Scanner scanOne = new Scanner(System.in);
        for (int i = 0; i < 3; i++) { // 3 attempts to enter password
            System.out.println("Enter Password");
            pass = scanOne.next();
            if (loginMethod(pass)) {
                break;
            }
        }
        label1: // go-to if the user enters the correct password
        if (!pass.equals(password)) {
            for (int i = 0; i < 4; i++) {
                menuMethod();
                for (int j = 0; j < 3; j++) {
                    System.out.println("Enter Password");
                    pass = scanOne.next();
                    if (loginMethod(pass)) {
                        break label1;
                    }
                }

            }
            if (!pass.equals(password)) { // Program termination due to incorrect passwords
                System.out.println("“Program has detected suspicious activity and will terminate immediately!");
                System.exit(0);
            }
        }
        System.out.print("How many users would you like to add? ");
        conNum = scanOne.nextInt();
        while (conNum + getConsumerCount() > consumerDatabase.length) { // Check to see if the number of users ented can
                                                                        // be added
            System.out.print("The following number of consumers cannot be added. Try again : ");
            conNum = scanOne.nextInt();
        }

        for (int i = 0; i < conNum; i++) { // Loop to enter consumers into the Consumer array
            System.out.println("Please enter the information of the consumer in the following order...");
            System.out.println(
                    "FirstName_LastName,Street Number,Street_Name,City,Postal Code,Age (in years),Gender,Education,Marital_Status");
            String ConsumerInput = scanOne.next();
            String[] ConsumerInputArray = ConsumerInput.split(",", 9);
            System.out.println(Arrays.toString(ConsumerInputArray));
            consumerDatabase[i] = new Consumer(ConsumerInputArray[0], Integer.valueOf(ConsumerInputArray[1]),
                    ConsumerInputArray[2], ConsumerInputArray[3], ConsumerInputArray[4],
                    Integer.valueOf(ConsumerInputArray[5]), ConsumerInputArray[6], ConsumerInputArray[7],
                    ConsumerInputArray[8]);
            setConsumerCount(getConsumerCount() + 1); // increment the number of consumers inputed
        }
    }

    public static void alterConsumer(int consumerNum, Consumer[] consumerDatabase) { // Option 2
        System.out.println("What information would you like to change?");
        System.out.println(
                "\t1. Consumer name\n\t2. Location\n\t3. Age\n\t4. Gender\n\t5. Marital Status\n\t6. Quit\nPlease enter your choice >");
        Scanner choice = new Scanner(System.in);
        int choiceValue = choice.nextInt();
        if (choiceValue < 1 || choiceValue > 7) { // Check to see if user entered a allowable int
            alterConsumer(consumerNum, consumerDatabase); // restart the method
        }
        switch (choiceValue) { // switch case depending on the menu option
            case 1: // set name
                System.out.println("Set new Name: ");
                consumerDatabase[consumerNum].setName(choice.next());
                System.out.println(consumerDatabase[consumerNum].toString());
                alterConsumer(consumerNum, consumerDatabase);
                break;
            case 2: // set adress
                System.out.print("Set new Street Name: ");
                consumerDatabase[consumerNum].setStreetName(choice.next());
                System.out.print("Set new Street Number: ");
                consumerDatabase[consumerNum].setStreetNumber(choice.nextInt());
                System.out.print("Set new Postal Code: ");
                consumerDatabase[consumerNum].setPostalCode(choice.next());
                System.out.println(consumerDatabase[consumerNum].toString());
                alterConsumer(consumerNum, consumerDatabase);
                break;
            case 3: // set age
                System.out.print("Set new Age: ");
                consumerDatabase[consumerNum].setAge(choice.nextInt());
                System.out.println(consumerDatabase[consumerNum].toString());
                alterConsumer(consumerNum, consumerDatabase);
                break;
            case 4: // set gender
                System.out.print("Set new Gender: ");
                consumerDatabase[consumerNum].setGender(choice.next());
                System.out.println(consumerDatabase[consumerNum].toString());
                alterConsumer(consumerNum, consumerDatabase);
                break;
            case 5: // set marital status
                System.out.print("Set new Marital Status: ");
                consumerDatabase[consumerNum].setMaritalStatus(choice.next());
                System.out.println(consumerDatabase[consumerNum].toString());
                alterConsumer(consumerNum, consumerDatabase);
                break;
            case 6:
                break;
        }

    }

    public static void findConsumersBy(int age, String gender, String education, Consumer[] consumerDatabase) { // Option
                                                                                                                // 3
        for (int i = 0; i < getConsumerCount(); i++) {
            Consumer lookalike = new Consumer("null", 00, "null", "null", "null", age, gender, education, "null"); // create
                                                                                                                   // arbitrary
                                                                                                                   // user
                                                                                                                   // to
                                                                                                                   // check
                                                                                                                   // data
                                                                                                                   // with
                                                                                                                   // equals
                                                                                                                   // method
            if (consumerDatabase[i].equals(lookalike) && consumerDatabase[i].getEducation().equals(education)) {
                System.out.println(consumerDatabase[i]); // print all corresponding users
            } else {
                System.out.println("There are no consumers with the same age, gender, and education");
            }
        }
    }

    public static void findConsumerByAgeGender(int age, String gender, Consumer[] consumerDatabase) { // Option 4
        for (int i = 0; i < getConsumerCount(); i++) {
            Consumer lookalike2 = new Consumer("null", 00, "null", "null", "null", age, gender, "null", "null"); // //
                                                                                                                 // create
                                                                                                                 // arbitrary
                                                                                                                 // user
                                                                                                                 // to
                                                                                                                 // check
                                                                                                                 // data
                                                                                                                 // with
                                                                                                                 // equals
                                                                                                                 // method
            if (consumerDatabase[i].equals(lookalike2)) {
                System.out.println(consumerDatabase[i]); // print all corresponding users
            } else {
                System.out.println("There are no consumers with the same age and gender");
            }
        }
    }

    public static void main(String[] args) {
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
        int numOfConsumers = 0;

        // If option 1 is chosen:
        String pass = "";

        do {
            switch (menuMethod()) { // infinite loop of menu options (exit with option 5)
                case 1:
                    optionOne(conNum, consumerDatabase);
                    break;
                case 2:
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Enter Password");
                        pass = scan.next();
                        if (loginMethod(pass)) {
                            break;
                        }
                    }
                    if (!pass.equals(password)) {
                        System.out.println("Program has detected suspicious activity and will terminate immediately!");
                        System.exit(0);
                    } else {
                        System.out.println("Enter the Consumer # that you wish to alter");
                        int consumerNum = scan.nextInt();
                        if (consumerNum < 0 || consumerNum > getConsumerCount()) {
                            System.out.println("Consumer # entered does not exist, would you like to try again (Y/N)");
                            if (scan.next().equals("N")) {
                                menuMethod();
                            }
                        }
                        alterConsumer(consumerNum, consumerDatabase);
                    }
                    break;

                case 3:
                    System.out.println(
                            "To find all consumers with the same age, gender and education, enter the information as <age [ENTER] gender [ENTER] education [ENTER]> without the carrots");
                    findConsumersBy(scan.nextInt(), scan.next(), scan.next(), consumerDatabase);
                    break;
                case 4:
                    System.out.println(
                            "To find all consumers with the same age and gender enter the information as <age [ENTER] gender [ENTER]> without the carrots");
                    findConsumerByAgeGender(scan.nextInt(), scan.next(), consumerDatabase);
                    break;
                case 5:
                    System.out.println("Thank you for using Consumer Database");
                    System.out.println("The program will now exit...");
                    System.exit(1);
                    break;
                default:
            }
        } while (true);

    }
}
