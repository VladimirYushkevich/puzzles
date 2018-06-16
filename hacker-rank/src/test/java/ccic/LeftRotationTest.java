package ccic;

import ccic.LeftRotation;
import org.junit.Test;

public class LeftRotationTest {

    @Test
    public void testLeftRotations() {
        LeftRotation.rotateAndPrint(new int[]{1, 2, 3, 4, 5}, 5, 5);
        System.out.println();
        LeftRotation.rotateAndPrint(new int[]{1, 2, 3, 4, 5}, 5, 4);
        System.out.println();
        LeftRotation.rotateAndPrint(new int[]{1, 2, 3, 4, 5}, 5, 3);
        System.out.println();
    }
}
