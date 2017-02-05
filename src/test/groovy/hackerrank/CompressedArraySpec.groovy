package hackerrank

import hackerrank.tendaysofstats.DayOneInterquartileRange
import spock.lang.Specification

class CompressedArraySpec extends Specification {

    void "array expand"() {
        setup:
        TreeMap<Integer, Integer> treeMap = new TreeMap<>([6: 5, 12: 4, 8: 3, 10: 2, 20: 1, 16: 5])
        def clazz = new DayOneInterquartileRange.CompressedArray(treeMap)

        expect:
        clazz.get(n) == i

        where:
        n  | i
        0  | 6
        1  | 6
        4  | 6
        5  | 8
        6  | 8
        10 | 12
        18 | 16
        19 | 20

    }

}
