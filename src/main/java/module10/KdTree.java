package module10;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;
import java.util.ArrayList;
import java.util.List;

public class KdTree {

  private Node root;
  private int size;

  // construct an empty set of points
  public KdTree() {
  }

  // is the set empty?
  public boolean isEmpty() {
    return root == null && size == 0;
  }

  // number of points in the set
  public int size() {
    return size;
  }

  // add the point to the set (if it is not already in the set)
  public void insert(Point2D p) {
    if (p == null) {
      throw new IllegalArgumentException();
    }
    if (contains(p)) {
      return;
    }
    if (root == null) {
      root = new Node(p, true);
    } else {
      insertRec(p, root);
    }
    size++;
  }

  private void insertRec(Point2D p, Node n) {
    if (n == null) {
      return;
    }
    if (n.isVertical) {
      if (p.x() < n.p.x()) {
        if (n.left == null) {
          n.left = new Node(p, false);
        } else {
          insertRec(p, n.left);
        }
      } else {
        if (n.right == null) {
          n.right = new Node(p, false);
        } else {
          insertRec(p, n.right);
        }
      }
    } else {
      if (p.y() < n.p.y()) {
        if (n.left == null) {
          n.left = new Node(p, true);
        } else {
          insertRec(p, n.left);
        }
      } else {
        if (n.right == null) {
          n.right = new Node(p, true);
        } else {
          insertRec(p, n.right);
        }
      }
    }
  }

  // does the set contain point p?
  public boolean contains(Point2D p) {
    if (p == null) {
      throw new IllegalArgumentException();
    }
    if (root == null) {
      return false;
    }
    return containsRec(p, root);
  }

  private boolean containsRec(Point2D p, Node n) {
    if (n.p.equals(p)) {
      return true;
    }
    if (n.isVertical) {
      if (p.x() < n.p.x()) {
        if (n.left == null) {
          return false;
        } else {
          return containsRec(p, n.left);
        }
      } else {
        if (n.right == null) {
          return false;
        } else {
          return containsRec(p, n.right);
        }
      }
    } else {
      if (p.y() < n.p.y()) {
        if (n.left == null) {
          return false;
        } else {
          return containsRec(p, n.left);
        }
      } else {
        if (n.right == null) {
          return false;
        } else {
          return containsRec(p, n.right);
        }
      }
    }
  }

  // draw all points to standard draw
  public void draw() {
    drawRec(root, 0, 0, 1, 1);
  }

  private void drawRec(Node n, double fromX, double fromY, double toX, double toY) {
    if (n == null) {
      return;
    }
    drawLineAndDot(n, fromX, fromY, toX, toY);

    if (n.isVertical) {
      if (n.left != null) {
        drawRec(n.left, fromX, fromY, n.p.x(), toY);
      }
      if (n.right != null) {
        drawRec(n.right, n.p.x(), fromY, toX, toY);
      }
    } else {
      if (n.left != null) {
        drawRec(n.left, fromX, fromY, toX, n.p.y());
      }
      if (n.right != null) {
        drawRec(n.right, fromX, n.p.y(), toX, toY);
      }
    }
  }

  private void drawLineAndDot(Node n, double fromX, double fromY, double toX, double toY) {
    if (n.isVertical) {
      StdDraw.setPenRadius(0.0005);
      StdDraw.setPenColor(0, 0, 255);
      StdDraw.line(n.p.x(), fromY, n.p.x(), toY);
      StdDraw.setPenRadius(0.005);
      StdDraw.setPenColor(0, 0, 0);
      n.p.draw();
    } else {
      StdDraw.setPenRadius(0.0005);
      StdDraw.setPenColor(255, 0, 0);
      StdDraw.line(fromX, n.p.y(), toX, n.p.y());
      StdDraw.setPenRadius(0.005);
      StdDraw.setPenColor(0, 0, 0);
      n.p.draw();
    }
  }

  // all points that are inside the rectangle (or on the boundary)
  public Iterable<Point2D> range(RectHV rect) {
    if (rect == null) {
      throw new IllegalArgumentException();
    }
    return rangeRec(root, rect, new RectHV(0, 0, 1, 1));
  }

  private Iterable<Point2D> rangeRec(Node n, RectHV queryRect, RectHV rect) {
    if (!rectIntersect(queryRect, rect)) {
      return new ArrayList<>();
    }
    var list = new ArrayList<Point2D>();
    if (isInRect(n.p, queryRect)) {
      list.add(n.p);
    }
    if (n.isVertical) {
      if (n.left != null) {
        list.addAll(iterableToList(rangeRec(n.left, queryRect,
            new RectHV(rect.xmin(), rect.ymin(), n.p.x(), rect.ymax()))));
      }
      if (n.right != null) {
        list.addAll(iterableToList(rangeRec(n.right, queryRect,
            new RectHV(n.p.x(), rect.ymin(), rect.xmax(), rect.ymax()))));
      }
    } else {
      if (n.left != null) {
        list.addAll(iterableToList(rangeRec(n.left, queryRect,
            new RectHV(rect.xmin(), rect.ymin(), rect.xmax(), n.p.y()))));
      }
      if (n.right != null) {
        list.addAll(iterableToList(rangeRec(n.right, queryRect,
            new RectHV(rect.xmin(), n.p.y(), rect.xmax(), rect.ymax()))));
      }
    }
    return list;
  }

  // a nearest neighbor in the set to point p; null if the set is empty
  public Point2D nearest(Point2D p) {
    if (p == null) {
      throw new IllegalArgumentException();
    }
    return nearestRec(p, root, new RectHV(0, 0, 1, 1), root.p);
  }

  private Point2D nearestRec(Point2D p, Node n, RectHV rect, Point2D nearest) {
    if (n == null) {
      return nearest;
    }

    if (p.distanceSquaredTo(nearest) > p.distanceSquaredTo(n.p)) {
      nearest = n.p;
    }

    if (n.isVertical) {
      RectHV leftRect = new RectHV(rect.xmin(), rect.ymin(), n.p.x(), rect.ymax());
      RectHV rightRect = new RectHV(n.p.x(), rect.ymin(), rect.xmax(), rect.ymax());

      if (p.x() < n.p.x()) {
        nearest = nearestRec(p, n.left, leftRect, nearest);
        if (rightRect.distanceSquaredTo(p) < p.distanceSquaredTo(nearest)) {
          nearest = nearestRec(p, n.right, rightRect, nearest);
        }
      } else {
        nearest = nearestRec(p, n.right, rightRect, nearest);
        if (leftRect.distanceSquaredTo(p) < p.distanceSquaredTo(nearest)) {
          nearest = nearestRec(p, n.left, leftRect, nearest);
        }
      }
    } else {
      RectHV bottomRect = new RectHV(rect.xmin(), rect.ymin(), rect.xmax(), n.p.y());
      RectHV topRect = new RectHV(rect.xmin(), n.p.y(), rect.xmax(), rect.ymax());

      if (p.y() < n.p.y()) {
        nearest = nearestRec(p, n.left, bottomRect, nearest);
        if (topRect.distanceSquaredTo(p) < p.distanceSquaredTo(nearest)) {
          nearest = nearestRec(p, n.right, topRect, nearest);
        }
      } else {
        nearest = nearestRec(p, n.right, topRect, nearest);
        if (bottomRect.distanceSquaredTo(p) < p.distanceSquaredTo(nearest)) {
          nearest = nearestRec(p, n.left, bottomRect, nearest);
        }
      }
    }

    return nearest;
  }


  private List<Point2D> iterableToList(Iterable<Point2D> iterable) {
    List<Point2D> list = new ArrayList<>();
    iterable.forEach(list::add);
    return list;
  }

  private boolean rectIntersect(RectHV r1, RectHV r2) {
    if (r1.xmax() < r2.xmin() || r2.xmax() < r1.xmin()) {
      return false;
    }
    if (r1.ymax() < r2.ymin() || r2.ymax() < r1.ymin()) {
      return false;
    }
    return true;
  }

  private boolean isInRect(Point2D p, RectHV rect) {
    return (p.x() >= rect.xmin() && p.x() <= rect.xmax()) &&
        (p.y() >= rect.ymin() && p.y() <= rect.ymax());
  }

  private static class Node {

    Point2D p;
    boolean isVertical;
    Node left, right;

    public Node(Point2D p, boolean isVertical) {
      this.p = p;
      this.isVertical = isVertical;
    }
  }


  // unit testing of the methods (optional)
  public static void main(String[] args) {
//    PointSET set = new PointSET();
//    set.insert(new Point2D(0.1, 0.4));
//    set.insert(new Point2D(0.05, 0.1));
//    set.insert(new Point2D(0.6, 0.5));
//    set.draw();
//    StdDraw.rectangle(0.6, 0.45, 0.2, 0.15);
//
//    StdDraw.setPenColor(StdDraw.RED);
//    StdDraw.setPenRadius(0.003);
//    StdDraw.line(0.7, 0, 0.7, 1);
//    System.out.println(set.range(new RectHV(0.4, 0.3, 0.8, 0.6)));
//    System.out.println(set.nearest(new Point2D(0.9, 0.9)));
    KdTree tree = new KdTree();
    tree.insert(new Point2D(0.7, 0.2));
    tree.insert(new Point2D(0.5, 0.4));
    tree.insert(new Point2D(0.2, 0.3));
    tree.draw();
  }
}
