import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int i=0;
        for(Point pt: s.getPoints()){
            i++;
        }
        return i;
    }

    public double getAverageLength(Shape s) {
        double avg = 0.0;
        double per = getPerimeter(s);
        double no = getNumPoints(s);
        avg = per/no;
        return avg;
    }

    public double getLargestSide(Shape s) {
        double side = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if(currDist>side){
                side = currDist;
            }
            prevPt = currPt;
        }
        return side;
    }

    public double getLargestX(Shape s) {
        double x = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currx = currPt.getX();
            if(currx>x){
                x = currx;
            }
            prevPt = currPt;
        }
        return x;
    }

    public void getLargestPerimeterMultipleFiles() {
        double max = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double newperi = getPerimeter(s);
            if(newperi>max){
                max = newperi;
            }
        }
        System.out.println("Largest Perimeter: "+max);
    }

    public void getFileWithLargestPerimeter() {
        double max = 0.0;
        File temp = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double newperi = getPerimeter(s);
            if(newperi>max){
                max = newperi;
                temp = f;
            }
        }
        System.out.println(temp);
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int noP = getNumPoints(s);
        double avg = getAverageLength(s);
        double larside = getLargestSide(s);
        double bigx = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("no: of points: " + noP);
        System.out.println("Avg Length: "+ avg);
        System.out.println("Biggest side: "+ larside);
        System.out.println("Biggest x: "+ bigx);
        System.out.println("");
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeter();
        pr.testPerimeter();
        pr.testPerimeter();
        pr.printFileNames();
        pr.getLargestPerimeterMultipleFiles();
        pr.getFileWithLargestPerimeter();
    }
}
