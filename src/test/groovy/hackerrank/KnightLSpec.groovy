package hackerrank

import spock.lang.Specification

class KnightLSpec extends Specification {

    void testMerge() {
        expect:
        def k = new KnightL.Knight(i, j, n)
        k.shortestPath() == path

        where:
        i  | j  | n || path
        1  | 1  | 2 || 1
        1  | 1  | 3 || 2
        1  | 1  | 4 || 3
        1  | 1  | 5 || 4
        1  | 1  | 6 || 5
        1  | 1  | 7 || 6
        2  | 1  | 5 || 4
        3  | 1  | 5 || 2

    }

}
