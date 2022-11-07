/*
Dominic Cummings
November 4, 2022
Software Engineering
Pet Database
*/

import java.util.Scanner;

public class PetShop {
    public static Scanner input = new Scanner(System.in);
    public static Pet[] pets = new Pet[100];
    public static int petCount = 0;
    public static String nameAge = " ";
    public static String[] myLine;
    
    public static void main(String[] args) {
        
        while(true){
        switch(getUserChoice()){
            case 1:
                showAllPets(); 
                break;
            case 2:
                addPets();         
                break;
            case 3: 
                System.out.println("Thanks for coming to Dominic's Pet Shop!");
                System.exit(0);
            }
        }   
    }
    
      public static int getUserChoice(){
        System.out.println("What would you like to do?");
        System.out.println("1) View all pets");
        System.out.println("2) Add more pets");
        System.out.println("3) Exit program");
        System.out.print("Your choice: ");
        int answer = input.nextInt();
        return answer;
    }
    public static void addPets(){
        String name = " ";  
        int age = 0;
        
        do{    
            System.out.print("add pet(name age): ");
            name = input.next();
            
            if (name.equals("done")){
                System.out.println(petCount + " pets added.");
                break; 
            }
            age = input.nextInt();
            String newAge = String.valueOf(age);
            
            nameAge = name + " " +  newAge;
      
            Pet petInput = new Pet(name, age);
            pets[petCount] = petInput;
            petCount++;           
        }while(!name.equalsIgnoreCase("done"));
    }
    
    public static void showAllPets(){
        printTableHeader();
        printTableRow();
        printTableFooter();
    }
        
    public static void printTableHeader(){
        System.out.printf("+----------------------+ %n| ID | NAME      | AGE | %n+----------------------+");
    }
     
    public static void printTableRow(){
        System.out.println();
        for(int j = 0; j<petCount; j++){
            System.out.printf("|%3d |%-10s |%4d |",j, pets[j].getName(), pets[j].getAge());
            System.out.println();
        }
    }
    
    public static void printTableFooter(){
        System.out.printf("+----------------------+ %n%d rows in set.%n",petCount);
    }    
        
}

class Pet{
    
    private String name;
    private int age;
    
    public Pet(String name, int age){
        this.name = name;
        this.age = age;
    }
   
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
     
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
        
    }
    
}