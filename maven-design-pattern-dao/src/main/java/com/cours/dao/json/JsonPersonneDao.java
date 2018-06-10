package com.cours.dao.json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.cours.entities.Personne;

public class JsonPersonneDao
{
    private final String   personnesJsonPathFile = "./personnesJson.json";

    private List<Personne> listPersonne;

    public JsonPersonneDao()
    {
        if (listPersonne == null)
            loadJSONFile();
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
        return listPersonne;
    }

    public void generateJSONFile()
    {
        File f = new File("./test.json");
        if (f.exists())
            f.delete();

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

        System.out.print(finalJsonObj.toJSONString());

        try (FileWriter file = new FileWriter("./test.json"))
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
        listPersonne.add(person);
        generateJSONFile();
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
            return true;
        }
        return false;
    }

}
