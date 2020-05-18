/**
 * Description of CSVMinTemp *
 * 
 * CSVMinTemp is a program used to :
 *
 * Return the lowest Temperature value in a CSV file.
 * Return the lowest Temperature value from multiple selected CSV files in a Directory.
 *
 **/

import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;

public class CSVMinTemp
{
	public CSVRecord coldestHourInFile(CSVParser parser)
	{
		CSVRecord smallest = null;
		for(CSVRecord currRow : parser)
		{
			smallest=getSmallestOfTwo(currRow, smallest);
		}
		return smallest;
	}

	public void Test()
	{
	    String name = "";
		
		name = coldestInManyDays();
		System.out.println("Coldest File : "+ name);
		FileResource fr= new FileResource();
		CSVRecord smallest = coldestHourInFile(fr.getCSVParser());
		System.out.println("\nColdest temp was " + smallest.get("TemperatureF") + " at " + smallest.get("DateUTC"));
	}
	
	public String coldestInManyDays()
	{
		CSVRecord smallest = null;
		String name = "";
		DirectoryResource dr = new DirectoryResource();
		for(File f : dr.selectedFiles())
		{
			FileResource fr = new FileResource(f);
			CSVRecord currRow = coldestHourInFile(fr.getCSVParser());
			if(smallest == null)
			{
				smallest=currRow;
				name = f.getName();
			}
			else
			{
				double currTemp = Double.parseDouble(currRow.get("TemperatureF"));
				double sTemp = Double.parseDouble(smallest.get("TemperatureF"));
				if(currTemp == -9999 )
				{
					return "Error value";
				}
				if(sTemp == -9999 )
				{
					return "Error value";
				}
				if(currTemp < sTemp)
				{
					smallest=currRow;
					name = f.getName();
				}
			}
		}
		return name;
	}
	
	public CSVRecord getSmallestOfTwo(CSVRecord currRow, CSVRecord smallest)
	{
		if(smallest == null)
			{
				smallest=currRow;
			}
			else
			{
				double currTemp = Double.parseDouble(currRow.get("TemperatureF"));
				double sTemp = Double.parseDouble(smallest.get("TemperatureF"));
				if(currTemp<sTemp)
				{
					smallest=currRow;
				}
			}
		return smallest;
	}
	
	public void main(String args[])
	{
		CSVMinTemp ob = new CSVMinTemp();
		ob.Test();
	}
	
}