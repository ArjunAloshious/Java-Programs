/**
 * Description of CSVAverageTemp *
 * 
 * CSVAverageTemp is a program used to :
 *
 * Access a CSV file and return the average of all Temperature values in it.
 * Access a CSV file and return the average Temperature of all days with Humidity higher than a value given by the user.
 *
 **/

import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;

public class CSVAverageTemp
{
    public double averageTemperatureInFile(CSVParser parser)
    {
        int c=0;
        double av=0.0;
        for(CSVRecord currRow : parser)
        {
            av=av + getsum(currRow, av);
            c=c+1;
        }
        av=(av/c);
        return av;
    }

    public void Test()
    {
        FileResource fr= new FileResource();
        double av = averageTemperatureInFile(fr.getCSVParser());
        System.out.println("Average temp was " + av);
        FileResource fr2= new FileResource();
        double av2 = averageTemperatureWithHighHumidityInFile(fr2.getCSVParser(),80);
        System.out.println("Average temp above value was " + av2);
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value)
    {
        int c=0;
        double sum=0.0,av=0.0;
        for(CSVRecord currRow : parser)
        {
            double h = Double.parseDouble(currRow.get("Humidity"));
            if(h >= value)
            {
                sum=sum+Double.parseDouble(currRow.get("TemperatureF"));
                c=c+1;
            }
        }
		if (sum==0.0)
        {
            System.out.println("No temperature retrieved with that value of humditiy");
        }
        else
        {
            av=(sum/c);
        }
        return av;
    }
    
    public double getsum(CSVRecord currRow, double sum)
    {
        if(sum == 0.0)
            {
                sum = Double.parseDouble(currRow.get("TemperatureF"));
            }
            else
            {
                double currTemp = Double.parseDouble(currRow.get("TemperatureF"));
                sum=currTemp;
            }
        return sum;
    }
    
    public void main(String args[])
    {
        CSVAverageTemp ob = new CSVAverageTemp();
        ob.Test();
    }
    
}