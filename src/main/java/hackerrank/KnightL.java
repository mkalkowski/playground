package hackerrank;

import java.util.*;
import java.util.stream.Collectors;

public class KnightL {

    public static void main(String[] args) {

        final int n = new Scanner(System.in).nextInt();

        for (int i=1; i<n; i++) {
            List<String> ints = new LinkedList<>();
            for (int j=1; j<n; j++) {
                ints.add(Integer.toString(new Knight(i, j, n).shortestPath()));
            }
            System.out.println(String.join(" ", ints));
        }
    }

    static class Knight {
        int n;
        int i,j;
        Set<Position> visited = new HashSet<>(n*n);

        public Knight(int x, int y, int n) {
            this.i = x;
            this.j = y;
            this.n = n;
        }

        public Set<Position> steps(Position p) {
            return new HashSet<>(Arrays.asList(
                new Position(p.x + i, p.y + j),
                new Position(p.x + j, p.y + i),
                new Position(p.x - i, p.y + j),
                new Position(p.x - j, p.y + i),
                new Position(p.x - i, p.y - j),
                new Position(p.x - j, p.y - i),
                new Position(p.x + i, p.y - j),
                new Position(p.x + j, p.y - i))).
                    stream().
                    filter(a -> {
                        if (a.x < 0 || a.y < 0 || a.x >=n || a.y>=n) return false;
                        return true;
                    }).
                    collect(Collectors.toSet());
        }
        public int shortestPath() {
            return shortestPath(new Position(0, 0), new Position(n - 1, n - 1));
        }

        private int shortestPath(Position start, Position end) {
            LinkedList<Position> queue = new LinkedList<>();

            start.distance = 0;
            queue.add(start);
            visited.add(start);

            while (!queue.isEmpty()) {

                Position s = queue.poll();
//                System.out.print(s+" ");

                Set<Position> adjacent = steps(s);
                adjacent.removeAll(visited);
//                System.out.println(adjacent);
                if (adjacent.contains(end)) {
                    return s.distance + 1;
                }
                for (Position adj : adjacent) {
                    queue.add(adj);
                    adj.distance =  s.distance + 1;
                    visited.add(adj);
                }

            }
            return -1;
        }
    }

    static class Position {
        int x,y,distance;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
            distance = 0;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", x, y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            if (x != position.x) return false;
            return y == position.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
