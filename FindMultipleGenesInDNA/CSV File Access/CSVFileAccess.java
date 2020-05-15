/**
 * Description of FirstCSVExample *
 *
 * This program accesses contents of a CSV file and displays them individually, by column.
 *
 **/
 
import edu.duke.*;
import org.apache.commons.csv.*;

public class CSVFileAccess
{
	public void readFood()
	{
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		for(CSVRecord record : parser)
		{
			System.out.println(record.get("Country"));
			System.out.println(record.get("Exports"));
			System.out.println(record.get("Value (dollars)"));			
		}
	}
	
	public void main(String args[])
	{
		CSVFileAccess ob = new CSVFileAccess();
		ob.readFood();
	}
}