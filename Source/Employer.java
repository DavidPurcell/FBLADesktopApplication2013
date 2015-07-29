
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
public class Employer {
    
    private String[] EmployerData = new String[9];
    
    Employer(String ID) throws IOException
    {
        //Generate employer with specified ID
        BufferedReader CSVFile = new BufferedReader(new FileReader("CSVFiles\\Employers.txt"));
        String dataRow = CSVFile.readLine();
        while (dataRow != null)
        {
            String[] dataArray = dataRow.split(",");
            if(dataArray[0].equals(ID) || dataArray[1].equals(" " + ID) || dataArray[1].equals(ID))
            {
                System.arraycopy(dataArray, 0, EmployerData, 0, dataArray.length);
            }
            dataRow = CSVFile.readLine();
        }
        CSVFile.close();
    }
    
    Employer(String name,String address,String city,String state, String zipCode,String phoneNumber,String email,String contactPerson) throws IOException
    {
        //Create employer with all data specified
        EmployerData[0] = randID();
        EmployerData[1] = name;
        EmployerData[2] = address;
        EmployerData[3] = city;
        EmployerData[4] = state;
        EmployerData[5] = zipCode;
        EmployerData[6] = phoneNumber;
        EmployerData[7] = email;
        EmployerData[8] = contactPerson;
        save();
    }
    
    public void save() throws IOException
    {
        //Write data to CSV files
        File tmp = File.createTempFile("tmp", "");
        BufferedReader br = new BufferedReader(new FileReader("CSVFiles\\Employers.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tmp));
        String line = br.readLine();
        while (line != null)
        {
            bw.write(String.format("%s%n", line));
            line = br.readLine();
        }
        for (int i=0; i<EmployerData.length; i++)
        {
            bw.write(EmployerData[i] + ",");
        }
        
        br.close();
        bw.close();
        
        File oldFile = new File("CSVFiles\\Employers.txt");
        if (oldFile.delete()) 
        {
            tmp.renameTo(oldFile);
        }
    }
    
    public String randID() throws IOException
    {
        //Generate random unique ID
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
        //Generate 6 digit ID
        String ID;
        ID = ""+(int)(Math.random()*10) + (int)(Math.random()*10) + (int)(Math.random()*10) +
                (int)(Math.random()*10) + (int)(Math.random()*10) + (int)(Math.random()*10);
        return ID;
    }
    
    public String getData(int i)
    {
        //Return specified data index
        return EmployerData[i];
    }
}
