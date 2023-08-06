package Project;

public class Work
{
    public String name,workerId,dept,wardno,worktime;
    public Work(String name,String workerId,String dept,String wardno,String worktime)
    {
        this.name=name;
        this.workerId=workerId;
        this.dept=dept;
        this.wardno=wardno;
        this.worktime=worktime;
    }

    public String getWorkerID()
    {
        return workerId;
    }
    public String getdept()
    {
        return dept;
    }
    public String getwardno()
    {
        return wardno;
    }
    public String getworktime()
    {
        return worktime;
    }
    public String toString()
    {
        return("Name: "+name+"Department: "+dept+"Ward Number: "+wardno+"Work time: "+worktime);
    }
}
