package com.cours.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cours.dao.IPersonneDao;
import com.cours.entities.Personne;

public class SqlPersonneDaoImpl implements IPersonneDao
{

    private static final Log log = LogFactory.getLog(SqlPersonneDaoImpl.class);
    
    Connection             connection      = null;
    boolean                dataBaseChanged = true;

    private List<Personne> listPersonne;

    private SqlPersonneDaoImpl()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            return;
        }

        if (null == connection)
        {
            try
            {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/base_personnes?autoReconnect=true&useSSL=false", "roger",
                        "password");
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                return;
            }
        }
        if (null == listPersonne && connection != null)
        {
            findAll();
            dataBaseChanged = false;
        }
    }

    private static SqlPersonneDaoImpl INSTANCE = new SqlPersonneDaoImpl();

    public static SqlPersonneDaoImpl getInstance()
    {
        return INSTANCE;
    }

    public List<Personne> findAll()
    {
        if (true == dataBaseChanged || listPersonne == null)
        {
            listPersonne = new ArrayList<Personne>();
            try
            {
                String queryString = "SELECT * FROM personne";

                PreparedStatement ptmt = connection.prepareStatement(queryString);
                
                ResultSet rs = ptmt.executeQuery(queryString);
                while (rs.next())
                {
                    int i = rs.getInt("idPersonne");
                    String firstname = rs.getString("Prenom");
                    String name = rs.getString("Nom");
                    Double poids = rs.getDouble("Poids");
                    Double taille = rs.getDouble("Taille");
                    String rue = rs.getString("Rue");
                    String ville = rs.getString("Ville");
                    String codePostal = rs.getString("CodePostal");

                    Personne p = new Personne(i, firstname, name, poids, taille, rue, ville, codePostal);
                    listPersonne.add(p);
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if(log.isDebugEnabled()) {log.debug(listPersonne);}
        return listPersonne;
    }

    public Personne findById(int id)
    {
        Personne personne = new Personne();
        if (true == dataBaseChanged || listPersonne == null)
        {
            try
            {
                ResultSet result = this.connection
                        .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                        .executeQuery("SELECT * FROM personne WHERE IdPersonne = " + id);
                if (result.first())
                    personne = new Personne(id, result.getString("Prenom"), result.getString("Nom"),
                            result.getDouble("Poids"), result.getDouble("Taille"), result.getString("Rue"),
                            result.getString("Ville"), result.getString("CodePostal"));
                connection.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            for (Personne p : listPersonne)
            {
                if (p.getIdPersonne() == id)
                {
                    if(log.isDebugEnabled()) {log.debug("Your base is up to date " + p);}
                    return p;
                }
            }
        }
        if(log.isDebugEnabled()) {log.debug(personne);}
        return personne;
    }

    public Personne create(Personne person)
    {
        try
        {
            String queryString = "INSERT INTO personne(Prenom, Nom, Poids, Taille, Rue, Ville, CodePostal) VALUES(?,?,?,?,?,?,?)";

            PreparedStatement ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, person.getPrenom());
            ptmt.setString(2, person.getNom());
            ptmt.setDouble(3, person.getPoids());
            ptmt.setDouble(4, person.getTaille());
            ptmt.setString(5, person.getRue());
            ptmt.setString(6, person.getVille());
            ptmt.setString(7, person.getCodePostal());
            ptmt.executeUpdate();
            connection.close();
            dataBaseChanged = true;
        }
        catch (SQLException e)
        {
            dataBaseChanged = false;
            e.printStackTrace();
        }
        if(log.isDebugEnabled()) {log.debug(person);}
        return person;
    }

    public Personne update(Personne person)
    {
        try
        {
            String queryString = "UPDATE student SET Prenom=?,Nom=?,Poids=?,Taille=?,Rue=?,Ville=?,CodePostal=?, WHERE idPersonne=?";
            PreparedStatement ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, person.getPrenom());
            ptmt.setString(2, person.getNom());
            ptmt.setDouble(3, person.getPoids());
            ptmt.setDouble(4, person.getTaille());
            ptmt.setString(5, person.getRue());
            ptmt.setString(6, person.getVille());
            ptmt.setString(7, person.getCodePostal());
            ptmt.setInt(8, person.getIdPersonne());
            ptmt.executeUpdate();
            connection.close();
            dataBaseChanged = true;
        }
        catch (SQLException e)
        {
            dataBaseChanged = false;
            e.printStackTrace();
        }
        if(log.isDebugEnabled()) {log.debug(person);}
        return person;
    }

    public boolean delete(Personne person)
    {
        try
        {
            String queryString = "DELETE FROM student WHERE idPersonne=?";
            PreparedStatement ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, person.getIdPersonne());
            ptmt.executeUpdate();
            connection.close();
            dataBaseChanged = true;
        }
        catch (SQLException e)
        {
            dataBaseChanged = false;
            e.printStackTrace();
            return false;
        }
        if(log.isDebugEnabled()) {log.debug("Deleted " + person);}
        return true;
    }
}
