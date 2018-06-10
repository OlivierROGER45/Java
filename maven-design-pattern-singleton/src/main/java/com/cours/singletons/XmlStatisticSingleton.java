/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.singletons;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author ElHadji
 */
public class XmlStatisticSingleton
{

    private XmlStatisticSingleton()
    {
        getListWeight();
    }

    private static XmlStatisticSingleton INSTANCE = new XmlStatisticSingleton();

    public static XmlStatisticSingleton getInstance()
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
            loadXMLFile();

        return listWeight;
    }

    public List<Double> loadXMLFile()
    {
        listWeight = new ArrayList<Double>();
        listWeight.clear();
        try
        {

            File fXmlFile = new File("./personnesXml.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("personne");

            for (int temp = 0; temp < nList.getLength(); temp++)
            {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) nNode;
                    listWeight.add(Double.parseDouble(eElement.getElementsByTagName("poids").item(0).getTextContent()));
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return listWeight;
    }

}
