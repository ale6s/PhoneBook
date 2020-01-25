package program_2;

import java.util.Scanner;
/**
 * @author Alexis Sanchez
 * This is a simple PhoneBook
 * The program will allow us to add, remove, view, update a contact
 */
public class Main
{
    private static Scanner s = new Scanner(System.in);
    private static String first = "";
    private static String last = "";
    private static String number = "";
        
    
    //this method will display the menu and it will ask the user for a choice    
    private static int menu()
    {
        System.out.println("What would you like to do?\n"+
                            "1) Display all contacts\n"+
                            "2) Add a contact\n"+
                            "3) Remove a contact\n"+
                            "4) Search a contact\n"+
                            "5) Update a contact\n"+
                            "6) Exit");
        System.out.print("Your choice: ");
        return s.nextInt();
    }//end of menu
        

    //this method will take the user info such as firs,last || phone# and then it will return it
    private static Contact userInfo() 
    {
            System.out.print("First Name: ");
            first = s.next();
            System.out.print("Last Name: ");
            last = s.next();
            System.out.print("Phone Number: ");
            number = s.next();
            System.out.println("contact added.\n");
            Contact contact = new Contact(first, last, number);
            return contact;
    }//end of userInfo
    
    
    //this method will ask the user for first name to remove a contact
    private static String userFullNametoRemove() 
    {
        System.out.print("Enter FirstName to Remove: ");
        return s.next();
    }//end of userFullNametoRemove()
        
    
    //this methid will ask user for first name to search a contact    
    private static String userFullNametoSearch() 
    {
        System.out.print("Enter FirstName to Search: ");
        return s.next();
    }//end of userFullNametoSearch()
    
    
    //this method will ask user for first name to find a contact and then update it
    private static String userFullNametoUpdate() 
    {
        System.out.print("Enter First Name of Contact: ");
        return s.next();
    }//end of userFullNametoUpdate()
    
    
    //this method will ask for the user info such as newFirst & newLast to update
    private static Contact updateContact() 
    {
            System.out.print("New First Name: ");
            first = s.next();
            System.out.print("New Last Name: ");
            last = s.next();
            System.out.println("Contact Successfully saved.");
            Contact contact = new Contact(first, last, number);
            return contact;
    }//end of userFullNametoSearch()
    
    
    
    public static void main(String[] args) 
    {
        PhoneBook phoneBook = new PhoneBook("contact.txt");
        if(phoneBook.load())
        {
            System.out.println("Welcome. AdressBook is loaded.\n");
        }
        
        /**
        * case 1 will display the menu
        * case 2 will add a new contact
        * case 3 will remove an existing contact
        * case 4 will search for an existing contact
        * case 5 will look for a contact and then it will remove it to update it with a new info
        * case 6 will exit the program saving all the new changes
        */   
        while(true)
        {        
            
            loop:switch(menu()) 
            {
                case 1: 
                    phoneBook.display();
                    break;        
                case 2:
                    phoneBook.add(userInfo());
                    break;
                case 3:
                   if(phoneBook.remove(userFullNametoRemove()))
                    {
                        phoneBook.display();
                    } 
                        else 
                        {
                            System.out.println("Unable to Remove. Contact Not found.");
                        }
                    break;
                case 4:
                    phoneBook.search(userFullNametoSearch());
                    break;
                case 5:
                    if(phoneBook.remove(userFullNametoUpdate()))
                    {
                        phoneBook.add(updateContact());
                    }
                        else
                            System.out.println("Not Found");
                        break;
                case 6:
                    if (phoneBook.save()){
                        System.out.println("GoodBye.");
                        System.exit(0);
                    }
                    break loop;
                default: 
                    System.out.print("Please choose a valid menu number!\n\n");

            }//end switch
        }//end of while loop 
       
    }//main()
}//class Main