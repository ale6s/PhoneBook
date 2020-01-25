package program_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneBook 
{
    private Scanner s = new Scanner(System.in);
    private Contact contact[] = new Contact[100];
    private int count;
    private String fileName;
    
    //defaul constructor 
    public PhoneBook(String fileName)
    {
       this.fileName = fileName;
    	for (int j = 0; j < 100; j++) {
        contact[j] = new Contact();
        }
    }//end of PhoneBook
    
    
    /**
     * add a contact to the class main if array not full returning true
     *  if the array is full(100 inputs) it return it false
     */
    public boolean add(Contact c)
    {
        if(count <= 100)
        { 
            contact[count] = c;
            count++;
                return true;
        }
        else 
            System.out.println("The directory is full\n"); 
                return false;
        
    }//end of add
    
    
    /**
     *method will remove a contact if the contact was sucessfully remove it will
     * return true is not it will return false
     */
    public boolean remove(String fullName)
    {
        int index = -1;
        for(int i = 0; i < count; i++)
        {
            if (fullName.equals(contact[i].getFirstName()))
            {
                index = i;
                for(int j=index; j<count; j++)
                {
                    contact[j] = contact[j+1];
                }
                    count--;
                        return true;
            }
        }
            return false;
    }//end of remove
    
    
    /**
     *this method will search for an exiting contact using the first name of the user 
     * if the contact is not found it will be return null
     */
    public Contact search(String fullName)
    {
    	for(int i = 0; i <count; i++)
            if(fullName.equals(contact[i].getFirstName()))
            {
                System.out.println("Name\t\t       Phone Number\n" + 
                                   "-------------------------------------");
                            System.out.print(contact[i].getFirstName() + " " +
                            contact[i].getLastName() + "\t\t");
                            System.out.println(contact[i].getPhone());
                System.out.println("-------------------------------------\n");
            }
                else
                    System.out.println("Contact Not Found.\n");
    	return null;
    }//end of search    
    
     
    
    /**
     * this method will display the directory
     */
    public void display()
    {
        
            System.out.println("Name\t\t       Phone Number\n" + 
                               "-------------------------------------");
        for(int i = 0;  i < count; i++) 
        {
            System.out.print(contact[i].getFirstName() + " " + contact[i].getLastName());
            System.out.format("%21s%n", contact[i].getPhone());
        }
            System.out.println("-------------------------------------\n");
    }//display
    
    
    /**
     * this method will load the saved contact the files will be load from "contact.txt" 
     */
    public boolean load()
    {
        try {
            count = 0;
            int lineNumber = 3;
            Scanner s = new Scanner(new File(fileName));
            while(s.hasNext())
            {
                if(lineNumber % 3 == 0 )
                    this.contact[count].setFirstName(s.next());
                if(lineNumber % 3 == 1 )
                    this.contact[count].setLastName(s.next());
                if(lineNumber % 3 == 2 ) 
                {
                    this.contact[count].setPhone(s.next());
                    count++;
                }
                lineNumber++;
            }
            s.close();
            return true;
        } 
        catch (FileNotFoundException c) 
        {
            System.out.println("Unable to read file.\nGoodBye");
            System.exit(0);
        }
        return false;
    }//end of load
    
    
    /**
     * this method will save a contact and it will save it on the "contact.txt" file
     * it will return true if is save and false if it wasn't able to be saved
     */
    public boolean save()
    {
        try 
        {
            FileWriter writer = new FileWriter(new File(fileName));
            for(int i = 0; i < count; i++)
            {
                writer.write(contact[i].getFirstName());
                writer.write("\n");
                writer.write(contact[i].getLastName());
                writer.write("\n");
                writer.write(contact[i].getPhone());
                writer.write("\n\n");
            }
            writer.close();
            return true;
        } 
            catch (IOException c) 
            {
            System.out.println("Unable to save.\n");
            }
        return false;
    }//end of save
  
}//class PhoneBook
