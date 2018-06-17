package com.cours.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cours.dao.IPersonneDao;
import com.cours.dao.impl.CsvPersonneDaoImpl;
import com.cours.dao.json.JsonPersonneDao;
import com.cours.dao.sql.SqlPersonneDao;
import com.cours.dao.xml.XmlPersonneDao;
import com.cours.entities.Personne;
import com.dao.factory.complexe.AbstractDaoFactory;
import com.dao.factory.complexe.AbstractDaoFactory.FactoryType;
import com.dao.factory.complexe.CsvDaoFactory;
import com.dao.factory.complexe.JsonDaoFactory;
import com.dao.factory.complexe.ManualDaoFactory;
import com.dao.factory.complexe.SqlDaoFactory;
import com.dao.factory.complexe.XmlDaoFactory;

public class MainDao
{

    public static void main(String[] args)
    {
        
        AbstractDaoFactory sqlDao = AbstractDaoFactory.getDaoFactory(FactoryType.SQL_DAO);
        AbstractDaoFactory jsonDao = AbstractDaoFactory.getDaoFactory(FactoryType.JSON_DAO);
        AbstractDaoFactory manualDao = AbstractDaoFactory.getDaoFactory(FactoryType.MANUAL_DAO);
        AbstractDaoFactory csvDao = AbstractDaoFactory.getDaoFactory(FactoryType.CSV_DAO);
        AbstractDaoFactory xplDao = AbstractDaoFactory.getDaoFactory(FactoryType.XML_DAO);
                
        // Create
        Personne p = new Personne("CreateFirstName", "CreateName", 22.2, 178.2, "CreateRue", "CreateVille", "45000");
        // Update
        Personne p2 = new Personne(2, "CreateFirstName", "CreateName", 22.2, 178.2, "CreateRue", "CreateVille",
                "45000");
        // Delete
        Personne p3 = new Personne(3, "CreateFirstName", "CreateName", 22.2, 178.2, "CreateRue", "CreateVille",
                "45000");
        
        csvDao.getPersonneDao().findAll();
        csvDao.getPersonneDao().create(p);
        csvDao.getPersonneDao().findById(11);
        csvDao.getPersonneDao().update(p2);
        csvDao.getPersonneDao().findAll();

        jsonDao.getPersonneDao().findAll();
        jsonDao.getPersonneDao().create(p);
        jsonDao.getPersonneDao().findById(11);
        jsonDao.getPersonneDao().update(p2);
        jsonDao.getPersonneDao().findAll();

        manualDao.getPersonneDao().findAll();
        manualDao.getPersonneDao().create(p);
        manualDao.getPersonneDao().findById(11);
        manualDao.getPersonneDao().update(p2);
        manualDao.getPersonneDao().findAll();

        sqlDao.getPersonneDao().findAll();
        sqlDao.getPersonneDao().create(p);
        sqlDao.getPersonneDao().findById(9);
        sqlDao.getPersonneDao().update(p2);
        sqlDao.getPersonneDao().findAll();

        xplDao.getPersonneDao().findAll();
        xplDao.getPersonneDao().create(p);
        xplDao.getPersonneDao().findById(11);
        xplDao.getPersonneDao().update(p2);
        xplDao.getPersonneDao().findAll();
        
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
