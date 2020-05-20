/**
 * Description of CSVHumidity *
 * 
 * CSVHumidity is a program used to :
 *
 * Return the lowest Humidity value in a CSV file.
 * Return the lowest Humidity value from multiple selected CSV files in a Directory.
 *
 **/

import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;

public class CSVHumidity
{
	public CSVRecord lowestHumidityInFile(CSVParser parser)
	{
		CSVRecord smallest = null;
		for(CSVRecord currRow : parser)
		{
			smallest=getsmallestOfTwo(currRow, smallest);
		}
		return smallest;
	}

	public void Test()
	{
		FileResource fr= new FileResource();
		CSVRecord smallest = lowestHumidityInFile(fr.getCSVParser());
		System.out.println("Lowest Humidity was " + smallest.get("Humidity") + " at " + smallest.get("DateUTC"));
		CSVRecord smallestmult = lowestHumidityInManyDays(); 
		System.out.println("Lowest Humidity in Multiple Days was " + smallestmult.get("Humidity") + " at " + smallestmult.get("DateUTC"));
	}
	
	public CSVRecord lowestHumidityInManyDays()
	{
		CSVRecord smallest = null;
		DirectoryResource dr = new DirectoryResource();
		for(File f : dr.selectedFiles())
		{
			FileResource fr = new FileResource(f);
			CSVRecord currRow = lowestHumidityInFile(fr.getCSVParser());
			smallest=getsmallestOfTwo(currRow, smallest);
		}
		return smallest;
	}
	
	public CSVRecord getsmallestOfTwo(CSVRecord currRow, CSVRecord smallest)
	{
		if(smallest == null)
			{
				smallest=currRow;
			}
			else
			{
				double current = Double.parseDouble(currRow.get("Humidity"));
				double lowest = Double.parseDouble(smallest.get("Humidity"));
				if(current < lowest)
				{
					smallest=currRow;
				}
			}
		return smallest;
	}
	
	public void main(String args[])
	{
		CSVHumidity ob = new CSVHumidity();
		ob.Test();
	}
	
}