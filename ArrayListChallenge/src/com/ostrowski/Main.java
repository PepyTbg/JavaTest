package com.ostrowski;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static MobilePhone mobilePhone = new MobilePhone("12 12 1992");

    public static void main(String[] args) {


        boolean quit = false;
        startPhone();
        printActions();

        while (!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;

                case 1:
                    mobilePhone.printContacts();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    updateContact();
                    break;

                case 4:
                    removeContact();
                    break;

                case 5:
                    queryContact();
                    break;

                case 6:
                    printActions();
                    break;
            }

        }


    }

    private static void startPhone() {
        System.out.println("Starting phone......");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to shutdown\n" +
                "1  - to print contacts\n" +
                "2  - to add a new contact\n" +
                "3  - to update existing an existing contact\n" +
                "4  - to remove an existing contact\n" +
                "5  - query if an existing contact exists\n" +
                "6  - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }

    private static void printContacts() {
        mobilePhone.printContacts();
    }

    private static void addNewContact() {
        System.out.println("Enter new contact name ");
        String newName = scanner.nextLine();
        System.out.println("Enter " + newName + " new phone number");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added name=" + newName + " phone number " + newNumber);
        } else {
            System.out.println("Cannot add " + newName + " contact already exists");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name ?");
        String name= scanner.nextLine();
        Contact existincContactRecord= mobilePhone.queryContact(name);
        if (existincContactRecord== null) {
            System.out.println("Cannot find the contact " + name);
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName= scanner.nextLine();
        System.out.println("Enter new contact number: ");
        String newNumber= scanner.nextLine();
        Contact newContact= Contact.createContact(newName,newNumber);
        if(mobilePhone.updateContact(existincContactRecord,newContact)) {
            System.out.println("Succesfully updated record");
        }
            else{
            System.out.println("Error updating record");
        }

    }

    private static void removeContact() {
        System.out.println("Enter existing contact name ?");
        String name = scanner.nextLine();
        Contact existincContactRecord = mobilePhone.queryContact(name);
        if (existincContactRecord == null) {
            System.out.println("Cannot find the contact " + name);
            return;
        }
        if (mobilePhone.removeContact(existincContactRecord)) {
            System.out.println("Contact removed");
        } else {
            System.out.println("Error removing contact");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name ?");
        String name = scanner.nextLine();
        Contact existincContactRecord = mobilePhone.queryContact(name);
        if (existincContactRecord == null) {
            System.out.println("Cannot find the contact " + name);
            return;
        }
        System.out.println("Name " + existincContactRecord.getName() + "phone number" + existincContactRecord.getPhoneNumber());

    }
}