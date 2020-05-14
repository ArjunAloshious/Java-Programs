/**
 * Description of FindSingleGene *
 * 
 * FindSingleGene is a program to :
 * 
 * Check if each given gene contains both the codons ATG and TAA
 * If it does, then check if the gene is a multiple of 3, which indicates it is a valid gene.
 * Print all genes obtained along with their description.
 *
 **/
 
public class FindSingleGene
{
    public String findSimpleGene(String dna, String startCodon, String stopCodon)
    {
        String res = "";
        String newres = "";
        int startindex = dna.indexOf(startCodon);
        int stopindex = dna.indexOf(stopCodon , startindex+3);
        if ( startindex == -1 && stopindex == -1 )
        {
           return "NULL -> No ATG and TAA present";
        }
        if ( startindex == -1 )
        { 
			return "NULL -> No ATG present";
        }
		if ( stopindex == -1 )
        { 
			return "NULL -> No TAA present";
        }
        res = dna.substring(startindex , stopindex+3);
        newres = res.substring(startindex+3 , stopindex);
        int l = newres.length();
        if ( l %3 == 0)
        {
            System.out.println("String is a Multiple of 3");
            return newres;
        }           
        else
        {
            System.out.println("String ISN'T a Multiple of 3");
            return res;
        }
    }
	
    public void testGene()
    {
        String dna = "ATGCAACCCTAA";    //String is a multiple of 3 
        System.out.println("DNA strand is : " + dna);
        String gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is  : " + gene);
        
        String dna2 = "ACGCGCTACGTC";   //Contains no ATG and TAA
		System.out.println("DNA strand is : " + dna2);
		String gene2 = findSimpleGene(dna2, "ATG", "TAA");
		System.out.println("Gene is  : " + gene2);
		
		String dna3 = "ACCATGGCTACGTCG";    //Contains no TAA
		System.out.println("DNA strand is : " + dna3);
		String gene3 = findSimpleGene(dna3, "ATG", "TAA");
		System.out.println("Gene is  : " + gene3);
		
		String dna4 = "CGCTACTAAATC";   //Contains no ATG
		System.out.println("DNA strand is : " + dna4);
		String gene4 = findSimpleGene(dna4, "ATG", "TAA");
		System.out.println("Gene is  : " + gene4);
		
		String dna5 = "ATGCGCTACGTAAATC";   //String isn't a multiple of 3 
		System.out.println("DNA strand is : " + dna5);
		String gene5 = findSimpleGene(dna5, "ATG", "TAA");
		System.out.println("Gene is  : " + gene5);
    }
	
    public static void main(String[] args)
    {
        FindSingleGene p = new FindSingleGene();
        p.testGene();
    }
}