/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.singletons;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author ElHadji
 */
public class JsonStatisticSingleton
{

    private JsonStatisticSingleton()
    {
        getListWeight();
    }

    private static JsonStatisticSingleton INSTANCE = new JsonStatisticSingleton();

    public static JsonStatisticSingleton getInstance()
    {
        return INSTANCE;
    }

    public List<Double> listWeight = null;

    public double getMoyennePersonnes()
    {
        double moy = 0;
        for (Double d : listWeight)
        {
            moy = moy + d;
        }
        return moy / listWeight.size();
    }

    public Double getEcartTypePersonnes()
    {
        double w2 = 0;
        for (Double d : listWeight)
        {
            w2 += d * d;
        }
        double res = Math.pow((w2 / listWeight.size()) - (getMoyennePersonnes() * getMoyennePersonnes()), 0.5);

        return res;
    }

    public List<Double> getListWeight()
    {
        if (null == listWeight)
            loadJSONFile();

        return listWeight;
    }

    public void loadJSONFile()
    {
        listWeight = new ArrayList<Double>();
        listWeight.clear();
        JSONParser parser = new JSONParser();

        try
        {
            Object obj = parser.parse(new FileReader("./personnesJson.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray personnes = (JSONArray) jsonObject.get("personnes"); 

            for (int i = 0; i < personnes.size(); i++)
            {
                JSONObject line = (JSONObject) personnes.get(i);
                Object o = line.get("poids");
                
                String s = o.toString();
                Double d = Double.parseDouble(s);
                listWeight.add(d);
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
    }

}
