import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * TODO
 *
 * @author ahao 2020-08-19
 */
public class fileTest {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\studyworkspace\\mesql\\src\\main\\java\\Enity\\ahao.java");
        String content = "class ahao{\n" +
                "    \n" +
                "}";

        Files.write(path,content.getBytes("utf-8"));
    }
}
