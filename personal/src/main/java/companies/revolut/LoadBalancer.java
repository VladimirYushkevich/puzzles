package companies.revolut;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoadBalancer {

    private final int capacity;
    private final Random random;
    private final List<URL> urls = new ArrayList<>();

    public LoadBalancer(int capacity, Random random) {
        this.capacity = capacity;
        this.random = random;
    }

    public void register(URL url) {
        if (urls.size() == capacity) {
            throw new IllegalArgumentException(String.format("Number of registered providers restrivted by %s", capacity));
        }
        if (urls.contains(url)) {
            throw new IllegalStateException("LB supports only unique providers");
        }
        urls.add(url);
    }

    public List<URL> getUrls() {
        return urls;
    }

    public URL get() {
        if (urls.isEmpty()) {
            throw new IllegalArgumentException("LB has no registered providers");
        }
        return urls.get(getNextIndex());
    }

    private int getNextIndex() {
        return random.nextInt(urls.size());
    }
}
