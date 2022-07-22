package it.danven72.kata.ocr.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberElementTest {

    @Test
    void testAdd() {
        NumberElement numberElement = new NumberElement();
        numberElement.add(0, "_|_");
        numberElement.add(1, "___");
        numberElement.add(2, "|||");
        assertEquals("_|_", numberElement.getValue(0));
        assertEquals("___", numberElement.getValue(1));
        assertEquals("|||", numberElement.getValue(2));
    }

    @Test
    void testAddWhenIndexOutOfLimit() {
        NumberElement numberElement = new NumberElement();
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            numberElement.add(3, "|||");
        });

        assertEquals("Index must be in [0,3]", thrown.getMessage());
    }

    @Test
    void testAddWhenChunkLengthIsMajorOf3() {
        NumberElement numberElement = new NumberElement();
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            numberElement.add(0, "||||");
        });

        assertEquals("Value must have a length of three chars", thrown.getMessage());
    }

    @Test
    void testGetValueWhenIndexIsMajorOf2() {
        NumberElement numberElement = new NumberElement();
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            numberElement.getValue(3);
        });

        assertEquals("Index must be in [0,3]", thrown.getMessage());
    }

    @Test
    void getNumberValue() {
        int result = NumberElement.FIVE.getNumberValue();
        assertEquals(5, result);
    }

    @Test
    void getNumberValueWhenUnknown() {
        NumberElement numberElement = new NumberElement("===","|||","$$$");
        assertEquals(-1, numberElement.getNumberValue());
    }

}
