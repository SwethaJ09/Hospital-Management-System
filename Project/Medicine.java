package Project;
import java.time.*;
public class Medicine
{
    public String DrugName,Manufacturedate,Expirydate;
    public String Quantity,Allergic;
    public Medicine(String DrugName,String Manufacturedate,String Expirydate,String Quantity,String Allergic)
    {
        this.DrugName=DrugName;
        this.Manufacturedate=Manufacturedate;
        this.Expirydate=Expirydate;
        this.Quantity=Quantity;
        this.Allergic=Allergic;
    }
    public String getExpirydate()
    {
        return Expirydate;
    }
    public String getDrugname()
    {
        return DrugName;
    }
    public void checkExpiry()
    {
        Year thisyear=Year.now();
        String curyear=String.valueOf(thisyear);
        if(curyear.equals(Expirydate))
        {
            System.out.println(DrugName+" is expired");
            Quantity="0";
            System.out.println("---Quantity deduced---\n\n");
        }
        else
        {
            System.out.println(DrugName+" is safe to proceed");
            
        }
    }
}