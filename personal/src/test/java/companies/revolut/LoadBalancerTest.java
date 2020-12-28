package companies.revolut;

import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class LoadBalancerTest {

    private LoadBalancer loadBalancer;
    private Random random;

    @Before
    public void setUp() throws Exception {
        loadBalancer = new LoadBalancer(2, null);
        loadBalancer.register(new URL("http://service1.com"));
        loadBalancer.register(new URL("http://service2.com"));
    }

    @Test
    public void register() {
        assertThat(loadBalancer.getUrls().size(), is(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkRegisterCapacity() throws MalformedURLException {
        loadBalancer.register(new URL("http://service1.com"));
    }

    @Test (expected = IllegalStateException.class)
    public void registerUniqueProviders() throws MalformedURLException {
        loadBalancer = new LoadBalancer(2, null);
        loadBalancer.register(new URL("http://service1.com"));
        loadBalancer.register(new URL("http://service1.com"));
    }

    @Test
    public void getRandomProvider() throws MalformedURLException {
        random = new Random(1);
        loadBalancer = new LoadBalancer(2, random);
        loadBalancer.register(new URL("http://service1.com"));
        loadBalancer.register(new URL("http://service2.com"));

        assertThat(loadBalancer.get(), is(new URL("http://service2.com")));
        assertThat(loadBalancer.get(), is(new URL("http://service1.com")));
    }
}
