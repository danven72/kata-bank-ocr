package it.danven72.kata.ocr.model;

import org.junit.jupiter.api.Test;
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
    void testParseRowAtrow1() {
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

    private void doTestParseRowAtRow(int row) {

    }

}
