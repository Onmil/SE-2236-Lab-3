import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class Fast {

    public static void main(String[] args) {

        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);

        In in = new In();

        int N = in.readInt();
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
            points[i].draw();
        }

        for (int i = 0; i < N; i++) {

            Point origin = points[i];

            // Copy array excluding origin
            Point[] copy = new Point[N - 1];
            int index = 0;

            for (int j = 0; j < N; j++) {
                if (j != i)
                    copy[index++] = points[j];
            }

            // Sort by slope with respect to origin
            Arrays.sort(copy, origin.SLOPE_ORDER);

            int count = 1;

            for (int k = 1; k < copy.length; k++) {

                if (Double.compare(
                        origin.slopeTo(copy[k]),
                        origin.slopeTo(copy[k - 1])) == 0) {

                    count++;
                } else {
                    if (count >= 3) {
                        printSegment(origin, copy, k - count, k - 1);
                    }
                    count = 1;
                }
            }

            // Check last group
            if (count >= 3) {
                printSegment(origin, copy, copy.length - count, copy.length - 1);
            }
        }

        StdDraw.show();
    }

    private static void printSegment(Point origin, Point[] arr, int start, int end) {

        Point[] segment = new Point[end - start + 2];
        segment[0] = origin;

        int idx = 1;
        for (int i = start; i <= end; i++) {
            segment[idx++] = arr[i];
        }

        // Sort to print minimal representation
        Arrays.sort(segment);

        // Avoid duplicate printing (only print if origin is smallest)
        if (!origin.equals(segment[0]))
            return;

        StdOut.print(segment.length + ": ");

        for (int i = 0; i < segment.length; i++) {
            if (i > 0)
                StdOut.print(" -> ");
            StdOut.print(segment[i]);
        }

        StdOut.println();

        // Draw line segment
        for (int i = 0; i < segment.length - 1; i++) {
            segment[i].drawTo(segment[i + 1]);
        }
    }
}