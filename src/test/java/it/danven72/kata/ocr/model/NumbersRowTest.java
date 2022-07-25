package it.danven72.kata.ocr.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NumbersRowTest {

    @Test
    void testParseRowAtrow0() {
        NumbersRow nr = new NumbersRow();
        nr.parseRow(0, "123321456654789987121323656");

        assertEquals("123", nr.getNumberElementAt(0).getValue(0));
        assertEquals("321", nr.getNumberElementAt(1).getValue(0));
        assertEquals("456", nr.getNumberElementAt(2).getValue(0));
        assertEquals("654", nr.getNumberElementAt(3).getValue(0));
        assertEquals("789", nr.getNumberElementAt(4).getValue(0));
        assertEquals("987", nr.getNumberElementAt(5).getValue(0));
        assertEquals("121", nr.getNumberElementAt(6).getValue(0));
        assertEquals("323", nr.getNumberElementAt(7).getValue(0));
        assertEquals("656", nr.getNumberElementAt(8).getValue(0));
    }

    @Test
    void testParseRowAtRow1() {
        NumbersRow nr = new NumbersRow();
        nr.parseRow(1, "123321456654789987121323656");

        assertEquals("123", nr.getNumberElementAt(0).getValue(1));
        assertEquals("321", nr.getNumberElementAt(1).getValue(1));
        assertEquals("456", nr.getNumberElementAt(2).getValue(1));
        assertEquals("654", nr.getNumberElementAt(3).getValue(1));
        assertEquals("789", nr.getNumberElementAt(4).getValue(1));
        assertEquals("987", nr.getNumberElementAt(5).getValue(1));
        assertEquals("121", nr.getNumberElementAt(6).getValue(1));
        assertEquals("323", nr.getNumberElementAt(7).getValue(1));
        assertEquals("656", nr.getNumberElementAt(8).getValue(1));
    }

    @Test
    void testTransformFileWhenOneLineOkFile() throws Exception {
        NumbersRow nr = new NumbersRow();
        List<String> result = nr.transformFile("input_files/oneLineResult.txt");
        assertEquals(1, result.size());
        assertEquals("Account number: 1  2  3  4  5  6  7  8  9  ", result.get(0));
    }

    @Test
    void testTransformFileWhenTwoLinesWithIll() throws Exception {
        NumbersRow nr = new NumbersRow();
        List<String> result = nr.transformFile("input_files/twoLinesResult.txt");
        assertEquals(2, result.size());
        assertEquals("Account number: 1  2  3  4  5  6  7  8  9  ", result.get(0));
        assertEquals("Account number: 7  2  3  4  5  6  1  8  ?  ILL", result.get(1));
    }

    @Test
    void testTransformFileWhenThreeLinesWithIllAndErr() throws Exception {
        NumbersRow nr = new NumbersRow();
        List<String> result = nr.transformFile("input_files/threeLinesResult.txt");
        assertEquals(3, result.size());
        assertEquals("Account number: 1  2  3  4  5  6  7  8  9  ", result.get(0));
        assertEquals("Account number: 7  2  3  4  5  6  1  8  ?  ILL", result.get(1));
        assertEquals("Account number: 7  2  3  4  5  6  1  8  9  ERR", result.get(2));
    }

}
