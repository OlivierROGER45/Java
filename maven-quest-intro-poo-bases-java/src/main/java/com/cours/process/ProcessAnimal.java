/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.process;

import com.cours.entities.Animal;
import java.text.DateFormat;
import java.util.List;

/**
 *
 * @author elhad
 */
public class ProcessAnimal implements IProcessAnimal {

    private List<Animal> animals = null;
    private final DateFormat dateFormat = null;

    @Override
    public List<Animal> loadAnimalsManually() {
        //animals.clear();
       
        return null;
    }

    @Override
    public List<Animal> loadAnimalsFile() {
        //animals.clear();
       
        return null;
    }

    @Override
    public Double calculMoyennePoidsAnimaux() {
        
        return 0.0;
    }

    @Override
    public Double calculEcartTypePoidsAnimaux() {
        
        return 0.0;
    }

    @Override
    public List<Animal> sortAnimalsById() {

        return null;
    }

    @Override
    public List<Animal> sortAnimalsByName() {

        return null;
    }

    @Override
    public List<Animal> sortAnimalsByWeight() {

        return null;
    }

    @Override
    public List<Animal> sortAnimalsByColor() {

        return null;
    }

    @Override
    public void generateFileByName() {

    }

    @Override
    public void generateFileByWeight() {

    }

    @Override
    public List<Animal> getAnimals() {

        return null;
    }
}
