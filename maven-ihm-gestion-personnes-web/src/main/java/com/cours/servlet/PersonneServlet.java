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

public class PersonneServlet extends HttpServlet
{

    private static final long serialVersionUID = -7414702099433882522L;
    private static final Log log = LogFactory.getLog(PersonneServlet.class);
    public AbstractDaoFactory factoryDao;

    @Override
    public void init() throws ServletException
    {
        if(log.isDebugEnabled()) {log.debug("init()");}
        factoryDao = AbstractDaoFactory.getDaoFactory(FactoryType.SQL_DAO);
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//    {
//        if(log.isDebugEnabled()) {log.debug("doPost");}
//        List<Personne> l = factoryDao.getPersonneDao().findAll();
//
//        request.setAttribute("listPersonne", l);
//
//        this.getServletContext().getRequestDispatcher("/pages/allPersonnes.jsp").forward(request, response);
//    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if(log.isDebugEnabled()) {log.debug("doGet");}
        List<Personne> l = factoryDao.getPersonneDao().findAll();

        request.setAttribute("listPersonne", l);
        this.getServletContext().getRequestDispatcher("/pages/allPersonnes.jsp").forward(request, response);
    }

    // @Override
    // protected void doPost(HttpServletRequest request, HttpServletResponse
    // response)
    // throws ServletException, IOException {
    // String userName = request.getParameter("userName");
    // String userEmail = request.getParameter("userEmail");
    // String userMessage = request.getParameter("userMessage");
    // System.out.println("userName: " + userName + ", userEmail: " + userEmail + ",
    // userMessage: " + userMessage);
    // request.setAttribute("userName", userName);
    // request.setAttribute("userEmail", userEmail);
    // request.setAttribute("userMessage", userMessage);
    // this.getServletContext().getRequestDispatcher("/pages/ConfirmationInscription.jsp").forward(request,
    // response);
    // }

    // @Override
    // protected void doPost(HttpServletRequest request, HttpServletResponse
    // response)
    // throws ServletException, IOException {
    // String lastname = request.getParameter("lastname");
    // String firstname = request.getParameter("firstname");
    // System.out.println("lastname: " + lastname + ", firstname: " + firstname );
    // request.setAttribute("lastname", lastname);
    // request.setAttribute("firstname", firstname);
    // this.getServletContext().getRequestDispatcher("/pages/index.jsp").forward(request,
    // response);
    // }

}
