
/**
 * Description of StringSearch *
 * 
 * StringSearch is a program to :
 *
 * Count the total number of occcurences of a given string in another given string
 * Return the substring, if present, after excluding its first character, else if not present, return an empty string.
 *
 **/
 
public class StringSearch
{
    public int findWordUpgrade(String textString, String word) 
	{
		int count=0;
		String lowerCaseTextString = textString.toLowerCase();
		String lowerCaseWord = word.toLowerCase();
		int wordLength = 0;
		int index = 0;
		while(index != -1)
		{
			index = lowerCaseTextString.indexOf(lowerCaseWord, index + wordLength);  // Slight improvement
			if (index != -1) 
			{
				count++;
			}
			wordLength = word.length();
		}
		return count;
    }
    
    void testing()
    {
      StringSearch p = new StringSearch();
      
      int a = p.findWordUpgrade("hello all hello world hello hello", "hello");
      System.out.println("\nString is : hello all hello world hello hello");
      System.out.println("\nSearch Word is : hello");
      System.out.println("\nNumber of occurences = " + a);
      
      int b = p.findWordUpgrade("hey guys hey", "hi");
      System.out.println("\nString is : hey guys hey");
      System.out.println("\nSearch Word is : hi");
      System.out.println("\nNumber of occurences = " + b);
     
      String s = p.lastPart( "an", "banana" );
      System.out.println("\n\nWhat comes after 'an' in 'banana' ?");
      System.out.println("\nResult = " + s);
      
      String s2 = p.lastPart( "zoo", "forest" );
      System.out.println("\nWhat comes after 'zoo' in 'forest' ?");
      System.out.println("\nResult = " + s2);
      
      String s3 = p.lastPart( "hello", "hello world" );
      System.out.println("\nWhat comes after 'hello' in 'helloworld' ?");
      System.out.println("\nResult = " + s3);
    }
    
    String lastPart(String stra, String strb)
	{
		int startindex = strb.indexOf(stra);
		int lena = stra.length();
		int lenb = strb.length();
		if (startindex != -1)
		{
			String s = strb.substring(lena+1, lenb);
			return s;
		}
		else
		{
			return "";
		}
	}
	
    public static void main(String args[])
    {
      StringSearch p = new StringSearch();
      p.testing();
    }
}
