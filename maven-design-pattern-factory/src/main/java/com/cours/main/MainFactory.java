/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cours.factory.Colis;
import com.cours.factory.FactoryLivraison;
import com.cours.factory.Livraison;

/**
 *
 * @author elhad
 */
public class MainFactory {

    private static final Log log = LogFactory.getLog(MainFactory.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        FactoryLivraison facto = new FactoryLivraison();
        Colis c1 = new Colis("vétements", 5, false);
        Colis c2 = new Colis("verre", 0.5, true);
        Colis c3 = new Colis("status verre", 2.5, true);
        Livraison l1 = facto.createLivraison(c1, 1);
        Livraison l2 = facto.createLivraison(c2, 2);
        Livraison l3 = facto.createLivraison(c3);
        
        l1.print();
        l2.print();
        l3.print();
        
    }
}
