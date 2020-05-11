/**
 * Description of LargestPerimeterMultipleFiles *
 * 
 * LargestPerimeterMultipleFiles is a program that :
 * 
 * Prints the perimeter of a shape whose coordinates are given in another file
 * Displays the number of sides of that shape
 * Displays the average value of length of all sides
 * Displays the largest side of the shape by finding distance between the given coordinates
 * Displays the largest perimeter from multiple files like that
 * Prints the name of the largest file
 *
 **/


import edu.duke.*;
import java.io.File;

public class LargestPerimeterMultipleFiles {
	
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int count=0;
        for ( Point currPt : s.getPoints() )
        {
            count++;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        double p = getPerimeter(s);
        int count = getNumPoints(s);
        return p/count;
    }

    public double getLargestSide(Shape s) {
        double max=0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if(currDist > max)
            {
                max = currDist;
            }
            prevPt = currPt;
        }
        return max;
    }

    public double getLargestX(Shape s) {
        double max = 0.0;
        for (Point currPt : s.getPoints())
        {
            double x = (double) currPt.getX();
            if(x>max)
            {
                max=x;
            }
        }
        return max;
    }

    public double getLargestPerimeterMultipleFiles() {
		double max = 0.0;
		double p = 0.0;
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			Shape s = new Shape(fr);
			p = getPerimeter(s);
			if (p > max)
			{
				max = p;
			}
		}
        return max;
    }

    public String getFileWithLargestPerimeter() {
        double max = 0.0;
        String name = new String(); 
		DirectoryResource dr = new DirectoryResource();
		for ( File f : dr.selectedFiles())
		{
			FileResource fr = new FileResource(f);
			Shape s = new Shape(fr);
			double p = getPerimeter(s);
			if (p > max)
			{
				max = p;
				name = f.getName();
			}
		}
        return name;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int count = getNumPoints(s);
        System.out.println("Count = " + count);
        double av = getAverageLength(s);
        System.out.println("Average = " + av);
        double max = getLargestSide(s);
        System.out.println("Largest Side = " + max);
        double max2 = getLargestX(s);
    }
    
    public void testPerimeterMultipleFiles() {
        double lp = getLargestPerimeterMultipleFiles();
		System.out.println("Largest perimeter  = " + lp);
    }

    public void testFileWithLargestPerimeter() {
	   String name = getFileWithLargestPerimeter();
       System.out.println("Name of File with largest perimeter is : " + name);
    }

    public static void main (String[] args) {
        LargestPerimeterMultipleFiles pr = new LargestPerimeterMultipleFiles();
        pr.testPerimeter();
		pr.testPerimeterMultipleFiles();
		pr.testFileWithLargestPerimeter();
    }
}
