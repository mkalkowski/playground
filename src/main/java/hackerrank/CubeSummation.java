package hackerrank;

import java.util.*;

public class CubeSummation {
    private Scanner scanner;

    public static void main(String[] args) {

        new CubeSummation().run();
    }

    private void run() {
        this.scanner = new Scanner(System.in);
        int tests = Integer.parseInt(scanner.nextLine());
        while (tests-- != 0) {
            runTest();
        }
    }

    private void runTest() {
        String[] args = scanner.nextLine().split(" ");
        int commands = Integer.parseInt(args[1]);

        KDTree kdTree = new KDTree(3);
        while (commands-- != 0) {
            String line = scanner.nextLine();
            String[] n = line.split(" ");
            if (line.startsWith("QUERY")) {
                kdTree.query(
                        Arrays.asList(Integer.parseInt(n[1]), Integer.parseInt(n[2]), Integer.parseInt(n[3])),
                        Arrays.asList(Integer.parseInt(n[4]), Integer.parseInt(n[5]), Integer.parseInt(n[6])));

            } else { // UPDATE
                Point point = new Point(
                        Integer.parseInt(n[1]),
                        Integer.parseInt(n[2]),
                        Integer.parseInt(n[3]),
                        Long.parseLong(n[4]));
                kdTree.insert(point);
            }
        }
    }


//    private void run2() {
//
//        KDTree tree = new KDTree(2);
//        tree.insert(new Point(2, 1, 3));
//        tree.insert(new Point(1, 1, 4));
//        tree.insert(new Point(4, 3, 5));
//        tree.insert(new Point(3, 1, 6));
//        tree.insert(new Point(6, 6, 7));
//        tree.insert(new Point(1, 4, 8));
//        tree.insert(new Point(0, 0, 9));
//
////        tree.rebalance();
//
//        tree.insert(new Point(1, 1, 82));
//        tree.print();
//        tree.query(Arrays.asList(0, 0), Arrays.asList(3, 3));
//    }

    class KDTree { // K-d tree

        private final int n;
        private Point root;


        public KDTree(int n) {
            this.n = n;
        }

        void insert(Point point) {
            if (root == null) {
                root = point;
                return;
            }
            int dimension = 0;

            Point current = root;
            do {
                if (point.coordinateEquals(current)) {

                    current.w = point.w;
                    break;
                }

                point.level = (point.level+1)%n;

                if (point.dimension(dimension) < current.dimension(dimension)) {
                    if (current.left == null) {
                        current.left = point;
                        break;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.right == null) {
                        current.right = point;
                        break;
                    } else {
                        current = current.right;
                    }
                }
                dimension = (dimension + 1) % n;
            } while (true);
        }

        void rebalance() {

            List<Point> points = allPoints();
            root = buildTree(points, 0);

        }

        private List<Point> allPoints() {
            LinkedList<Point> stack = new LinkedList<>();
            LinkedList<Point> result = new LinkedList<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                Point p = stack.remove();
                result.add(p);
                if (p.left!= null) stack.add(p.left);
                if (p.right != null) stack.add(p.right);
            }
            return result;
        }


        private Point buildTree(List<Point> points, int dimension) {
            if (points.size() == 1) {
                return points.iterator().next();
            } else if (points.isEmpty()) {
                return null;
            }

            Collections.sort(points, (p1, p2) ->
                    p1.dimension(dimension) - p2.dimension(dimension));
            int medianIdx = points.size() / 2;
            Point median = points.get(medianIdx);

            median.left = buildTree(points.subList(0, medianIdx), (dimension+1)%n);
            median.right = buildTree(points.subList(medianIdx+1, points.size()), (dimension+1)%n);

            return median;
        }

        public long query(List<Integer> min, List<Integer> max) {

            ArrayList<Point> results = new ArrayList<>();
            LinkedList<Point> stack = new LinkedList<>();

            stack.add(root);
            while (root !=null && !stack.isEmpty()) {
                Point p = stack.remove();
                if (p.isInRange(min, max)) {
                    results.add(p);
                }

                if (p.left!= null && p.isLeftOfInterest(min, max)) stack.add(p.left);
                if (p.right != null && p.isRightOfInterest(min, max)) stack.add(p.right);
            }

            long sum = results.stream().mapToLong(p -> p.w).sum();
            System.out.println(sum);
            return  sum;
        }

        public void print() {
            print(root, "");
        }

        private void print(Point point, String indent) {
            System.out.println(indent + " := " + point);
            if (point.left != null) print(point.left, indent + '\t');
            if (point.right != null) print(point.right, indent + '\t');
        }
    }

    class Point {
        List<Integer> dim;
        private long w;

        private Point left, right;
        public int level;

        Point(int x, int y, int w) {
            this.dim = Arrays.asList(x, y);
            this.w = w;
        }
        Point(int x, int y, int z, long w) {
            this.dim = Arrays.asList(x, y, z);
            this.w = w;
        }

        boolean coordinateEquals(Point point) {
            return dim.equals(point.dim);
        }

        int dimension(int d) {
            return dim.get(d);
        }

        @Override
        public String toString() {
            return w + " | " + level + " | " + dim.toString();
        }

        public boolean isInRange(List<Integer> min, List<Integer> max) {

            for (int i = 0; i < dim.size(); i++) {
                if (!((dim.get(i) >= min.get(i)) && (dim.get(i)) <= max.get(i))) {
                    return false;
                }
            }
            return true;
        }

        public boolean isLeftOfInterest(List<Integer> min, List<Integer> max) {

            int coord = dimension(level);
            int coordMin = min.get(level);
            int coordMax = max.get(level);

            return Math.min(coordMin, coordMax) <= coord;
        }

        public boolean isRightOfInterest(List<Integer> min, List<Integer> max) {

            int coord = dimension(level);
            int coordMin = min.get(level);
            int coordMax = max.get(level);

            return Math.max(coordMin, coordMax) >= coord;
        }
    }



}
