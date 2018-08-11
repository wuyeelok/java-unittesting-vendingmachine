package com.teamtreehouse.vending;

import org.junit.Test;

import static org.junit.Assert.*;

public class CreditorTest {


    @Test
    public void addingFundsIncrementsAvaliableFunds() {
        //  Arrange
        Creditor creditor = new Creditor();

        //  Act
        creditor.addFunds(25);
        creditor.addFunds(25);

        //  Assert
        assertEquals(50, creditor.getAvailableFunds());

    }

    @Test
    public void refundingReturnsAllAvailableFunds() {
        Creditor creditor = new Creditor();
        creditor.addFunds(10);

        int refund = creditor.refund();

        assertEquals(10, refund);
    }

    @Test
    public void refundingResetsAvailableFundsToZero() {

        Creditor creditor = new Creditor();
        creditor.addFunds(60);
        creditor.refund();

        assertEquals(0, creditor.getAvailableFunds());
    }
}