/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.process;

import com.cours.entities.Animal;
import com.dao.test.JUnitTestProcessAnimal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elhad
 */
public class ProcessAnimal implements IProcessAnimal
{
    private static final Log log        = LogFactory.getLog(ProcessAnimal.class);
    // private List<Animal> animals = null;
    private List<Animal>     animals    = new ArrayList<Animal>();
    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public List<Animal> loadAnimalsManually()
    {

        animals.clear();
        try
        {
            animals.add(new Animal(1, "Lion", 200, dateFormat.parse("23/12/1988"), "Maron", 4, true));
            animals.add(new Animal(2, "Elephant", 700, dateFormat.parse("23/12/1978"), "Noir", 4, true));
            animals.add(new Animal(3, "Tigre", 150, dateFormat.parse("23/12/1998"), "Blanc", 4, true));
            animals.add(new Animal(4, "Requin", 10, dateFormat.parse("23/12/1978"), "Blanc", 0, true));
            animals.add(new Animal(5, "Chat", 5, dateFormat.parse("23/12/2000"), "Noir", 4, true));
            animals.add(new Animal(6, "Mouton", 25, dateFormat.parse("23/12/2001"), "Blanc", 4, false));
            animals.add(new Animal(7, "Chevre", 35, dateFormat.parse("23/12/2012"), "Noir", 4, false));
            animals.add(new Animal(8, "Poule", 1, dateFormat.parse("23/12/2009"), "Maron", 2, false));
            animals.add(new Animal(9, "Porc", 20, dateFormat.parse("23/12/2003"), "Blanche", 4, true));
            animals.add(new Animal(10, "Singe", 25, dateFormat.parse("23/12/2004"), "Noir", 4, false));
            animals.add(new Animal(11, "Giraffe", 175, dateFormat.parse("23/12/2013"), "Maron et Noir", 4, false));
        }
        catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return animals;
    }

    @Override
    public List<Animal> loadAnimalsFile()
    {
        animals.clear();

        String fileName = "./animaux.txt";

        BufferedReader br = null;
        String line = "";
        String splitBy = ",";
        try
        {
            br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null)
            {
                //remove space
                line = line.replaceAll("\\s","");
                // split on comma(',')
                String[] attributes = line.split(splitBy);
                // check number attributes
                if (attributes.length == 7)
                {
                    try
                    {
                        animals.add(new Animal(Integer.parseInt(attributes[0]), attributes[1],
                                Double.parseDouble(attributes[2]), dateFormat.parse(attributes[3]), attributes[4],
                                Integer.parseInt(attributes[5]), Boolean.parseBoolean(attributes[6])));
                    }
                    catch (NumberFormatException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    catch (ParseException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                else
                {
                    if (log.isDebugEnabled())
                    {
                        log.debug("Line malformated do nothing");
                    }
                }
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
        return animals;
    }

    @Override
    public Double calculMoyennePoidsAnimaux()
    {
        double sum = 0;
        for (Animal a : loadAnimalsFile())
        {
            sum += a.getPoids();
        }
        return sum / loadAnimalsFile().size();
    }

    @Override
    public Double calculEcartTypePoidsAnimaux()
    {
        double w2 = 0;
        for (Animal a : loadAnimalsFile())
        {
            w2 += a.getPoids() * a.getPoids();
        }
        double res = Math.pow(
                (w2 / loadAnimalsFile().size()) - (calculMoyennePoidsAnimaux() * calculMoyennePoidsAnimaux()), 0.5);

        return res;
    }

    @Override
    public List<Animal> sortAnimalsById()
    {
        List<Animal> list = loadAnimalsFile();
        list.sort(Comparator.comparing(Animal::getIdAnimal));
        return list;
    }

    @Override
    public List<Animal> sortAnimalsByName()
    {
        List<Animal> list = loadAnimalsFile();
        list.sort(Comparator.comparing(Animal::getNom));
        return list;
    }

    @Override
    public List<Animal> sortAnimalsByWeight()
    {
        List<Animal> list = loadAnimalsFile();
        list.sort(Comparator.comparing(Animal::getPoids));
        return list;
    }

    @Override
    public List<Animal> sortAnimalsByColor()
    {
        List<Animal> list = loadAnimalsFile();
        list.sort(Comparator.comparing(Animal::getCouleur));
        return list;
    }

    @Override
    public void generateFileByName()
    {

        // if file already exist then delete
        File f = new File("./animauxParNom.txt");
        if (f.exists())
            f.delete();

        // Write
        final String FILE = "./animauxParNom.txt";

        BufferedWriter bw = null;
        FileWriter fw = null;

        try
        {
            fw = new FileWriter(FILE);
            bw = new BufferedWriter(fw);
            for (Animal a : sortAnimalsByName())
            {
                bw.write(a.toString());
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

    @Override
    public void generateFileByWeight()
    {
        // if file already exist then delete
        File f = new File("./animauxParPoids.txt");
        if (f.exists())
            f.delete();

        // Write
        final String FILE = "./animauxParPoids.txt";

        BufferedWriter bw = null;
        FileWriter fw = null;

        try
        {
            fw = new FileWriter(FILE);
            bw = new BufferedWriter(fw);
            for (Animal a : sortAnimalsByWeight())
            {
                bw.write(a.toString());
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

    @Override
    public List<Animal> getAnimals()
    {
        return animals;
    }
}
