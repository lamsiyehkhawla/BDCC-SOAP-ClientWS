package org.example;

// Importing necessary classes and interfaces from the proxy package.
import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

import java.util.ArrayList;
import java.util.List;

/**
 * This class demonstrates a client application consuming a web service
 * It uses a proxy to interact with the web service
 * and performs operations such as currency conversion, account retrieval,
 * and listing all accounts.
 */
public class clientWS {
    public static void main(String[] args) {
        // Creating a proxy object to access the web service.
        BanqueService proxy = new BanqueWS().getBanqueServicePort();

        // Example: Convert 888 Euros to Dirhams and display the result.
        System.out.println(proxy.conversionEuroToDH(888));

        // Example: Retrieve details of an account with ID 5.
        Compte cp = proxy.getCompte(5);
        // Display the account's details (code, creation date, and balance).
        System.out.println(cp.getCode());
        System.out.println(cp.getDateCreation());
        System.out.println(cp.getSolde());

        // Example: Fetch a list of all accounts from the web service.
        List<Compte> compteList = proxy.listeCompte();

        // Iterate through the list and display details of each account.
        for (Compte c : compteList) {
            System.out.println("-----------------------------");
            System.out.println("Solde : " + c.getSolde()); // Display account balance.
            System.out.println("Code : " + c.getCode()); // Display account code.
            System.out.println("Date Creation :" + c.getDateCreation()); // Display account creation date.
        }
    }
}
