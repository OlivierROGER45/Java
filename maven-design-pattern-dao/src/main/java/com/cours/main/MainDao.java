package com.cours.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cours.dao.IPersonneDao;
import com.cours.dao.sql.SqlPersonneDao;
import com.cours.entities.Personne;
import com.dao.factory.complexe.AbstractDaoFactory;
import com.dao.factory.complexe.AbstractDaoFactory.FactoryType;
import com.dao.factory.complexe.ManualDaoFactory;

public class MainDao
{

    public static void main(String[] args)
    {
        AbstractDaoFactory facto = AbstractDaoFactory.getPersonneDao(FactoryType.CSV_DAO);
//        AbstractDaoFactory jsonDao = AbstractDaoFactory.getPersonneDao(FactoryType.JSON_DAO);
//        AbstractDaoFactory manualDao = AbstractDaoFactory.getPersonneDao(FactoryType.MANUAL_DAO);
//        AbstractDaoFactory sqlDao = AbstractDaoFactory.getPersonneDao(FactoryType.SQL_DAO);
//        AbstractDaoFactory xplDao = AbstractDaoFactory.getPersonneDao(FactoryType.XML_DAO);
        
        // Create
        Personne p = new Personne("CreateFirstName", "CreateName", 22.2, 178.2, "CreateRue", "CreateVille", "45000");
        // Update
        Personne p2 = new Personne(2, "CreateFirstName", "CreateName", 22.2, 178.2, "CreateRue", "CreateVille",
                "45000");
        // Delete
        Personne p3 = new Personne(3, "CreateFirstName", "CreateName", 22.2, 178.2, "CreateRue", "CreateVille",
                "45000");
        
        /**
         * CSV
         */
        IPersonneDao c = (IPersonneDao) facto.getPersonneDao(FactoryType.CSV_DAO);
        c.findAll();
        c.create(p);
        c.findById(11);
        c.update(p2);
        c.delete(p3);
        c.findAll();
        
        /**
         * Json
         */
        IPersonneDao j = (IPersonneDao) facto.getPersonneDao(FactoryType.JSON_DAO);
        j.findAll();
        j.create(p);
        j.findById(11);
        j.update(p2);
        j.delete(p3);
        j.findAll();
        
        /**
         * Manual
         */
        IPersonneDao m = (IPersonneDao) facto.getPersonneDao(FactoryType.MANUAL_DAO);
        m.findAll();
        m.create(p);
        m.findById(11);
        m.update(p2);
        m.delete(p3);
        m.findAll();
        
        /**
         * SQL
         */
        IPersonneDao s = (IPersonneDao) facto.getPersonneDao(FactoryType.SQL_DAO);
        s.findAll();
        s.create(p);
        s.findById(11);
        s.update(p2);
        s.delete(p3);
        s.findAll();
        
        /**
         * XML
         */
        IPersonneDao x = (IPersonneDao) facto.getPersonneDao(FactoryType.XML_DAO);
        x.findAll();
        x.create(p);
        x.findById(11);
        x.update(p2);
        x.delete(p3);
        x.findAll();
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
