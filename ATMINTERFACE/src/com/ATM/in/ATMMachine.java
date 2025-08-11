package com.ATM.in;

public class ATMMachine {
    public static void main(String[] args) {
    	
        BankAccount userAccount = new BankAccount(1000.00);
        
        ATM atm = new ATM(userAccount);
        
        System.out.println("Welcome to the ATM Machine!");
        
        atm.run();
    }
}