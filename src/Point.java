
/*************************************************************************
 * Name:
 * Login:
 * Precept: 
 *
 * Compilation:  javac Point.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/
import edu.princeton.cs.algs4.StdDraw;
import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER; // YOUR DEFINITION HERE

    private final int x; // x coordinate
    private final int y; // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.SLOPE_ORDER = null; // temporary fix, but also put your code in here, this is just place holder
                                 // check the constructor in the assignment description for more details on how to implement this
    }

    // plot this point to standard drawing
    public void draw() {
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        return 0.0; // your code here, return 0.0 is just placeholder
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        return 0; // your code here, return 0.0 is just placeholder
    }

    // return string representation of this point
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
