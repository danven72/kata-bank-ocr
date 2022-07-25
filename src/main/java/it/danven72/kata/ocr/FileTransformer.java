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
    //private NumbersRow numberRows = new NumbersRow();

    public void transform(String pathAndFileName) throws Exception {
        URI res = ClassLoader.getSystemResource(pathAndFileName).toURI();
        try (
                Stream<String> stream = Files.lines(Paths.get(res), StandardCharsets.UTF_8)
        ) {
            List<String> rowList = stream.toList();
            int rowCounter =0;
            NumbersRow numberRows = new NumbersRow();
            for (int i=0; i<rowList.size(); i++) {
                System.out.println("i:"+ i +" rowCounter:" + rowCounter + " -> "+rowList.get(i));
                numberRows.parseRow(rowCounter, rowList.get(i));
                ++rowCounter;
                if (rowCounter==4) {
                    System.out.println(numberRows.getOutputWithValidation(numberRows.getSimpleOutput()));
                    numberRows.reset(); //= new NumbersRow();
                    rowCounter = 0;
                }
            }
            //System.out.println(numberRows.getSimpleOutput());
            //System.out.println(numberRows.getOutputWithValidation(numberRows.getSimpleOutput()));
        }
    }

    public static void main(String[] args) throws Exception {
        FileTransformer ft = new FileTransformer();
        ft.transform("input_files/allNumber.txt");
    }
}
