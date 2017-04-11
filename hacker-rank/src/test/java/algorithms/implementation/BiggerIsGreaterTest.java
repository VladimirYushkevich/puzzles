package algorithms.implementation;

import org.junit.Test;

import static algorithms.implementation.BiggerIsGreater.nextPermutation;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BiggerIsGreaterTest {

    @Test
    public void testNextPermutation() throws Exception {
        assertThat(nextPermutation("ab"), is("ba"));
        assertThat(nextPermutation("bb"), is("no answer"));
        assertThat(nextPermutation("hefg"), is("hegf"));
        assertThat(nextPermutation("dhck"), is("dhkc"));
        assertThat(nextPermutation("dkhc"), is("hcdk"));
        assertThat(nextPermutation("zyyxwwtrrnmlggfeb"), is("no answer"));
        assertThat(nextPermutation("zvtronmlkkihc"), is("no answer"));
        assertThat(nextPermutation("zzzyyyyxxxxwwwwwvvuuuuuuuttttsssrrrqqqqpppooooonnnnmmmllkjjjjiiiiihhhgggfeeeddcccbbbaa"), is("no answer"));
        assertThat(nextPermutation("zzyyxxxwwwwvvvvuuuutrrqqqqppoooonnmmllkkkjjjiihhhggfffeeebbbbbbbbb"), is("no answer"));
        assertThat(nextPermutation("c"), is("no answer"));
        assertThat(nextPermutation("rnkg"), is("no answer"));
        assertThat(nextPermutation("iv"), is("vi"));
        assertThat(nextPermutation("zalqxykemvzzgaka"), is("zalqxykemvzzgkaa"));
        assertThat(nextPermutation("pk"), is("no answer"));
    }
}
