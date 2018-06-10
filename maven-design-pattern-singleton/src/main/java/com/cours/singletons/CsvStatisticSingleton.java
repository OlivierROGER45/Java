/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.singletons;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author elhad
 */
public class CsvStatisticSingleton {

    private CsvStatisticSingleton()
    {
        getListWeight();
        
    }
 
    private static CsvStatisticSingleton INSTANCE = new CsvStatisticSingleton();
     
    public static CsvStatisticSingleton getInstance()
    {   return INSTANCE;
    }
    
    public List<Double> listWeight = null;
    
    public double getMoyennePersonnes()
    {
        double moy = 0;
        for(Double d : listWeight)
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
        if(null == listWeight)
            loadCSVFile();
   
        return listWeight;
    }
    
    public List<Double> loadCSVFile()
    {
        listWeight = new ArrayList<Double>();
        listWeight.clear();

        String fileName = "./personnesCsv.csv";

        BufferedReader br = null;
        String line = "";
        String splitBy = ";";
        int lineNumber = 0;
        try
        {
            br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null)
            {       
                String[] attributes = line.split(splitBy);
                // check number attributes
                if (attributes.length == 8 && lineNumber != 0)
                {
                    try
                    {
                        listWeight.add(Double.parseDouble(attributes[3]));
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
        return listWeight;
    }
}
