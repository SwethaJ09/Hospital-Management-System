package Project;
public class Doctor
{
    public String dname,specialist,availablehr,workingday;
    public String qualification;
    String obj;
    public Doctor(String obj)
    {
        this.obj=obj;
    }
    public Doctor()
    {

    }
    public Doctor(String dname,String qualification,String specialist,String availablehr,String workingday)
    {
        this.dname=dname;
        this.qualification=qualification;
        this.specialist=specialist;
        this.availablehr=availablehr;
        this.workingday=workingday;
        
    }
    public String getSpecialization()
    {
        return specialist;
    }
    public String getAvailability()
    {
        return availablehr;
    }
    public String getWorkingday()
    {
        return workingday;
    }
    public String toString()
    {
        return("Name: "+dname+" "+qualification+" ,"+specialist);
    }
    public void search(String name)
    {
        
        for(int i=0;i<10;i++)
        {
            if(dname.equalsIgnoreCase(name))
        {
          System.out.println(name+" is available at "+getAvailability());
        }
        if(!dname.equalsIgnoreCase(name))
        {
            System.out.println("Recheck the name");
        }
    }
    }
}