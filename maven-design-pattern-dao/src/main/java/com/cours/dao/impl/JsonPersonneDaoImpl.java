package com.cours.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.cours.dao.IPersonneDao;
import com.cours.entities.Personne;

public class JsonPersonneDaoImpl implements IPersonneDao
{
    private static final Log log = LogFactory.getLog(JsonPersonneDaoImpl.class);
    
    private final String   personnesJsonPathFile = "./personnesJson.json";

    private List<Personne> listPersonne;
    
    private JsonPersonneDaoImpl()
    {
        if (listPersonne == null)
            loadJSONFile();
    }

    private static JsonPersonneDaoImpl INSTANCE = new JsonPersonneDaoImpl();

    public static JsonPersonneDaoImpl getInstance()
    {
        return INSTANCE;
    }

    public List<Personne> loadJSONFile()
    {
        listPersonne = new ArrayList<Personne>();
        listPersonne.clear();
        JSONParser parser = new JSONParser();

        try
        {
            Object obj = parser.parse(new FileReader(personnesJsonPathFile));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray personnes = (JSONArray) jsonObject.get("personnes");

            for (int i = 0; i < personnes.size(); i++)
            {
                JSONObject line = (JSONObject) personnes.get(i);

                Personne p = new Personne();

                // ID
                long l = (long) line.get("id");
                int id = (int) l;
                p.setIdPersonne(id);
                // Name, Fistname
                p.setPrenom((String) line.get("prenom"));
                p.setNom((String) line.get("nom"));
                // Weight
                l = (long) line.get("poids");
                double d = (double) l;
                p.setPoids(d);
                // Size
                l = (long) line.get("taille");
                d = (double) l;
                p.setTaille(d);

                p.setRue((String) line.get("rue"));
                p.setVille((String) line.get("ville"));
                p.setCodePostal((String) line.get("codePostal"));

                listPersonne.add(p);
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
        catch (org.json.simple.parser.ParseException e)
        {
            e.printStackTrace();
        }
        if(log.isDebugEnabled()) {log.debug(listPersonne);}
        return listPersonne;
    }

    public void generateJSONFile()
    {
        JSONObject jsonObj;
        JSONArray personList = new JSONArray();

        for (Personne p : listPersonne)
        {
            jsonObj = new JSONObject();
            jsonObj.put("id", p.getIdPersonne());
            jsonObj.put("prenom", p.getPrenom());
            jsonObj.put("nom", p.getNom());
            jsonObj.put("poids", p.getPoids());
            jsonObj.put("taille", p.getTaille());
            jsonObj.put("rue", p.getRue());
            jsonObj.put("ville", p.getVille());
            jsonObj.put("codePostal", p.getCodePostal());

            personList.add(jsonObj);
        }
        JSONObject finalJsonObj = new JSONObject();
        finalJsonObj.put("personnes", personList);
        
        File f = new File(personnesJsonPathFile);
        if (f.exists())
            f.delete();

        try (FileWriter file = new FileWriter(personnesJsonPathFile))
        {

            file.write(finalJsonObj.toJSONString());
            file.flush();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public List<Personne> findAll()
    {
        if (listPersonne == null)
            loadJSONFile();
        if(log.isDebugEnabled()) {log.debug(listPersonne);}
        return listPersonne;
    }

    public Personne findById(int id)
    {
        for (Personne p : listPersonne)
        {
            if (p.getIdPersonne() == id)
            {
                if(log.isDebugEnabled()) {log.debug(p);}
                return p;
            }
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
        generateJSONFile();
        if(log.isDebugEnabled()) {log.debug(person);}
        return person;
    }

    public Personne update(Personne person)
    {
        for (int i = 0; i < listPersonne.size(); i++)
        {
            if (listPersonne.get(i).getIdPersonne() == person.getIdPersonne())
            {
                listPersonne.set(i, person);
                generateJSONFile();
                if(log.isDebugEnabled()) {log.debug(person);}
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
            generateJSONFile();
            if(log.isDebugEnabled()) {log.debug("Deleted " + person);}
            return true;
        }
        return false;
    }

}
