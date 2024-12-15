package org.example;

import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

import java.util.ArrayList;
import java.util.List;

public class clientWS {
    public static void main(String[] args) {
        BanqueService proxy = new BanqueWS().getBanqueServicePort();
        System.out.println(proxy.conversionEuroToDH(888));
        Compte cp = proxy.getCompte(5);
        System.out.println(cp.getCode());
        System.out.println(cp.getDateCreation());
        System.out.println(cp.getSolde());
        List<Compte> compteList = proxy.listeCompte();
        for (Compte c : compteList) {
            System.out.println("-----------------------------");
            System.out.println("Solde : "+c.getSolde());
            System.out.println("Code : "+c.getCode());
            System.out.println("Date Creation :"+c.getDateCreation());
        }
    }
}
