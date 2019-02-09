package cci;

import org.junit.Test;

import static cci.DavisStaircase.stepPerms;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DavisStaircaseTest {

    @Test
    public void findDavisStaircase() {
        assertThat(stepPerms(5), is(13));
    }
}
