package com.cours.dao.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.cours.dao.IPersonneDao;
import com.cours.entities.Personne;

public class XmlPersonneDaoImpl implements IPersonneDao
{
    private final String   personnesXmlPathFile = "./personnesXml.xml";

    private List<Personne> listPersonne;

    private XmlPersonneDaoImpl()
    {
        if (listPersonne == null)
            loadXMLFile();
    }

    private static XmlPersonneDaoImpl INSTANCE = new XmlPersonneDaoImpl();

    public static XmlPersonneDaoImpl getInstance()
    {
        return INSTANCE;
    }

    public List<Personne> loadXMLFile()
    {
        listPersonne = new ArrayList<Personne>();
        listPersonne.clear();
        try
        {

            File fXmlFile = new File(personnesXmlPathFile);
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
                    Personne p = new Personne();

                    p.setIdPersonne(Integer.parseInt(nNode.getAttributes().item(0).getTextContent()));
                    p.setNom(eElement.getElementsByTagName("prenom").item(0).getTextContent());
                    p.setPrenom(eElement.getElementsByTagName("nom").item(0).getTextContent());
                    p.setRue(eElement.getElementsByTagName("rue").item(0).getTextContent());
                    p.setVille(eElement.getElementsByTagName("ville").item(0).getTextContent());
                    p.setCodePostal(eElement.getElementsByTagName("codePostal").item(0).getTextContent());

                    p.setPoids(Double.parseDouble(eElement.getElementsByTagName("poids").item(0).getTextContent()));
                    p.setTaille(Double.parseDouble(eElement.getElementsByTagName("taille").item(0).getTextContent()));

                    listPersonne.add(p);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return listPersonne;
    }

    public void generateXMLFile()
    {
        File f = new File(personnesXmlPathFile);
        if (f.exists())
            f.delete();

        try
        {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("personnes");
            doc.appendChild(rootElement);

            // personne element
            for (Personne p : listPersonne)
            {
                Element personne = doc.createElement("personne");
                rootElement.appendChild(personne);

                Attr attr = doc.createAttribute("id");
                attr.setValue(String.valueOf(p.getIdPersonne()));
                personne.setAttributeNode(attr);

                // firstname elements
                Element firstname = doc.createElement("prenom");
                firstname.appendChild(doc.createTextNode(p.getPrenom()));
                personne.appendChild(firstname);

                Element name = doc.createElement("nom");
                name.appendChild(doc.createTextNode(p.getNom()));
                personne.appendChild(name);

                Element rue = doc.createElement("rue");
                rue.appendChild(doc.createTextNode(p.getRue()));
                personne.appendChild(rue);

                Element ville = doc.createElement("ville");
                ville.appendChild(doc.createTextNode(p.getVille()));
                personne.appendChild(ville);

                Element codePostal = doc.createElement("codePostal");
                codePostal.appendChild(doc.createTextNode(p.getCodePostal()));
                personne.appendChild(codePostal);

                Element poids = doc.createElement("poids");
                poids.appendChild(doc.createTextNode(String.valueOf(p.getPoids())));
                personne.appendChild(poids);

                Element taille = doc.createElement("taille");
                taille.appendChild(doc.createTextNode(String.valueOf(p.getTaille())));
                personne.appendChild(taille);
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(personnesXmlPathFile));

            transformer.transform(source, result);

        }
        catch (ParserConfigurationException pce)
        {
            pce.printStackTrace();
        }
        catch (TransformerException tfe)
        {
            tfe.printStackTrace();
        }
    }

    public List<Personne> findAll()
    {
        if (listPersonne == null)
            loadXMLFile();
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
        generateXMLFile();
        return person;
    }

    public Personne update(Personne person)
    {
        for (int i = 0; i < listPersonne.size(); i++)
        {
            if (listPersonne.get(i).getIdPersonne() == person.getIdPersonne())
            {
                listPersonne.set(i, person);
                generateXMLFile();
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
            generateXMLFile();
            return true;
        }
        return false;
    }
}
