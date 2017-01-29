package hackerrank

import spock.lang.Specification

class MergeResultSpec extends Specification {

    static mr = new AlgoCrush.MergeResult();

    void testMerge() {
        expect:
        mr.add(a, b, k)
        mr.resolveMax() == max

        where:
        a  | b  | k || max
        3  | 10 | 1 || 1
        1  | 5  | 1 || 2
        5  | 5  | 1 || 3
        3  | 3  | 2 || 4
        3  | 4  | 1 || 5
        -1 | 12 | 1 || 6
        14 | 15 | 10|| 10

    }

}
