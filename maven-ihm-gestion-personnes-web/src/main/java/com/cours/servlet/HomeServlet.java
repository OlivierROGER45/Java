package com.cours.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cours.entities.Personne;
import com.dao.factory.complexe.AbstractDaoFactory;
import com.dao.factory.complexe.AbstractDaoFactory.FactoryType;

public class HomeServlet extends HttpServlet
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final Log  log = LogFactory.getLog(HomeServlet.class);
    public AbstractDaoFactory factoryDao;

    @Override
    public void init() throws ServletException
    {
        if (log.isDebugEnabled())
        {
            log.debug("init()");
        }
        factoryDao = AbstractDaoFactory.getDaoFactory(FactoryType.SQL_DAO);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if(log.isDebugEnabled()) {log.debug("doGet");}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");

        if(log.isDebugEnabled()) {log.debug("firstname: " + firstname + ", lastname: " + lastname);}
        List<Personne> l = factoryDao.getPersonneDao().findAll();

        for (Personne p : l)
        {
            if (p.getNom().toLowerCase().equals(lastname.toLowerCase()) && p.getPrenom().toLowerCase().equals(firstname.toLowerCase()))
            {
                request.setAttribute("personne", p);
                request.setAttribute("listPersonne", l);
                
                if(log.isDebugEnabled()) {log.debug("Personne " + p + " authentifie");}
                this.getServletContext().getRequestDispatcher("/pages/allPersonnes.jsp").forward(request, response);
            }
        }

    }

}
