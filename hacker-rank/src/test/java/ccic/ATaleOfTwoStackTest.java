package ccic;

import ccic.ATaleOfTwoStack;
import org.junit.Test;

import static junit.framework.TestCase.assertNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ATaleOfTwoStackTest {

    @Test
    public void testQueue() {
        ATaleOfTwoStack.MyQueue<Integer> queue = new ATaleOfTwoStack.MyQueue<>();
        queue.enqueue(42);
        assertThat(queue.peek(), is(42));

        queue.dequeue();
        assertNull(queue.peek());

        queue.enqueue(14);
        assertThat(queue.peek(), is(14));

        queue.enqueue(28);
        assertThat(queue.peek(), is(14));

        queue.enqueue(60);
        queue.enqueue(78);

        queue.dequeue();
        assertThat(queue.peek(), is(28));

        queue.dequeue();
        assertThat(queue.peek(), is(60));
    }
}
