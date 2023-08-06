import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.lang.*;
import java.text.SimpleDateFormat;  
import java.util.Date;
import Project.Doctor;
import Project.Patient;
import Project.Medicine;
import Project.Work;
class DoctorNotFoundException extends Exception
{
    String msg;
    public DoctorNotFoundException(String m)
    {
        msg=m;
    }
}
class admin1
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        //int choice=0
        Patient pat=new Patient();
        System.out.println("\n\n\n");
        System.out.println("\t\t\t----HOSPITAL MANAGEMENT SYSTEM----\t\t\t");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();  
        System.out.println("\n\n\t\t\t"+formatter.format(date)); 
        String curdate=formatter.format(date);
        System.out.println("\t\t\t*******************************\t\t\t");
        System.out.println("\t\t\t1.Doctors \n\t\t\t2.Patients \n\t\t\t3.Workers \n\t\t\t4.Drugs\n\t\t\t5.Exit\t\t\t");
        System.out.println("\t\t\t*******************************\t\t\t");
        System.out.println("Enter the choice:");
        int opt=sc.nextInt();
        Patient p[]=new Patient[40];
        ArrayList<String> hepat=new ArrayList<String>();
    ArrayList<String> gynae=new ArrayList<String>();
   ArrayList<String> genmed=new ArrayList<String>();

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

        int j=0;
                try
                {
                File fr = new File("C:\\Users\\Swetha\\Desktop\\JAVA PROJECT\\Project\\patients.txt");
                Scanner s=new Scanner(fr);
                while(s.hasNextLine())
                {
                  String data=s.nextLine();
                  String []result=data.split(":");
                  p[j]=new Patient(result[0],result[1],result[2],result[3],result[4],result[5]);
                  j++; 
                }
              }
               catch(IOException t)
               {
                 System.out.println("Cannot access Patient file");
               }Medicine me[]=new Medicine[50]; 
                String DrugName,Manufacturedate,Expirydate,Quantity,Allergic;
                int q=0;
                try
                {
                File fr = new File("C:\\Users\\Swetha\\Desktop\\JAVA PROJECT\\Project\\medicines.txt");
                Scanner s=new Scanner(fr);
                while(s.hasNextLine())
                {
                  String data=s.nextLine();
                  String []re=data.split(":");
                  me[q]=new Medicine(re[0],re[1],re[2],re[3],re[4]);
                  q++; 
                }
              }
               catch(IOException t)
               {
                 System.out.println("Cannot access Medicine file");
               }
               int lq=0,ma=0;
              // String wname,workerID,dept,wardno,time;
               Work w[]=new Work[40];
               try{
                File fr = new File("C:\\Users\\Swetha\\Desktop\\JAVA PROJECT\\Project\\worker.txt");
                Scanner st=new Scanner(fr);
                while(st.hasNextLine() && ma<10)
                {
                  String data=st.nextLine();
                  String []resu=data.split(":");
                 // System.out.println(resu[0]+" "+resu[1]+" "+resu[2]+" "+resu[3]+" "+resu[4]);
                  ma++;
                  w[lq]=new Work(resu[0],resu[1],resu[2],resu[3],resu[4]);
                  lq++; 
                }
              }
               catch(IOException t)
               {
                 System.out.println("Cannot access workers file");
               }
        while(opt!=5)
        {
               Doctor d[]=new Doctor[40]; 
                int i=0;
                String dname,qualification,availablehr,specialist,workingday;
                try
                {
                File fr = new File("C:\\Users\\Swetha\\Desktop\\JAVA PROJECT\\Project\\doctors.txt");
                Scanner s=new Scanner(fr);
                while(s.hasNextLine())
                {
                  String data=s.nextLine();
                  String []result=data.split(":");
                  d[i]=new Doctor(result[0],result[1],result[2],result[3],result[4]);
                  i++; 
                }
              }
               catch(IOException t)
               {
                 System.out.println("Cannot access Doctor file");
               }
            if(opt==1)
            {
                System.out.println("\n1)Add an entry for doctor\n2)View data\n3)CheckAvailability\n4)Exit\n");
                int opt1=sc.nextInt();
              
            while(opt1!=4)
            {
            if(opt1==1)
            {
                File doc=new File("C:\\Users\\Swetha\\Desktop\\JAVA PROJECT\\Project\\doctors.txt");
                i=i+1;
                    System.out.println("Enter the name:");
                    sc.nextLine();
                    dname=sc.nextLine();
                    System.out.println("Enter the qualification:");
                    qualification=sc.nextLine();
                    System.out.println("Enter the specialization:");
                    specialist=sc.nextLine();
                    System.out.println("Enter the available hours:");
                    availablehr=sc.nextLine();
                    System.out.println("Enter the working days:");
                    workingday=sc.nextLine();
                    d[i]=new Doctor(dname,qualification,specialist,availablehr,workingday);
                    try
                    {
                        FileWriter fwrite=new FileWriter("C:\\Users\\Swetha\\Desktop\\JAVA PROJECT\\Project\\doctors.txt",true);
                        fwrite.write("\n");
                        fwrite.write(d[i].dname+":");
                        fwrite.write(d[i].qualification+":");
                        fwrite.write(d[i].specialist+":");
                        fwrite.write(d[i].availablehr+":");
                        fwrite.write(d[i].workingday+":");
                        System.out.println("\nWritten successfully");
                        fwrite.close();
                    }
                    catch(IOException t)
                    {
                        System.out.println(t);
                    }  
                }
                if(opt1==2)
                {
                    try
                    {
                    File fr = new File("C:\\Users\\Swetha\\Desktop\\JAVA PROJECT\\Project\\doctors.txt");
                    Scanner sw=new Scanner(fr);
                   while(sw.hasNextLine())
                    {
                      String data=sw.nextLine();
                      String []res=data.split(":");
                     System.out.println(res[0]+"\t"+res[1]+"\t"+res[2]+"\t"+res[3]+"\t"+res[4]+"\n");
                    }
                }
               catch(IOException t)
               {
                 System.out.println(t);
               }
            }
            if(opt1==3)
            {
                System.out.println("Enter the name of the doctor to check availability:");
                sc.nextLine();
                String se=sc.nextLine();
                try
                {
                int y=0,m=0;
                for(y=0;y<i;y++)
                {
                    // System.out.println("$$$$$$$$");
                    String ds=d[y].dname;           
                    if((d[y].dname).equals(se))
                    {
                        System.out.println(ds+" is available at "+d[y].getAvailability()+" on "+d[y].getWorkingday());
                        m=m+1;
                        break;
                    }
                } 
                if(m==0)
                {
                    throw new DoctorNotFoundException("Doctor not found-Recheck the name");
                }
                }
                catch(DoctorNotFoundException e)
                {
                    System.out.println(e.msg);
                }
                
            }
            // if(opt1==4)
            // {
            //     System.out.println("Enter the name of the doctor to update:");
            //     sc.nextLine();
            //     String du=sc.nextLine();
            //     System.out.println("Enter the specialization of "+du+":");
            //     String dsp=sc.nextLine();
                
            //     for(j=0;j<i;j++)
            //     {
            //         String h=d[j].dname;
            //         if(h.equals(du)&& (d[j].getSpecialization()).equals(dsp))
            //         {
                        
            //             System.out.println("Enter the name to be updated:");
            //             String h1=sc.nextLine();
            //             System.out.println("Enter the qualification of "+h1+":");
            //             String h2=sc.nextLine();
            //             System.out.println("Enter the specialization of "+h1+":");
            //             String h3=sc.nextLine();
            //             System.out.println("Enter the available hours:");
            //             String h4=sc.nextLine();
            //             System.out.println("Enter the available days:");
            //             String h5=sc.nextLine();
            //             String tempfile="temp.txt";
            //             File oldfile=new File("C:\\Users\\swath\\OneDrive\\Desktop\\Swathika\\Project\\doctors.txt");
            //             File newfile=new File(tempfile);
            //             String currentline,data[];
            //             try
            //             {
            //                 FileWriter fw=new FileWriter(tempfile,true);
            //                 BufferedWriter bw=new BufferedWriter(fw);
            //                 PrintWriter pw=new PrintWriter(bw);
            //                 FileReader fr=new FileReader("C:\\Users\\swath\\OneDrive\\Desktop\\Swathika\\Project\\doctors.txt");
            //                 BufferedReader br=new BufferedReader(fr);
            //                 int e=0;
            //                 while((currentline=br.readLine())!=null && e!=5)
            //                 {
            //                     data=currentline.split(":");
            //                     if(!data[e].equalsIgnoreCase(du))
            //                     {
            //                         pw.println(currentline);
            //                     }
            //                     e++;
            //                 }
            //                 pw.flush();
            //                 pw.close();
            //                 fr.close();
            //                 fw.close();
            //                 br.close();
            //                 bw.close();
            //             }
            //             catch(IOException t)
            //             {
            //                 System.out.println("Error deleting the line");
            //             }
            //             oldfile.delete();
            //             File doctors=new File("C:\\Users\\swath\\OneDrive\\Desktop\\Swathika\\Project\\doctors.txt");
            //             newfile.renameTo(doctors);
            //             try
            //             {
            //             FileWriter fwrite=new FileWriter("C:\\Users\\swath\\OneDrive\\Desktop\\Swathika\\Project\\doctors.txt",true);
            //             fwrite.write("\n");
            //             fwrite.write(h1+":");
            //             fwrite.write(h2+":");
            //             fwrite.write(h3+":");
            //             fwrite.write(h4+":");
            //             fwrite.write(h5+":");
            //             fwrite.close();
            //             }
            //             catch(IOException t)
            //             {
            //                 System.out.println("Cannot update");
            //             }
            //         }
            //     }
            // }
            System.out.println("\n1)Add an entry for doctor\n2)View data\n3)CheckAvailability\n4)Exit\n");
            opt1=sc.nextInt();
            }
            }
            if(opt==2)
            {
                //j=0;
                System.out.println("\n1)Add a patient\n2)View patient details\n3)Find the illness\n4)Appointment Fixature\n5)Stop");
                int opt2=sc.nextInt();
                
               while(opt2!=5)
               {
                String name,age,gender,memberID,illness,symp1,symp2,symp3,aller;
                if(opt2==1)
                {
                    File doc=new File("C:\\Users\\Swetha\\Desktop\\JAVA PROJECT\\Project\\patients.txt");
                    j=j+1;
                    System.out.println("Enter the name of the patient:");
                    sc.nextLine();
                    name=sc.nextLine();
                    //System.out.println("Your memberID:");
                    Random rand = new Random();
                    int resRandom = rand.nextInt((9999 - 100) + 1) + 10;
                    memberID="PID"+resRandom;
                    System.out.println("MemberID:"+"PID"+resRandom);
                    System.out.println("Enter the age of "+name+":");
                    age=sc.nextLine();
                    System.out.println("Enter the gender of "+name+":");
                    gender=sc.nextLine();
                    System.out.println("Enter the illness that"+name+" has:");
                    illness=sc.nextLine();
                    System.out.println("To what is "+name+" allergic to?");
                    aller=sc.nextLine();
                    p[j]=new Patient(name,memberID,age,gender,illness,aller);
                    try
                    {
                        FileWriter fwrite=new FileWriter("C:\\Users\\Swetha\\Desktop\\JAVA PROJECT\\Project\\patients.txt",true);
                        fwrite.write("\n");
                        fwrite.write(p[j].name+":");
                        fwrite.write(p[j].memberID+":");
                        fwrite.write(p[j].age+":");
                        fwrite.write(p[j].gender+":");
                        fwrite.write(p[j].illness+":");
                        fwrite.write(p[j].aller+":");
                        System.out.println("\nWritten successfully");
                        fwrite.close();
                    }
                    catch(IOException t)
                    {
                        System.out.println(t);
                    }  
                }
                if(opt2==2)
                {
                    try
                    {
                    File fr = new File("C:\\Users\\Swetha\\Desktop\\JAVA PROJECT\\Project\\patients.txt");
                    Scanner sw=new Scanner(fr);
                    while(sw.hasNextLine())
                    {
                      String data=sw.nextLine();
                      String []res=data.split(":");
                     System.out.println(res[0]+"\t"+res[1]+"\t"+res[2]+"\t"+res[3]+"\t"+res[4]+"\t"+res[5]+"\n");
                    }
                }
               catch(IOException t)
               {
                 System.out.println(t);
               }
            }
            if(opt2==3)
            {
                int check=0;
                System.out.println("Enter your memberID:");
                sc.nextLine();
                String sid=sc.nextLine();

                for(int y=0;y<j;y++)
                {
                    String hs=p[y].memberID;
                    if(hs.equalsIgnoreCase(sid))
                    {
                        check=1;                
                        System.out.println("\n\nIdentify alteast 3 symptoms from the list:\n");
                System.out.println("\n\nfever--headache--throat infection--body pain--constipation--diarrhea");
                System.out.println("anaemia--irregular menstrual cycle--stomach pain--fatigue--mood disorders--hormonal imbalance");
                System.out.println("yellow eyes--yellow skin--nausea--swelling of legs--abdominal pain--loss of appetite--fever\n\n");
                       System.out.println("Enter your symptom1:");
                       symp1=sc.nextLine();
                       System.out.println("Enter your symptom2:");
                       symp2=sc.nextLine();
                       System.out.println("Enter your symptom3:");
                       symp3=sc.nextLine(); 
                       Patient py=new Patient();
                       p[y].findWithSymptoms(symp1,symp2,symp3,hepat,gynae,genmed);
                       break;
                    }
                }
                if(check==0)
                {
                    System.out.println("Invalid memberID");
                    System.out.println("If you are new, please add your name");
                }  
            }
            if(opt2==4)
            {
                int m=0;
                System.out.println("Enter patient's name: ");
                sc.nextLine();
                String patname=sc.nextLine();
                System.out.println("Enter patient's age: ");
                int pAge=sc.nextInt();



                System.out.println("Enter the doctor you want to consult:");
                sc.nextLine();
                String docname=sc.nextLine();
               System.out.println("\n");
               try{
                for(int y=0;y<i;y++)
                {
                    String ds=d[y].dname;           
                    if((d[y].dname).equals(docname))
                    {
                        System.out.println(ds+" is available at "+d[y].getAvailability()+" on "+d[y].getWorkingday());
                        //pat.DisplayAppointment(patname,pAge,docname,d[y].getSpecialization(),pd,pt);
                        m=m+1;
                        break;
                    }
                } 
                System.out.println("\n");
                if(m==0)
                {
                    throw new DoctorNotFoundException("Doctor not found- Recheck the name");
                }
               }
               catch(DoctorNotFoundException e)
               {
                System.out.println(e.msg);
               }
                if(m!=0)
                {
                System.out.println("Enter the time to consult:");
                String pt=sc.nextLine();
                System.out.println("Enter the day to consult:");
                String pd=sc.nextLine();
                for(int y=0;y<i;y++)
                {
                    String ds=d[y].dname;           
                    if((d[y].dname).equals(docname))
                    {
                        //System.out.println(ds+" is available at "+d[y].getAvailability()+" on "+d[y].getWorkingday());
                        pat.DisplayAppointment(patname,pAge,docname,d[y].getSpecialization(),pd,pt);
                        m=m+1;
                        break;
                    }
                } 

                

                }
                //System.out.println(docname+" is available on"+docname.getWorkingday()+ "at "+docname.getAvailability());
                /*System.out.println("Enter the doctor you want to consult:");
                sc.nextLine();
                String dc=sc.nextLine();

                int k=0;
                for(int l=0;l<i;l++)
                {
                    if((d[l].dname).equals(dc))
                    {
                        k++; 
                        // System.out.println("****");
                        String da=d[l].getAvailability();
                        // System.out.println(da);
                        String dw=d[l].getWorkingday();
                        String sd=dw.substring(0,3);
                        // System.out.println(dw);
                        String day[]={"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
                        //ArrayList<String> al1=new ArrayList<String>();
                        String arr[]=new String[10];
                        int r=0;
                        for(int aq=0;aq<7;aq++)
                        {
                           //System.out.println(day[aq]);
                            //if(pd.equals(day[aq]))
                           
                            if(pd.equals(day[aq]))
                            {
                                //System.out.println(aq);
                                String endday=dw.substring(4);
                                for(int y=aq;y<7;y++)
                                {
                                    if(day[y].equals(endday))
                                    {
                                        endday=day[y++];
                                        System.out.println(endday);
                                    }
                                }
                                
                                int ap=0;
                                int count=0;
                                for(int mi=aq;((day[mi].compareTo(endday))!=0);mi++)
                                {
                                    //System.out.println(day[mi]);
                                    if(pd.equals(day[mi]))
                                    {
                                        ap++;
                                        System.out.println(dc+" is available at the given day");
                                        System.out.println("You can meet "+dc+" at "+da);
                                        count++;
                                        break;
                                    }
                                    mi++;
                                    // arr[r]=day[mi];
                                    // r++;
                                }
                                if(count==0)
                                {
                                    System.out.println("Sorry , the doctor is not available on that day");
                                }
                            }
                                // else
                                // {
                                //     System.out.println("Sorry..."+dc+" is not available");
                                //     break;
                                // }
                            
                            
                        }
                       
                        // for(int y=0;y<r;y++)
                        // {
                        //     System.out.println(arr[y]);
                        // }
                        //System.out.println(al1);
                        
                        // System.out.println("Time:"+pt+"\tDay:"+pd);
                        // if((da.equalsIgnoreCase(pt))&&(dw.equalsIgnoreCase(pd)))
                        // {
                        //     System.out.println(d[l].dname+" is available");
                        // }
                        // else
                        // {
                        //     System.out.println(d[l].dname+" is not available");
                        // }
                    }
                    
                }
                if(k==0)
                {
                    System.out.println(dc+" is not found: Recheck the name");
                }
            }*/
                
                }
                System.out.println("\n1)Add a patient\n2)View patient details\n3)Find the illness\n4)Appointment Fixature\n5)Stop");
                opt2=sc.nextInt();
               }
            }
             if(opt==3)
             {
                int k=0;
                String name,workerId,wardno,worktime,dept;
              // System.out.println("1.Vie");
               //int opt3=sc.nextInt();
                
               //while(opt3!=5)
               //{
               //if(opt3==1)
               
                 /*  File doc1=new File("C:\\Users\\swath\\OneDrive\\Desktop\\Swathika\\Project\\worker.txt");
                   lq=lq+1;
                       System.out.println("Enter the name:");
                       sc.nextLine();
                       name=sc.nextLine();
                       System.out.println("Enter worker ID :");
                       workerId=sc.nextLine();
                       System.out.println("Enter the department:");
                       dept=sc.nextLine();
                       System.out.println("Enter the wardnumber:");
                       wardno=sc.nextLine();
                       System.out.println("Enter the working hours:");
                       worktime=sc.nextLine();
                       w[lq]=new Work(name,workerId,dept,wardno,worktime);
                       try
                       {
                           FileWriter fwrite=new FileWriter("C:\\Users\\swath\\OneDrive\\Desktop\\Swathika\\Project\\worker.txt",true);
                           fwrite.write("\n");
                           fwrite.write(w[lq].name+":");
                           fwrite.write(w[lq].workerId+":");
                           fwrite.write(w[lq].dept+":");
                           fwrite.write(w[lq].wardno+":");
                           fwrite.write(w[lq].worktime+":");
                           System.out.println("\nWritten successfully");
                           fwrite.close();
                       }
                       catch(IOException t)
                       {
                           System.out.println(t);
                       }  
                   }
                   */
                   System.out.println("\t\t---WORKERS' SCHEDULE---\t\t");
                   int mx=0;
                  // if(opt3==2)
                   //{ 
    
                       try
                       {
                       File fr = new File("C:\\Users\\Swetha\\Desktop\\JAVA PROJECT\\Project\\worker.txt");
                       Scanner sw=new Scanner(fr);
                       int c=0;
                      while(sw.hasNextLine() && c<10)
                       {
                         String data=sw.nextLine();
                         String []res1=data.split(":");
                        System.out.println(res1[0]+"\t"+res1[1]+"\t"+res1[2]+"\t"+res1[3]+"\t"+res1[4]+"\n");
                        c++;
                       }
                   }
                  catch(IOException t)
                  {
                    System.out.println(t);
                  }
                System.out.println("Enter 5 to exit");
               opt=sc.nextInt();
               }
               //System.out.println("1.Add worker \n2.View List \n3.Update");
               //opt3=sc.nextInt();

             
             
             if(opt==4)
             {
                
                System.out.println("\n1)Add a medicine\n2)View Stocks\n3)Check Expiry\n4)Check allergic medicine\n5)Exit");
                int opt4=sc.nextInt();
                while(opt4!=5)
                {
                    if(opt4==1)
                    {
                   try
                   {
                    File fr = new File("C:\\Users\\Swetha\\Desktop\\JAVA PROJECT\\Project\\medicines.txt");
                    q=q+1;
                    System.out.println("Enter the name:");
                    sc.nextLine();
                    DrugName=sc.nextLine();
                    System.out.println("Enter the manufacture date:");
                    Manufacturedate=sc.nextLine();
                    System.out.println("Enter the Expiry date:");
                    Expirydate=sc.nextLine();
                    System.out.println("Enter the Quantity of stock:");
                    Quantity=sc.nextLine();
                    System.out.println("Enter which people should not take "+DrugName+":");
                    Allergic=sc.nextLine();
                    me[q]=new Medicine(DrugName,Manufacturedate,Expirydate,Quantity,Allergic);
                    
                        FileWriter fwrite=new FileWriter("C:\\Users\\Swetha\\Desktop\\JAVA PROJECT\\Project\\medicines.txt",true);
                        fwrite.write("\n");
                        fwrite.write(me[q].DrugName+":");
                        fwrite.write(me[q].Manufacturedate+":");
                        fwrite.write(me[q].Expirydate+":");
                        fwrite.write(me[q].Quantity+":");
                        fwrite.write(me[q].Allergic+":");
                        System.out.println("\nWritten successfully");
                        fwrite.close();
                   }

                    catch(IOException t)
                    {
                        System.out.println(t);
                    }  
                    }
                    if(opt4==2)
                    {
                     try
                     {
                    File fr = new File("C:\\Users\\Swetha\\Desktop\\JAVA PROJECT\\Project\\medicines.txt");
                    Scanner sw=new Scanner(fr);
                    while(sw.hasNextLine())
                    {
                      String data=sw.nextLine();
                      String []re=data.split(":");
                     System.out.println(re[0]+"\t"+re[1]+"\t"+re[2]+"\t"+re[3]+"\t"+re[4]+"\n");
                    }
                   }
                   catch(IOException t)
                   {
                    System.out.println(t);
                   } 
                    }
                    if(opt4==3)
                    { 
                            System.out.println("Q VALUE:"+q);
        
                        for(int ml=0;ml<q;ml++)
                        {
                            me[ml].checkExpiry();
                        }
                    }
                    if(opt4==4)
                    {
                        System.out.println("Enter the name of the medicine:");
                        sc.nextLine();
                        String cm=sc.nextLine();
                        System.out.println("Enter the name of the patient:");
                        String cn=sc.nextLine();
                        int o=0,g=0;
                        System.out.println("j:"+j);
                        int y;
                        for(y=0;y<j;y++)
                        {
                            for(g=0;g<q;g++)
                            {
                              String pname=p[y].name;
                              //System.out.println("name: "+p[y].name);
                              String drug=me[g].DrugName;
                              //System.out.println("Patient name:"+pname+" Drug name:"+drug);
                              if(pname.equals(cn) && (drug.equals(cm)))
                              {
                                System.out.println("\n"+pname+" allergy:"+me[g].Allergic);
                                if((p[y].getAllergy()).equals(me[g].Allergic))
                                {
                                    System.out.println(cn+" is allergic to "+cm);
                                    o++;
                                    break;
                                }
                              }  
                            /*else
                            {
                                break;
                            }*/
                            }
                            
                            
                        }
                        if(o==0)
                        {
                            System.out.println(cn+" is not allergic to "+cm);
                        }
                    }
                System.out.println("\n1)Add a medicine\n2)View Stocks\n3)Check Expiry\n4)Check allergic medicine\n5)Exit");
                //sc.nextInt();
                opt4=sc.nextInt();
                }
             }
              System.out.println("\t\t\t********************************\t\t\t");
             System.out.println("\t\t\t1.Doctors \n\t\t\t2.Patients \n\t\t\t3.Workers \n\t\t\t4.Drugs\n\t\t\t5.Exit\t\t\t");
               System.out.println("\t\t\t********************************\t\t\t");
             System.out.println("Enter the choice:");
             opt=sc.nextInt();     
        }
    
    }
}
