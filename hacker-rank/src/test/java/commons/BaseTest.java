package commons;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public abstract class BaseTest {
    private static final String FILE_NAME_FORMAT = "algorithms/warmup/%s_%s";

    protected BaseTest() {
    }

    protected abstract List<String> getParameters(File file) throws IOException;

    protected File getFile(String type, int testId) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(String.format(FILE_NAME_FORMAT, type, testId));
        assert resource != null;
        return new File(resource.getPath());
    }
}
