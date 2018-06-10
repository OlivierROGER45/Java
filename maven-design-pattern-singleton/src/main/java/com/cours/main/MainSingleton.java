/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.main;

import com.cours.singletons.CsvStatisticSingleton;
import com.cours.singletons.JsonStatisticSingleton;
import com.cours.singletons.XmlStatisticSingleton;

/**
 *
 * @author elhad
 */
public class MainSingleton {

    public static String className = MainSingleton.class.getName();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         callCalculStatisticCsv();
         callCalculStatisticJson();
         callCalculStatisticXml();
       
    }

    public static void callCalculStatisticJson() {
        String methodName = "callCalculStatisticJson";
        System.out.println(className + " -->" + methodName + " , Appel numero 1 moyennePersonnes : " + JsonStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 1 ecartTypePersonnes : " + JsonStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 2 moyennePersonnes : " + JsonStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 2 ecartTypePersonnes : " + JsonStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 3 moyennePersonnes : " + JsonStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 3 ecartTypePersonnes : " + JsonStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 4 moyennePersonnes : " + JsonStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 4 ecartTypePersonnes : " + JsonStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 5 moyennePersonnes : " + JsonStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 5 ecartTypePersonnes : " + JsonStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 6 moyennePersonnes : " + JsonStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 6 ecartTypePersonnes : " + JsonStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 7 moyennePersonnes : " + JsonStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 7 ecartTypePersonnes : " + JsonStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 8 moyennePersonnes : " + JsonStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 8 ecartTypePersonnes : " + JsonStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 9 moyennePersonnes : " + JsonStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 9 ecartTypePersonnes : " + JsonStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 10 moyennePersonnes : " + JsonStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 10 ecartTypePersonnes : " + JsonStatisticSingleton.getInstance().getEcartTypePersonnes());
    }

    public static void callCalculStatisticXml() {
        String methodName = "callCalculStatisticXml";
        System.out.println(className + " -->" + methodName + " , Appel numero 1 moyennePersonnes : " + XmlStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 1 ecartTypePersonnes : " + XmlStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 2 moyennePersonnes : " + XmlStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 2 ecartTypePersonnes : " + XmlStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 3 moyennePersonnes : " + XmlStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 3 ecartTypePersonnes : " + XmlStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 4 moyennePersonnes : " + XmlStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 4 ecartTypePersonnes : " + XmlStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 5 moyennePersonnes : " + XmlStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 5 ecartTypePersonnes : " + XmlStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 6 moyennePersonnes : " + XmlStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 6 ecartTypePersonnes : " + XmlStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 7 moyennePersonnes : " + XmlStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 7 ecartTypePersonnes : " + XmlStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 8 moyennePersonnes : " + XmlStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 8 ecartTypePersonnes : " + XmlStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 9 moyennePersonnes : " + XmlStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 9 ecartTypePersonnes : " + XmlStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 10 moyennePersonnes : " + XmlStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 10 ecartTypePersonnes : " + XmlStatisticSingleton.getInstance().getEcartTypePersonnes());
    }

    public static void callCalculStatisticCsv() {
        String methodName = "callCalculStatisticCsv";
      
        System.out.println(className + " -->" + methodName + " , Appel numero 1 moyennePersonnes : " + CsvStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 1 ecartTypePersonnes : " + CsvStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 2 moyennePersonnes : " + CsvStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 2 ecartTypePersonnes : " + CsvStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 3 moyennePersonnes : " + CsvStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 3 ecartTypePersonnes : " + CsvStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 4 moyennePersonnes : " + CsvStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 4 ecartTypePersonnes : " + CsvStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 5 moyennePersonnes : " + CsvStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 5 ecartTypePersonnes : " + CsvStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 6 moyennePersonnes : " + CsvStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 6 ecartTypePersonnes : " + CsvStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 7 moyennePersonnes : " + CsvStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 7 ecartTypePersonnes : " + CsvStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 8 moyennePersonnes : " + CsvStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 8 ecartTypePersonnes : " + CsvStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 9 moyennePersonnes : " + CsvStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 9 ecartTypePersonnes : " + CsvStatisticSingleton.getInstance().getEcartTypePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 10 moyennePersonnes : " + CsvStatisticSingleton.getInstance().getMoyennePersonnes());
        System.out.println(className + " -->" + methodName + " , Appel numero 10 ecartTypePersonnes : " + CsvStatisticSingleton.getInstance().getEcartTypePersonnes());
    }
}
