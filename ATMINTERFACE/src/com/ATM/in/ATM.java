package com.ATM.in;

import java.util.Scanner;

//Class to represent the ATM machine
class ATM {
 private BankAccount userAccount;
 private Scanner scanner;

 public ATM(BankAccount account) {
     this.userAccount = account;
     this.scanner = new Scanner(System.in);
 }

 // Display the ATM menu
 public void displayMenu() {
     System.out.println("\nATM Menu:");
     System.out.println("1. Check Balance");
     System.out.println("2. Deposit");
     System.out.println("3. Withdraw");
     System.out.println("4. Exit");
 }

 // Process user input
 public void run() {
     boolean running = true;

     while (running) {
         displayMenu();
         System.out.print("Enter your choice (1-4): ");
         int choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 checkBalance();
                 break;
             case 2:
                 deposit();
                 break;
             case 3:
                 withdraw();
                 break;
             case 4:
                 running = false;
                 System.out.println("Thank you for using our ATM. Goodbye!");
                 break;
             default:
                 System.out.println("Invalid choice. Please try again.");
         }
     }
 }

 private void checkBalance() {
     System.out.printf("Your current balance is: $%.2f%n", userAccount.getBalance());
 }

 private void deposit() {
     System.out.print("Enter the amount to deposit: $");
     double amount = scanner.nextDouble();

     if (amount > 0) {
         userAccount.deposit(amount);
         System.out.printf("$%.2f has been deposited successfully.%n", amount);
         System.out.printf("New balance: $%.2f%n", userAccount.getBalance());
     } else {
         System.out.println("Invalid amount. Deposit amount must be positive.");
     }
 }

 private void withdraw() {
     System.out.print("Enter the amount to withdraw: $");
     double amount = scanner.nextDouble();

     if (amount <= 0) {
         System.out.println("Invalid amount. Withdrawal amount must be positive.");
         return;
     }

     if (userAccount.withdraw(amount)) {
         System.out.printf("$%.2f has been withdrawn successfully.%n", amount);
         System.out.printf("Remaining balance: $%.2f%n", userAccount.getBalance());
     } else {
         System.out.println("Withdrawal failed. Insufficient balance or invalid amount.");
     }
 }
}