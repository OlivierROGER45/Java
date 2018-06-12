package com.cours.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cours.dao.sql.SqlPersonneDao;
import com.cours.entities.Personne;

public class MainDao
{

    public static void main(String[] args)
    {
        // AbstractPersonneDao dao = new AbstractPersonneDao(FactoryType.CSV_DAO);

        // JsonPersonneDao json = new JsonPersonneDao();
        // json.loadJSONFile();
        // json.generateJSONFile();
        
        Log log = LogFactory.getLog(MainDao.class);

        //XmlPersonneDao xml = new XmlPersonneDao();
        // xml.loadXMLFile();
        //xml.generateXMLFile();
        
        SqlPersonneDao sql = SqlPersonneDao.getInstance();
        sql.findById(1);
        sql.findAll();
        
    }

    /**
     * Méthode qui init 20 personnes
     *
     * @return Une liste de 20 personnes
     */
    public static List<Personne> initPersonnes()
    {
        List l = new ArrayList<Personne>();
        for (int i = 0; i < 20; i++)
        {
            l.add(new Personne());
        }
        return l;
    }

    /**
     * Méthode qui trie une liste de personnes par prénom croissant
     *
     * @param liste
     *            La liste à trier
     * @return La liste triée par prénom croissant
     */
    public List<Personne> sortByFirstNameAsc(List<Personne> liste)
    {
        liste.sort(Comparator.comparing(Personne::getPrenom));
        return liste;
    }

    /**
     * Méthode qui trie une liste de personnes par prénom décroissant
     *
     * @param liste
     *            La liste à trier
     * @return La liste triée par prénom décroissant
     */
    public List<Personne> sortByFirstNameDesc(List<Personne> liste)
    {
        liste.sort(Comparator.comparing(Personne::getPrenom).reversed());
        return liste;
    }

    /**
     * Méthode qui trie une liste de personnes par nom croissant
     *
     * @param liste
     *            La liste à trier
     * @return La liste triée par nom croissant
     */
    public List<Personne> sortByLastNameAsc(List<Personne> liste)
    {
        liste.sort(Comparator.comparing(Personne::getNom));
        return liste;
    }

    /**
     * Méthode qui trie une liste de personnes par nom décroissant
     *
     * @param liste
     *            La liste à trier
     * @return La liste triée par nom décroissant
     */
    public List<Personne> sortByLastNameDesc(List<Personne> liste)
    {
        liste.sort(Comparator.comparing(Personne::getNom).reversed());
        return liste;
    }
}
