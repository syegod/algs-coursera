package module10;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

public class RangeSearchVisualizer {

  public static void main(String[] args) {

    // initialize the data structures from file
    String filename = args[0];
    In in = new In(filename);
//    PointSET brute = new PointSET();
    KdTree kdtree = new KdTree();
    while (!in.isEmpty()) {
      double x = in.readDouble();
      double y = in.readDouble();
      Point2D p = new Point2D(x, y);
      kdtree.insert(p);
    }
    StdDraw.setCanvasSize(500, 500);
    kdtree.draw();
    StdDraw.show();
  }
}