package fes.aragon.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FontFileReader {

    private static final List<String> sources = new ArrayList<>();
    private static final String FILENAME = "fuente.txt";

    public static List<String> getSourceFromFile() throws IOException {

        File file = new File(FontFileReader.FILENAME);
        Path path = file.toPath();
        sources.addAll(Files.readAllLines(path));

        if(sources.isEmpty()){
            throw new IOException("Source Empty");
        }

        return sources;
    }


}
