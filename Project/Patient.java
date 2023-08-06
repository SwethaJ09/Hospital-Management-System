package Project;
import java.util.*;
public class Patient
{
   public String name,memberID;
   public String age,gender,illness,aller;
   public String symp1,symp2,symp3;
   public ArrayList<String> hepat=new ArrayList<String>();
   public ArrayList<String> gynae=new ArrayList<String>();
   public ArrayList<String> genmed=new ArrayList<String>();
   public Patient()
   {

   
    hepat.add("yellow eyes");
    hepat.add("yellow skin");
    hepat.add("nausea");
    hepat.add("swelling of legs");
    hepat.add("abdominal pain");
    hepat.add("loss of appetite");
    hepat.add("fever");


    gynae.add("anaemia");
    gynae.add("irregular menstrual cycle");
    gynae.add("stomach pain");
    gynae.add("fatigue");
    gynae.add("mood disorders");
    gynae.add("hormonal imbalance");


    genmed.add("fever");
    genmed.add("headache");
    genmed.add("throat infection");
    genmed.add("body pain");
    genmed.add("constipation");
    genmed.add("diarrhea");
   }
    public Patient(String name,String memberID,String age,String gender,String illness,String aller)
    {
      this.name=name;
      this.memberID=memberID;
      this.age=age;
      this.gender=gender;
      this.illness=illness;
      this.aller=aller;
    }
   //  public Patient(String name,String memberID,String age,String symp1,String symp2,String symp3)
   //  {
   //      this.name=name;
   //      this.memberID=memberID;
   //      this.age=age;
   //      this.symp1=symp1;
   //      this.symp2=symp2;
   //      this.symp3=symp3;
   //  }
    
    public void findWithSymptoms(String symp1,String symp2,String symp3,ArrayList hepat,ArrayList gynae,ArrayList genmed)
    {
         if(hepat.contains(symp1)&&(hepat.contains(symp2)&&hepat.contains(symp3)))
         {
            System.out.println("Please schedule an appointment wiht the department of hepatology");
            return ;
         }
         if(gynae.contains(symp1)&&(gynae.contains(symp2)&&gynae.contains(symp3)))
         {
            System.out.println("Please schedule an appointment wiht the department of gynaecology");
            return ;
         }
         if(genmed.contains(symp1)&&(genmed.contains(symp2)&&genmed.contains(symp3)))
         {
            System.out.println("Please schedule an appointment wiht the department of general medicine");
            return ;
         }
         if(hepat.contains(symp1)&&(gynae.contains(symp2))&&(gynae.contains(symp3)))
         {
            System.out.println("Please schedule an appointment with the department of gynaecology");
            return ;
         }
         if(hepat.contains(symp1)&&(genmed.contains(symp2))&&(genmed.contains(symp3)))
         {
            System.out.println("Please schedule an appointment with the department of general medicine");
            return ;
         }
         if(gynae.contains(symp1)&&(hepat.contains(symp2))&&(hepat.contains(symp3)))
         {
            System.out.println("Please schedule an appointment with the department of hepatology");
            return ;
         }
         //if(gynae.contains(symp1)&&(genmed.contains(symp2))&&(genmed.contains(symp3)))
         //{
         //   System.out.println("Please schedule an appointment with the department of general medicine");
         //}
         //if(genmed.contains(symp1)&&(gynae.contains(symp2))&&(gynae.contains(symp3)))
         //{
          //  System.out.println("Please schedule an appointment with the department of gynaecology");
         //}
         //if(genmed.contains(symp1)&&(hepat.contains(symp2))&&(hepat.contains(symp3)))
         //{
         //   System.out.println("Please schedule an appointment with the department of hepatology");
         //}
         if(age.compareTo("14")<0)
         {
            System.out.println("Please schedule an appointment with the department of pediatrics");
            return ;
         }
         else{
            System.out.println("Please meet the pathologists and submit blood samples");
            return ;
         }
    }
    public String memberIDGen()
    {
      Random rand = new Random();
      int resRandom = rand.nextInt((9999 - 100) + 1) + 10;
      return "PID"+resRandom;
    }
    public String getAllergy()
    {
      return aller;
    }
    public void DisplayAppointment(String pname,int pAge,String dname,String dept,String day,String hrs)
    {
         System.out.println("\t\t***APPOINTMENT BOOKED***\t\t");
         System.out.println("PATIENT NAME: "+pname);
         System.out.println("PATIENT AGE: "+pAge);
         System.out.println("DUTY DOCTOR: "+dname);
         System.out.println("DEPARTMENT: "+dept);
         System.out.println("DAY: "+day);
         System.out.println("TIME: "+hrs);
         System.out.println("\t\t**********\t\t");

    }
}

