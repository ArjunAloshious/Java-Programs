import edu.duke.*;

public class PerimeterRunner {
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

    public void testPerimeter () {
		// Creating a file object
        FileResource fr = new FileResource();
		// Create object s for Shape class
        Shape s = new Shape(fr);
		//Return Perimeter
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
    }

    public static void main (String[] args) {
		// create object of class PerimeterRunner
        PerimeterRunner pr = new PerimeterRunner();
		// Call testPerimeter() to display all output values
        pr.testPerimeter();
    }
}
