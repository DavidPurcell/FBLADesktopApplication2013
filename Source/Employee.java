
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1100167246
 */
public class Employee {
    
    private String[] EmployeeData = new String[9];

    Employee(String ID) throws IOException
    {
        //Create employee with specified ID
        BufferedReader CSVFile = new BufferedReader(new FileReader("CSVFiles\\Employees.txt"));
        String dataRow = CSVFile.readLine();
        while (dataRow != null)
        {
            String[] dataArray = dataRow.split(",");
            if(dataArray[0].equals(ID))
            {
                for(int i=0; i<dataArray.length; i++)
                {
                    EmployeeData[i] = dataArray[i];
                }
            }
            dataRow = CSVFile.readLine();
        }
        CSVFile.close();
    }
    
    Employee(String ID, int index) throws IOException
    {
        //Create employee with data that matches specified index
        BufferedReader CSVFile = new BufferedReader(new FileReader("CSVFiles\\Employees.txt"));
        String dataRow = CSVFile.readLine();
        while (dataRow != null)
        {
            String[] dataArray = dataRow.split(",");
            if(dataArray[index].equals(ID))
            {
                for(int i=0; i<dataArray.length; i++)
                {
                    EmployeeData[i] = dataArray[i];
                }
            }
            dataRow = CSVFile.readLine();
        }
        CSVFile.close();
    }
    
    Employee(String Name,String email,String phoneNumber,String cellNumber,String streetAddress,String city,String zipCode,String employer) throws IOException
    {
        //Create a new employee with all data given
        EmployeeData[0] = randID();
        EmployeeData[1] = Name.split(" ")[0];
        if(Name.split(" ").length>1) {
            EmployeeData[2] = Name.split(" ")[1];
        }
        else {
            EmployeeData[2] = "";
        }
        EmployeeData[3] = email;
        EmployeeData[4] = phoneNumber;
        EmployeeData[5] = cellNumber;
        EmployeeData[6] = streetAddress;
        EmployeeData[7] = city;
        EmployeeData[8] = zipCode;
        Employer Empr = new Employer(employer);
        FieldPlacement Fp = new FieldPlacement(EmployeeData[0], Empr.getData(0));
        save();
    }
    
    public void save() throws IOException
    {
        //Write employee's data to CSV file
        File tmp = File.createTempFile("tmp", "");
        BufferedReader br = new BufferedReader(new FileReader("CSVFiles\\Employees.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tmp));
        String line = br.readLine();
        while (line != null)
        {
            bw.write(String.format("%s%n", line));
            line = br.readLine();
        }
        for (int i=0; i<EmployeeData.length; i++)
        {
            bw.write(EmployeeData[i] + ",");
        }
        
        br.close();
        bw.close();
        
        File oldFile = new File("CSVFiles\\Employees.txt");
        if (oldFile.delete()) 
        {
            tmp.renameTo(oldFile);
        }
    }
    
    private String randID() throws IOException
    {
        //Generate random ID that does not already exist
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
        //Generate 6 digit ID number
        String ID;
        ID = ""+(int)(Math.random()*10) + (int)(Math.random()*10) + (int)(Math.random()*10) +
                (int)(Math.random()*10) + (int)(Math.random()*10) + (int)(Math.random()*10);
        return ID;
    }
    
    public String getData(int i)
    {
        //return data at specified index
        return EmployeeData[i];
    }
}
