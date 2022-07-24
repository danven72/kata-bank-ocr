package it.danven72.kata.ocr.model;

public class NumberElement {
    public final static NumberElement ZERO = new NumberElement(" _ ", "| |", "|_|");
    public final static NumberElement ONE = new NumberElement("   ", "  |", "  |");
    public final static NumberElement TWO = new NumberElement(" _ ", " _|", "|_ ");
    public final static NumberElement THREE = new NumberElement(" _ ", " _|", " _|");
    public final static NumberElement FOUR = new NumberElement("   ", "|_|", "  |");
    public final static NumberElement FIVE = new NumberElement(" _ ", "|_ ", " _|");
    public final static NumberElement SIX = new NumberElement(" _ ", "|_ ", "|_|");
    public final static NumberElement SEVEN = new NumberElement(" _ ", "  |", "  |");
    public final static NumberElement EIGHT = new NumberElement(" _ ", "|_|", "|_|");
    public final static NumberElement NINE = new NumberElement(" _ ", "|_|", " _|");

    private String[] rows = new String [3];

    public NumberElement() {}
    public NumberElement(String firstRow, String secondRow, String thirdRow) {
        add(0, firstRow);
        add(1, secondRow);
        add(2, thirdRow);
    }

    public void add(int index, String value) {
        if (index <0 || index > 2) throw new IllegalArgumentException("Index must be in [0,3]");
        if (value.length() != 3) throw new IllegalArgumentException("Value must have a length of three chars");
        rows[index] = value;
    }

    public String getValue(int index) {
        if (index <0 || index > 2) throw new IllegalArgumentException("Index must be in [0,3]");
        return rows[index];
    }

    public int getNumberValue() {
        int result = -1; // Ivalid value: convention
        if (this.equals(ZERO)) result = 0;
        else if (this.equals(ONE)) result = 1;
        else if (this.equals(TWO)) result = 2;
        else if (this.equals(THREE)) result = 3;
        else if (this.equals(FOUR)) result = 4;
        else if (this.equals(FIVE)) result = 5;
        else if (this.equals(SIX)) result = 6;
        else if (this.equals(SEVEN)) result = 7;
        else if (this.equals(EIGHT)) result = 8;
        else if (this.equals(NINE)) result = 9;

        return result;
    }


    //TODO: reimplement using getValue
    @Override
    public boolean equals(Object other) {
        boolean result = false;
        if (other != null && other instanceof NumberElement ) {
            NumberElement otherNumber = (NumberElement)other;
            result = this.toString().equals(otherNumber.toString());
        }
        return result;
    }

    @Override
    public String toString() {
        return rows[0]+"\n"+rows[1]+"\n"+rows[2];
    }

    public static void main(String[] args) {
        System.out.println(ZERO);
        System.out.println(ONE);
        System.out.println(TWO);
        System.out.println(THREE);
        System.out.println(FOUR);
        System.out.println(FIVE);
        System.out.println(SIX);
        System.out.println(SEVEN);
        System.out.println(EIGHT);
        System.out.println(NINE);
    }
}
