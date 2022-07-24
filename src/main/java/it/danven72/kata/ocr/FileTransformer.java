package it.danven72.kata.ocr;

import it.danven72.kata.ocr.model.NumbersRow;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileTransformer {
    private NumbersRow numberRows = new NumbersRow();

    public void transform(String pathAndFileName) throws Exception {
        URI res = ClassLoader.getSystemResource(pathAndFileName).toURI();
        try (
                Stream<String> stream = Files.lines(Paths.get(res), StandardCharsets.UTF_8)
        ) {
            List<String> rowList = stream.toList();
            for (int i=0; i<rowList.size(); i++) {
                numberRows.parseRow(i, rowList.get(i));
            }
            //System.out.println(numberRows.getSimpleOutput());
            System.out.println(numberRows.getOutputWithValidation(numberRows.getSimpleOutput()));
        }
    }

    public static void main(String[] args) throws Exception {
        FileTransformer ft = new FileTransformer();
        ft.transform("input_files/allNumber.txt");
    }
}
