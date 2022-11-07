/*
Dominic Cummings
November 4, 2022
Software Engineering
Pet Database
*/

import java.util.Scanner;

public class PetShop {
    //Import global variables to be used throughout the program
    public static Scanner input = new Scanner(System.in);
    public static Pet[] pets = new Pet[100];
    public static int petCount = 0;
    public static String nameAge = " ";
    public static String[] myLine;
    
    public static void main(String[] args) {
        //Switch case statement to go through all the user options
        while(true){
        switch(getUserChoice()){
            case 1:
                showAllPets(); 
                break;
            case 2:
                addPets();         
                break;
            case 3: 
                updatePet();
                break;
            case 4:
                removePet();
                break;
            case 5:
                searchPetsByName();
                break;
            case 6:
                searchPetsByAge();
                break;    
            case 7: 
                //Easy way out of program
                System.out.println("Thanks for coming to Dominic's Pet Shop!");
                System.exit(0);
            }
        }   
    }
    //Method to get the users choice as to what they would like to do
    public static int getUserChoice(){
        System.out.println("What would you like to do?");
        System.out.println("1) View all pets");
        System.out.println("2) Add more pets");
        System.out.println("3) Update an existing pet");
        System.out.println("4) Remove an existing pet");
        System.out.println("5) Search pets by name");
        System.out.println("6) Search pets by age");
        System.out.println("7) Exit program");
        System.out.print("Your choice: ");
        int answer = input.nextInt();
        return answer;
    }
    //Method to add pets
    public static void addPets(){
        String name = " ";  
        int age = 0;
        //Do while loop for user entering new pets until they enter in "done"
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
    //Method to show all of the pets, calls in the header row and footer for display
    public static void showAllPets(){
        printTableHeader();
        printTableRow();
        printTableFooter();
    }
    //Method to update pet
    public static void updatePet(){
        //Show the user the current pets
        showAllPets();
        //Initialize the variables
        String oldName; 
        int oldAge;
        String newName;
        int newAge;
        System.out.print("Enter the pet ID to update: ");
        int userInput = input.nextInt();
        //Get the name and age and set the new name and age with getters and setters
        oldName = pets[userInput].getName();
        oldAge = pets[userInput].getAge();
        System.out.print("Enter the new name and age: ");
        pets[userInput].setName(input.next());
        pets[userInput].setAge(input.nextInt());
        newName = pets[userInput].getName();
        newAge = pets[userInput].getAge();
        System.out.printf("%s %s changed to %s %s%n",oldName,oldAge,newName,newAge);
    }
    //Method to remove pets
    public static void removePet(){
        //Display the pet sfor user
        showAllPets();
        String removedName;
        int removedAge;
        System.out.print("Enter the pet ID you would like to remove: ");
        int remove = input.nextInt();
        removedName = pets[remove].getName();
        removedAge = pets[remove].getAge();
        //Use for loop to get the pet ID 
        for(int i = remove; i<petCount; i++){
            pets[i] = pets[i + 1];
        }
        //Null out the location in the array where the user chose to remove pet
        pets[petCount] = null;
        petCount--; 
        System.out.printf("%s %s is removed.%n", removedName, removedAge);
        
    }
    //Method to search the pet
    public static void searchPetsByName(){      
        System.out.print("Enter a name to search for: ");
        String name = input.next();
        printTableHeader();
        System.out.println();
        //For loop to loop through the array and grab the user entered name
        for (int i = 0; i<petCount; i++){
            if (pets[i].getName().equals(name)){   
                System.out.printf("|%3d |%-10s|%4d |",i, pets[i].getName(), pets[i].getAge()); 
                System.out.println();                
            }
        }
        System.out.printf("+----------------------+ %n%d rows in set.%n",petCount);
    }
    //Search pet by age 
    public static void searchPetsByAge(){
        System.out.print("Enter an age to search for: ");
        int age = input.nextInt();
        printTableHeader();
        System.out.println();
        //For loop to search for the pets age
        for (int i = 0; i<petCount; i++){
            if (pets[i].getAge() == age){   
                System.out.printf("|%3d |%-10s |%4d |",i, pets[i].getName(), pets[i].getAge()); 
                System.out.println();                
            }
        }
        System.out.printf("+----------------------+ %n%d rows in set.%n",petCount);
    }
    //Methods for printing out the header row and footer for the display
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
//Pet class used throughout the program
class Pet{
    //Private variables
    private String name;
    private int age;
    //Constructor
    public Pet(String name, int age){
        this.name = name;
        this.age = age;
    }
    //Getters and setters
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