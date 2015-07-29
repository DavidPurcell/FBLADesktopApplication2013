/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1100167246
 */
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Evaluation {

    private String[] EvaluationData = new String[17];
    
    Evaluation(String ID) throws IOException
    {
        //Create Evaluation with given ID number
        BufferedReader CSVFile = new BufferedReader(new FileReader("CSVFiles\\Evaluations.txt"));
        String dataRow = CSVFile.readLine();
        while (dataRow != null)
        {
            String[] dataArray = dataRow.split(",");
            if(dataArray[0].equals(ID))
            {
                for(int i=0; i<dataArray.length; i++)
                {
                    EvaluationData[i] = dataArray[i];
                }
            }
            dataRow = CSVFile.readLine();
        }
        CSVFile.close();
    }
    
    Evaluation(Employee emp, String empr) throws IOException
    {
        //Create a new Evaluation with given Employee and Employer
        EvaluationData[1] = emp.getData(0);
        EvaluationData[2] = empr;
        save();
    }
    
    Evaluation(String ID, int num) throws IOException
    {
        //Create new Evaluation based on given string at specified index
        BufferedReader CSVFile = new BufferedReader(new FileReader("CSVFiles\\Evaluations.txt"));
        String dataRow = CSVFile.readLine();
        while (dataRow != null)
        {
            String[] dataArray = dataRow.split(",");
            if(dataArray[num].equals(ID))
            {
                for(int i=0; i<dataArray.length; i++)
                {
                    EvaluationData[i] = dataArray[i];
                }
            }
            dataRow = CSVFile.readLine();
        }
        CSVFile.close();
    }
    
    public void save() throws IOException
    {
        //Write in data for a new Evaluation
        File tmp = File.createTempFile("tmp", "");
        BufferedReader br = new BufferedReader(new FileReader("CSVFiles\\Evaluations.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tmp));
            String l;
            while (null != (l = br.readLine()))
            {
                if(!(EvaluationData[0]!=null && EvaluationData[0].equals(l.split(",")[0])) || (EvaluationData[0]!=null && EvaluationData[1].equals(l.split(",")[1])))
                {
                    bw.write(String.format("%s%n", l));
                }
            }
            for (int i=0; i<EvaluationData.length; i++)
            {
                bw.write(EvaluationData[i] + ",");
            }
        br.close();
        bw.close();

        File oldFile = new File("CSVFiles\\Evaluations.txt");
        if (oldFile.delete()) 
        {
            tmp.renameTo(oldFile);
        }
    }
    
    public String getData(int i)
    {
        //Returns data requested
        return EvaluationData[i];
    }
    public Employee getEmployee() throws IOException
    {
        //Return the empoyee that goes with the Evaluation
        Employee emp = new Employee(EvaluationData[1]);
        return emp;
    }
    public Employer getEmployer() throws IOException
    {
        //Return the employer that goes with the Evaluation
        Employer empr = new Employer(""+EvaluationData[2]);
        return empr;
    }
    public void update(int k,int q,int h,int b,int o, boolean e, double a, String kc, String qc, String hc, String bc, String oc, String nd, String empID, String emprID) throws IOException
    {
        //Update data for this evaluation(not yes written to CSV files)
        EvaluationData[0] = randID();
        EvaluationData[9] = ""+k;
        EvaluationData[10] = kc;
        EvaluationData[5] = ""+q;
        EvaluationData[6] = qc;
        EvaluationData[7] = ""+h;
        EvaluationData[8] = hc;
        EvaluationData[11] = ""+b;
        EvaluationData[12] = bc;
        EvaluationData[13] = ""+o;
        EvaluationData[14] = oc;
        EvaluationData[16] = ""+e;
        EvaluationData[15] = ""+a;
        Date now = new Date(); 
        SimpleDateFormat formatter = new SimpleDateFormat( "MM/dd/yyyy" ); 
        EvaluationData[3] = (formatter.format( now ));
        EvaluationData[4] = nd;
        EvaluationData[1] = empID;
        EvaluationData[2] = emprID;
    }
    
    private String randID() throws IOException
    {
        //Generate randomized ID that does not already exist (1,000,000 possible)
        BufferedReader CSVFile = new BufferedReader(new FileReader("CSVFiles\\Employees.txt"));
        String dataRow = CSVFile.readLine();
        String ID="";
        while (dataRow != null)
        {
            ID = newID();
            String[] dataArray = dataRow.split(",");
            if(dataArray[0].equals(ID))
            {
                ID = newID();
            }
            dataRow = CSVFile.readLine();
        }
        CSVFile.close();
        return ID;
    }
        
    private String newID()
    {
        //Create a 6 digit ID number
        String ID;
        ID = ""+(int)(Math.random()*10) + (int)(Math.random()*10) + (int)(Math.random()*10) +
                (int)(Math.random()*10) + (int)(Math.random()*10) + (int)(Math.random()*10);
        return ID;
    }
}
