package module10;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;
import java.util.ArrayList;
import java.util.TreeSet;

public class PointSET {

  private TreeSet<Point2D> set;

  // construct an empty set of points
  public PointSET() {
    set = new TreeSet<>();
  }

  // is the set empty?
  public boolean isEmpty() {
    return set.isEmpty();
  }

  // number of points in the set
  public int size() {
    return set.size();
  }

  // add the point to the set (if it is not already in the set)
  public void insert(Point2D p) {
    if (p == null) {
      throw new IllegalArgumentException();
    }
    set.add(p);
  }

  // does the set contain point p?
  public boolean contains(Point2D p) {
    if (p == null) {
      throw new IllegalArgumentException();
    }
    return set.contains(p);
  }

  // draw all points to standard draw
  public void draw() {
    StdDraw.setPenRadius(0.008);
    for (Point2D p : set) {
      StdDraw.point(p.x(), p.y());
    }
  }

  // all points that are inside the rectangle (or on the boundary)
  public Iterable<Point2D> range(RectHV rect) {
    if (rect == null) {
      throw new IllegalArgumentException();
    }
    final var list = new ArrayList<Point2D>();
    for (var p : set) {
      if (isInRect(p, rect)) {
        list.add(p);
      }
    }
    return list;
  }

  private boolean isInRect(Point2D p, RectHV rect) {
    return (p.x() >= rect.xmin() && p.x() <= rect.xmax()) &&
        (p.y() >= rect.ymin() && p.y() <= rect.ymax());
  }

  // a nearest neighbor in the set to point p; null if the set is empty
  public Point2D nearest(Point2D p) {
    if (p == null) {
      throw new IllegalArgumentException();
    }
    if (isEmpty()) {
      return null;
    }
    Point2D nearest = set.first();
    double minD = nearest.distanceSquaredTo(p);
    for (var point : set) {
      double dist = point.distanceSquaredTo(p);
      if (dist < minD) {
        nearest = point;
        minD = dist;
      }
    }
    return nearest;
  }

  // unit testing of the methods (optional)
  public static void main(String[] args) {
    PointSET set = new PointSET();
    set.insert(new Point2D(0.1, 0.4));
    set.insert(new Point2D(0.05, 0.1));
    set.insert(new Point2D(0.6, 0.5));
    set.draw();
    StdDraw.rectangle(0.6, 0.45, 0.2, 0.15);

    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.setPenRadius(0.003);
    StdDraw.line(0.7, 0, 0.7, 1);
    System.out.println(set.range(new RectHV(0.4, 0.3, 0.8, 0.6)));
    System.out.println(set.nearest(new Point2D(0.9, 0.9)));
  }
}