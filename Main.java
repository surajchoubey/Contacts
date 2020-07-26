package Contacts

import java.util.Scanner;
import java.util.ArrayList;

public class Main{

public static void main(String[] args){    


    boolean shouldFinish = false, shouldContinue2 = false, shouldContinue3 = false;

    ArrayList<Contact> contact = new ArrayList<Contact>();

    Scanner scanner = new Scanner(System.in);                             

    while(!shouldFinish){

        System.out.println("\n==================\n    MAIN-MENU\n==================");
        System.out.println("\n\t1. Contacts"+
            "\n\t2. Messages" +
            "\n\t3. Quit\n");
        
        
    int choice = scanner.nextInt();  
        
        

        switch(choice){
            case 1:
                
                do{
                    System.out.println("========================\n    CONTACTS-SECTION\n========================");
                    System.out.println("\n\t1. Show all contacts"+
                        "\n\t2. Add a new contact"+
                        "\n\t3. Search for a contact"+
                        "\n\t4. Delete a contact"+
                        "\n\t5. Go back to the previous menu\n");
                                    
                    int choice2 = scanner.nextInt();   

                    switch(choice2){
                        case 1: 

                        for(Contact c: contact){
                                System.out.println("\n\tName: " + c.getName() +
                                                    "\tPhone Number: " + c.getNumber() +
                                                    "\tEmail: " + c.getEmail() );
                            }
                        
                        break;

                        case 2: 
                            String name, number, email;
                            scanner.nextLine();
                            System.out.print("\nEnter Name: ");
                            name = scanner.nextLine();
                            System.out.print("Enter Phone Number: ");
                            number = scanner.nextLine();
                            System.out.print("Enter Email: "); 
                            email = scanner.nextLine();
                            contact.add(new Contact(name, number, email));      
                                            
                            System.out.println();
                        break;

                        case 3: 
                            scanner.nextLine();
                            System.out.print("Enter the name you want to Search: ");
                            String searchName = scanner.nextLine();
                            for(Contact c: contact){
                                if(searchName.equalsIgnoreCase(c.getName())){
                                    System.out.println("\n\n************Contact Found************");
                                    System.out.println("\n\tName: " + c.getName() +
                                                        "\tPhone Number: " + c.getNumber() +
                                                        "\tEmail: " + c.getEmail() );
                                                        break;
                                // after searching for a specifc number break the loop after the names found and the details are displayed
                                }
                            }

                        break;

                        case 4: 
                            scanner.nextLine();
                            System.out.println("Enter the name you want to Delete");
                            String deleteName = scanner.nextLine();
                            for(Contact c: contact){
                                if(deleteName.equalsIgnoreCase(c.getName())){
                                    contact.remove(c);
                                    System.out.println("\n\n*************Contact Deleted**************");
                                    break;

                                // after deleting for a specifc number break the loop after the names found and the numbers are deleted
                                }
                            }                      

                        break;

                        case 5: shouldContinue2 = false;
                        break;  
                        
                        default: System.out.println("Please Enter Options Correctly Again");
                        shouldContinue2 = true;
                        break;
                    }

                }while(shouldContinue2==true);


            break;

            case 2: 
                    
                do{
                    System.out.println("========================\n    MESSAGES-SECTION\n========================");
                    System.out.println("\n\t1. See the list of all messages" +
                                            "\n\t2. Sends a new message"+
                                            "\n\t3. Go back to previous menu\n");

                    int choice3 = scanner.nextInt();

                    switch(choice3){
                        case 1:     
                        // all messages of all person will show up  
                        for(Contact c: contact){
                            System.out.println("\n\n" + c.getName() +"\n" + c.Messages);
                        }                 
                        break;
                        case 2: 
                        // send a message to a specific person
                        scanner.nextLine();
                        System.out.print("Enter the name of the person you wanna text: ");
                        String textName = scanner.nextLine();

                        for(Contact c: contact){
                            if(textName.equalsIgnoreCase(c.getName())){
                                System.out.print("\nEnter text here you wanna send to " + c.getName() +"\n");
                                String textMessage = scanner.nextLine();
                                c.Messages.add(textMessage);
                                break;
                            }
                        }
                        break;
                        case 3: 
                        // go back to previous menu
                        shouldContinue3 = false;
                        break;    
                                    
                        default: System.out.println("Please Enter Options Correctly Again");
                        shouldContinue3 = true;
                        break;
                    }
            
                }while(shouldContinue3==true);

            break;

            case 3:  shouldFinish = true;
            break;

            default: System.out.println("Invalid Choice! Enter Correctly..");
            break;

        }
    }


    }

}


