package cscie55.hw7.problem4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramMapper {
    public static void main(String argv[]) {
        // grabs filename from cmd line or run configuration
        // currently set up to use "src\\main\\resources\\anagram-data.txt" as input
        // use "target\\output.txt" as output
        // using windows syntax
        String inputFile = argv[0];
        String outputFile = argv[1];
        Map<String, List<String>> anagramMap = new HashMap<>();

        try (Stream<String> lines = Files.lines(Paths.get(inputFile), StandardCharsets.UTF_8);
             BufferedWriter out = Files.newBufferedWriter(Paths.get(outputFile),
                     StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
        ) {
            // use input stream to create k, v pairs
            // anagrams will have a list length > 1
            List<String> cleanStrings = lines.map(line -> line.toLowerCase()).distinct().collect(Collectors.toList());

            cleanStrings.forEach(line -> {
                String keyString = line.replaceAll("[^a-zA-Z]", "")
                        .replaceAll("\\s", "")
                        .chars() // get chars
                        .sorted() // sort chars
                        .mapToObj(i -> (char) i) // convert to char
                        .map(String::valueOf)  // convert to String
                        .collect(Collectors.joining()); // join to a String

                List<String> newList = new ArrayList<>();
                newList.add(line);
                if (anagramMap.containsKey(keyString)) {
                    newList = anagramMap.get(keyString);
                    newList.add(line);
                }
                anagramMap.put(keyString, newList);
            });

            // if an entry is an anagram, write to file
            anagramMap.forEach((k, v) -> {
                if (v.size() > 1) {
                    try {
                        out.write(k + ", " + v + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        catch (UncheckedIOException | IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
