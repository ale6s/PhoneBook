package program_2;

public class Contact 
{
    private String firstName;
    private String lastName;
    private String phone;
    
    
    //defaul contructor
    public Contact() 
    {
        this.firstName = "";
        this.lastName = "";
        this.phone = "";
    }//enf of Contact
        
    //parametric contructor
    public Contact(String firstName, String lastName, String phone)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }//end of Constructor Contact

    
    public String getFirstName() 
    {
        return firstName;
    }//end of getFirst


    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }//end of setFirst


    public String getLastName() 
    {
        return lastName;
    }//end of getLast

    
    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }//end of setLast


    public String getPhone() 
    {
        return phone;
    }//getPhone


    public void setPhone(String phone) 
    {
        this.phone = phone;
    }//setPhone
   
    
    public boolean equals(){
        if(lastName.equals(firstName))
        {
            return true;
        }
        else
            return false;
    }//end of equals
   
    
    public String toString() 
    {
        return this.firstName + " "+ this.lastName + " " + this.phone;
    }//end of toString


    
}//Class Contact

