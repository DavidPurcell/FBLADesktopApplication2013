
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1100167246
 */
public class FieldPlacement {
    
    private ArrayList<String[]> Fields = new ArrayList();
    private String[] FieldPlacementData = new String[2];
    
    FieldPlacement() throws IOException
    {
        //Create new FieldPlacement storing all fields
        BufferedReader CSVFile = new BufferedReader(new FileReader("CSVFiles\\FPs.txt"));
        String dataRow = CSVFile.readLine();
        while (dataRow != null)
        {
            String[] dataArray = dataRow.split(",");
            System.arraycopy(dataArray, 0, FieldPlacementData, 0, dataArray.length);
            String[] temp = {FieldPlacementData[0], FieldPlacementData[1]};
            Fields.add(temp);
            
            dataRow = CSVFile.readLine();
        }
        CSVFile.close();
    }
    
    FieldPlacement(String ID, int i) throws IOException
    {
        //Create new FieldPlacement with either Employee or Employer given (0 or 1)
        BufferedReader CSVFile = new BufferedReader(new FileReader("CSVFiles\\FPs.txt"));
        String dataRow = CSVFile.readLine();
        while (dataRow != null)
        {
            String[] dataArray = dataRow.split(",");
            if(dataArray[i].equals(ID))
            {
                System.arraycopy(dataArray, 0, FieldPlacementData, 0, dataArray.length);
                String[] temp = {FieldPlacementData[0], FieldPlacementData[1]};
                Fields.add(temp);
            }
            dataRow = CSVFile.readLine();
        }
        CSVFile.close();
    }
    
    FieldPlacement(String Employee, String Employer) throws IOException
    {
        //Create and store new Field Placement with given values
        FieldPlacementData[0] = Employee;
        FieldPlacementData[1] = Employer;
        String[] temp = {FieldPlacementData[0], FieldPlacementData[1]};
        Fields.add(temp);
        save();
    }
    
    public void save() throws IOException
    {
        //store fieldplacement in FPs.csv
        File tmp = File.createTempFile("tmp", "");
        BufferedReader br = new BufferedReader(new FileReader("CSVFiles\\FPs.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tmp));
        String line = br.readLine();
        while (line != null)
        {
            bw.write(String.format("%s%n", line));
            line = br.readLine();
        }
        for (int i=0; i<FieldPlacementData.length; i++)
        {
            bw.write(FieldPlacementData[i] + ",");
        }
        
        br.close();
        bw.close();
        
        File oldFile = new File("CSVFiles\\FPs.txt");
        if (oldFile.delete()) 
        {
            tmp.renameTo(oldFile);
        }
    }
    
    public String getData(int i, int j)
    {
        //return data at requested index from all fieldsplacements
        return Fields.get(i)[j];
    }
    
    public String getData(int i)
    {
        //return data at requested index from most recent fieldplacement
        return FieldPlacementData[i];
    }
    
    public Employer getEmployer(String str) throws IOException
    {
        //Get employer from specified field placement
        for(String[] string:Fields)
        {
            if(string[0].equals(str))
            {
                return new Employer(string[1]);
            }
        }
        return null;
    }
    
    public ArrayList<String[]> getFields()
    {
        //return list of all Field placements
        return Fields;
    }
}
