import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class Brute {
    public static void main(String[] args) {
        int N = StdIn.readInt(); // Read number of points
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = StdIn.readInt();
            int y = StdIn.readInt();
            points[i] = new Point(x, y);
        }
        StdDraw.setXscale(0, 32767);
        StdDraw.setYscale(0, 32767);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.005);
        for (Point p : points)
            p.draw(); // Plot all points [page:1]

        // Brute force: check all 4-combinations
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    for (int l = k + 1; l < N; l++) {
                        Point p = points[i], q = points[j], r = points[k], s = points[l];
                        if (p.slopeTo(q) == p.slopeTo(r) &&
                                p.slopeTo(q) == p.slopeTo(s)) {
                            // Print in order along line (simple: sort by x then y)
                            Point[] seg = { p, q, r, s };
                            Arrays.sort(seg); // Needs compareTo by y then x
                            StdOut.printf("%d: %s -> %s -> %s -> %s\n", 4, seg[0], seg[1], seg[2], seg[3]);
                            seg[0].drawTo(seg[3]); // Draw full segment [page:1][web:8]
                        }
                    }
                }
            }
        }
    }
}