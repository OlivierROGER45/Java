package com.cours.dao.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cours.dao.AbstractPersonneDao;
import com.cours.entities.Personne;

public class CsvPersonneDao extends AbstractPersonneDao
{
    private final String   personnesCsvPathFile = "./personnesCsv.csv";

    private List<Personne> listPersonne;

    private CsvPersonneDao()
    {
        if (listPersonne == null)
            loadCSVFile();
    }

    private static CsvPersonneDao INSTANCE = new CsvPersonneDao();

    public static CsvPersonneDao getInstance()
    {
        return INSTANCE;
    }

    public List<Personne> loadCSVFile()
    {
        listPersonne = new ArrayList<Personne>();
        listPersonne.clear();

        BufferedReader br = null;
        String line = "";
        String splitBy = ";";
        int lineNumber = 0;
        try
        {
            br = new BufferedReader(new FileReader(personnesCsvPathFile));
            while ((line = br.readLine()) != null)
            {       
                String[] attributes = line.split(splitBy);
                // check number attributes
                if (attributes.length == 8 && lineNumber != 0)
                {
                    try
                    {
                        listPersonne.add(new Personne(Integer.parseInt(attributes[0]), attributes[1],
                                attributes[2], Double.parseDouble(attributes[3]), Double.parseDouble(attributes[4]),
                                attributes[5], attributes[6], attributes[7]));

                    }
                    catch (NumberFormatException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                else
                {
                   //Rien
                }
                lineNumber++;
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return listPersonne;
    }
    
    public void generateCSVFile()
    {
        // if file already exist then delete
        File f = new File(personnesCsvPathFile);
        if (f.exists())
            f.delete();

        BufferedWriter bw = null;
        FileWriter fw = null;

        try
        {
            fw = new FileWriter(personnesCsvPathFile);
            bw = new BufferedWriter(fw);
            // Write Header
           
            bw.write("idPersonne;Prenom;Nom;Poids;Taille;Rue;Ville;Code Postal");
            bw.newLine();
            for (Personne p : listPersonne)
            {
                bw.write(p.toStringCSV());
                bw.newLine();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public List<Personne> findAll()
    {
        if (listPersonne == null)
            loadCSVFile();
        return listPersonne;
    }

    public Personne findById(int id)
    {
        for (Personne p : listPersonne)
        {
            if (p.getIdPersonne() == id)
                return p;
        }
        return null;
    }

    public Personne create(Personne person)
    {
        int maxId = 1;
        for (Personne p : listPersonne)
        {
            if (p.getIdPersonne() > maxId)
                maxId = p.getIdPersonne();
            maxId++;
            person.setIdPersonne(maxId);
        }
        listPersonne.add(person);
        generateCSVFile();
        return person;
    }

    public Personne update(Personne person)
    {
        for (int i = 0; i < listPersonne.size(); i++)
        {
            if (listPersonne.get(i).getIdPersonne() == person.getIdPersonne())
            {
                listPersonne.set(i, person);
                generateCSVFile();
                return person;
            }
        }
        return null;

    }

    public boolean delete(Personne person)
    {
        if (null != findById(person.getIdPersonne()))
        {
            listPersonne.remove(person);
            generateCSVFile();
            return true;
        }
        return false;
    }

}
