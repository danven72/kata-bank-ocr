package it.danven72.kata.ocr.model;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class NumbersRow {
    private NumberElement[] numberElements = new NumberElement[9];

    public NumbersRow() {
        reset();
    }

    public void parseRow(int rowIndex, String row) {
        if (row.length() !=0) {
            if (row.length() != 27)
                throw new IllegalArgumentException("Row length " + row.length() + " not valid: row length must be 27!");
            int elemNumber = 0;
            while (row.length() >= 3) {
                String chunk = row.substring(0, 3);
                //System.out.println("["+chunk+"]");
                row = row.substring(chunk.length());

                numberElements[elemNumber].add(rowIndex, chunk);
                ++elemNumber;
            }
        }
    }

    public NumberElement getNumberElementAt(int index) {
        return numberElements[index];
    }

    public String getSimpleOutput() {
        StringBuilder sb = new StringBuilder();
        sb.append("Account number: ");
        for (int i=0; i< numberElements.length; i++) {
            if (numberElements[i].getNumberValue() == -1) {
                sb.append("?");
            }
            else {
                sb.append(numberElements[i].getNumberValue());
            }
            sb.append("  ");
        }

        return sb.toString();
    }

    public String getOutputWithValidation(String rowOutput) {
        StringBuilder sb = new StringBuilder(rowOutput);
        if (sb.indexOf("?") != -1) {
            sb.append("ILL");
        }
        else if (!isCheckSumValid()) {
            sb.append("ERR");
        }

        return sb.toString();
    }

    private boolean isCheckSumValid() {
        int wightedSum = 0;
        for (int i=0; i< numberElements.length; i++) {
            if (numberElements[i].getNumberValue() == -1) {
                throw new IllegalStateException("Can't calculate weight sum: number not recognized: \n" + numberElements[i].toString());
            }
            else {
                int factor = numberElements.length - i;
                wightedSum +=  numberElements[i].getNumberValue()*factor;
            }
        }
        return (wightedSum % 11) == 0;
    }

    public List<String> transformFile(String pathAndFileName) throws Exception {
        URI res = ClassLoader.getSystemResource(pathAndFileName).toURI();
        List<String> result = new ArrayList<>();
        try (
                Stream<String> stream = Files.lines(Paths.get(res), StandardCharsets.UTF_8)
        ) {
            List<String> rowList = stream.toList();
            for (int i=0; i<rowList.size(); i++) {
                parseRow(i, rowList.get(i));
            }
            //System.out.println(numberRows.getSimpleOutput());
            result.add((getOutputWithValidation(getSimpleOutput())));
        }
        return result;
    }

    public void reset() {
        for (int i=0; i< numberElements.length; i++) {
            numberElements[i] = new NumberElement();
        }
    }


    public static void main(String[] args) {
        NumbersRow nr = new NumbersRow();
        nr.parseRow(0, "    _  _     _  _  _  _  _ ");
        nr.parseRow(1, "  | _| _||_||_ |_   ||_||_|");
        nr.parseRow(2, "  ||_  _|  | _||_|  ||_| _|");
        for (int i=0; i< nr.numberElements.length;i++) {
            System.out.println(nr.numberElements[i]);
        }
        //System.out.println("Is fourth element a four: " + nr.numberElements[3].equals(NumberElement.FOUR));

        System.out.println(nr.getSimpleOutput());
    }
}
