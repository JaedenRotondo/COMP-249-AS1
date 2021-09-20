public class Driver {
    public static void main(String[] args){
        Consumer consumer1 = new Consumer(152, "Upper Canada Drive", "Toronto", "M2P2A3", 19, "male", "SINGLE", "HIGHSCHOOL", "Jaeden Rotondo");
        Consumer consumer2 = new Consumer(152, "Wagwan", "Toronto", "M2P2A3", 19, "male", "SINGLE", "HIGHSCHOOL", "Jaeden Rotondo");
        System.out.println(consumer1.toString());    
        System.out.println(consumer2.equals(consumer1));
    
    }
}
