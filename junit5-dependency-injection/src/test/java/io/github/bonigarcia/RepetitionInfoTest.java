
package io.github.bonigarcia;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

class RepetitionInfoTest {

    @RepeatedTest(2)
    void test(RepetitionInfo repetitionInfo) {
        System.out.println("** Test " + repetitionInfo.getCurrentRepetition()
                + "/" + repetitionInfo.getTotalRepetitions());
    }

}
