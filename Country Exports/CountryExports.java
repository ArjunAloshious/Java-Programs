 

/**
 * Description of CountryExports *
 *
 * Country Exports program is used to :
 *
 * Access contents of a CSV file and display the name of countries that export a specific item
 * Displays a row of data, in a mentioned format, by searching for a given unique country name
 * Prints the name of countries that sell both exportitem1 and exportitem2
 * Displays the total number of countries that export a given item
 * Displays all countries that have an export value above a given amount
 * 
 **/
 
import edu.duke.*;
import org.apache.commons.csv.*;

public class CountryExports
{
    public void listExporters(CSVParser parser, String item)
    {
        for(CSVRecord record : parser)
        {
            String export = record.get("Exports");
            if(export.contains(item))
            {
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    
    public void ItemExporter()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporters(parser, "coffee");
    }
    
    public void Tester()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        String str = countryInfo(parser, "Nauru");
        System.out.println(str);
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "cotton", "flowers");
        parser = fr.getCSVParser();
        int c = numberOfExporters(parser, "cocoa");
        System.out.println("Count = "+c);
        parser = fr.getCSVParser();
       bigExporters(parser, "$999,999,999,999");
    }
        
    public String countryInfo(CSVParser parser, String country)
    {
        for(CSVRecord record : parser)
        {
            String currcountry = record.get("Country");
            if(currcountry.equalsIgnoreCase(country))
            {
              String export = record.get("Exports");
              String value = record.get("Value (dollars)");
              if (value == "" )
              {
                return "NO VALUE(DOLLARS) DATA FOUND";
              }
              else if (export == "")
              {
                return "NO EXPORT DATA FOUND";
              }
              else 
              {
                String res = record.get("Country")+": "+record.get("Exports")+": "+record.get("Value (dollars)");
                return res;
               }
           }
        }
        return "";
    }

    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2)
    {
        for(CSVRecord record : parser)
        {
            String country = record.get("Country");
            String export = record.get("Exports");
            if(export.contains(exportItem1) && export.contains(exportItem2))
            {
                System.out.println(country);
            }
        }
    }

    public int numberOfExporters(CSVParser parser, String exportItem)
    {
        int count = 0;
        for(CSVRecord record : parser)
        {
            String export = record.get("Exports");
            if(export.contains(exportItem))
            {
                count++;
            }
        }
        return count;
    }

    public void bigExporters(CSVParser parser, String amount)
    {
        for(CSVRecord record : parser)
        {
            String country = record.get("Country");
            String value = record.get("Value (dollars)");
            int alen = amount.length();
            int vlen = value.length();
            if(vlen > alen)
            {
                System.out.println(country +" "+ value);
            }           
        }
    }
        
    public void main(String args[])
    {
        CountryExports obj = new CountryExports();
        obj.ItemExporter();
        obj.Tester();
    }
}