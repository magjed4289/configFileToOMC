package omc;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileParser {

    public static void main(String[] args) {

        try (BufferedReader br = Files.newBufferedReader(Paths.get("src/main/resources/input.config"))) {

            String sCurrentLine;
            StringBuilder params = new StringBuilder();

            while ((sCurrentLine = br.readLine()) != null) {
                String param = sCurrentLine;
                String changeQuotes = param.replace("\"","&quot;");
                String changeSingulars = changeQuotes.replace("'","&lsquo;");
                String addLineSeparator = changeSingulars + "${line.separator}";

                param = addLineSeparator.trim();

                params.append(param);
            }

            System.out.println(params);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
