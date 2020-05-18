/**
 * Description of CSVMaxTemp *
 * 
 * CSVMaxTemp is a program used to :
 *
 * Return the highest Temperature value in a CSV file.
 * Return the highest Temperature value from multiple selected CSV files in a Directory.
 *
 **/

import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;

public class CSVMaxTemp
{
    public CSVRecord hottestHourInFile(CSVParser parser)
    {
        CSVRecord largest = null;
        for(CSVRecord currRow : parser)
        {
            largest=getLargestOfTwo(currRow, largest);
        }
        return largest;
    }

    public void Test()
    {
        FileResource fr= new FileResource();
        CSVRecord largest = hottestHourInFile(fr.getCSVParser());
        System.out.println("hottest temp was " + largest.get("TemperatureF") + " at " + largest.get("TimeEST"));
        CSVRecord largestmany = hottestInManyDays();
        System.out.println("Largest Temperature : "+ largestmany.get("TemperatureF"));
    }
    
    public CSVRecord hottestInManyDays()
    {
        CSVRecord largest = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            CSVRecord currRow = hottestHourInFile(fr.getCSVParser());
            largest=getLargestOfTwo(currRow, largest);
        }
        return largest;
    }
    
    public CSVRecord getLargestOfTwo(CSVRecord currRow, CSVRecord largest)
    {
        if(largest == null)
            {
                largest=currRow;
            }
            else
            {
                double currTemp = Double.parseDouble(currRow.get("TemperatureF"));
                double lTemp = Double.parseDouble(largest.get("TemperatureF"));
                if(currTemp>lTemp)
                {
                    largest=currRow;
                }
            }
        return largest;
    }
    
    public void main(String args[])
    {
        CSVMaxTemp ob = new CSVMaxTemp();
        ob.Test();
    }
    
}