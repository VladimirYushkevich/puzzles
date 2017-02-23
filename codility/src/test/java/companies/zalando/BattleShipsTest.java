package companies.zalando;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BattleShipsTest {

    private BattleShips battleShips;

    @Before
    public void setUp() throws Exception {
        battleShips = new BattleShips();
    }

    @Test
    public void testBattleShips() throws Exception {
        assertThat(battleShips.solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A"), is("1,1"));
        assertThat(battleShips.solution(3, "1A 1B,2C 2C", "1B"), is("0,1"));
        assertThat(battleShips.solution(12, "1A 2A,12A 12A", "12A"), is("1,0"));
    }
}
