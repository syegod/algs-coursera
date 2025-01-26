package module10;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

public class KdTreeVisualizer {

  public static void main(String[] args) {
    RectHV rect = new RectHV(0.0, 0.0, 1.0, 1.0);
    StdDraw.show();
    StdDraw.enableDoubleBuffering();
    KdTree kdtree = new KdTree();
    while (true) {
      if (StdDraw.isMousePressed()) {
        double x = StdDraw.mouseX();
        double y = StdDraw.mouseY();
        Point2D p = new Point2D(x, y);
        if (rect.contains(p)) {
          kdtree.insert(p);
          StdDraw.clear();
          kdtree.draw();
          StdDraw.show();
        }
      }
      StdDraw.pause(100);
    }

  }
}