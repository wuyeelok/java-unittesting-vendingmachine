package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlphaNumericChooserTest {

    AlphaNumericChooser chooser;

    @Before
    public void setUp() throws Exception {
        chooser = new AlphaNumericChooser(26, 10);
    }

    @Test
    public void validInputReturnsProperLoction() throws Exception{
        AlphaNumericChooser.Location loc = null;

        loc = chooser.locationFromInput("B4");


        assertEquals("Proper row",1, loc.getRow());
        assertEquals("Proper column",3, loc.getColumn());
    }

    @Test(expected = InvalidLocationException.class)
    public void choosingWrongInputIsNotAllowed() throws Exception {
        chooser.locationFromInput("WRONG");
    }

    @Test(expected = InvalidLocationException.class)
    public void choosingLargeThanMaxIsNotAllowed() throws Exception {
        chooser.locationFromInput("C12");
    }
}
