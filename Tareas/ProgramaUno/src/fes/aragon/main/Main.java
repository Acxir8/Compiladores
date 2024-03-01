package fes.aragon.main;

import fes.aragon.files.FontFileReader;
import fes.aragon.program.Core;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> sources = FontFileReader.getSourceFromFile();
            Core core = new Core(sources);
            List<Boolean> results = core.resolveSources();

            IntStream.range(0, results.size()).forEach(index -> {
                System.out.print(sources.get(index));
                if (results.get(index)) {
                    System.out.print(" -> Valid\n");
                } else {
                    System.out.print(" -> Invalid\n");
                }
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}