package commons;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTest {
    private static final String FILE_NAME_FORMAT = "%s/%s_%s";

    protected BaseTest() {
    }

    protected List<String> getParameters(String path, String type, int testId) throws IOException {
        List<String> inputs = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(getFile(path, type, testId)))) {
            String line = br.readLine();
            inputs.add(line);

            while (line != null) {
                line = br.readLine();
                inputs.add(line);
            }
        }

        return inputs;
    }

    private File getFile(String path, String type, int testId) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(String.format(FILE_NAME_FORMAT, path, type, testId));
        assert resource != null;
        return new File(resource.getPath());
    }
}
