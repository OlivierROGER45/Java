package com.cours.dao.factory;

import com.cours.dao.IPersonneDao;
import com.cours.dao.impl.CsvPersonneDaoImpl;
import com.cours.dao.impl.JsonPersonneDaoImpl;
import com.cours.dao.impl.ManualPersonneDaoImpl;
import com.cours.dao.impl.SqlPersonneDaoImpl;
import com.cours.dao.impl.XmlPersonneDaoImpl;

public interface InterfaceDaoFactory
{

 public enum FactoryType {MANUAL_DAO, CSV_DAO, XML_DAO, JSON_DAO, SQL_DAO};
    
    public static IPersonneDao getPersonneDao(FactoryType type)
    {
        IPersonneDao dao = null;

        switch (type)
        {
        case MANUAL_DAO:
            dao = ManualPersonneDaoImpl.getInstance();
            break;
        case CSV_DAO:
            dao = CsvPersonneDaoImpl.getInstance();
            break;
        case XML_DAO:
            dao = XmlPersonneDaoImpl.getInstance();
            break;
        case JSON_DAO:
            dao = JsonPersonneDaoImpl.getInstance();
            break;
        case SQL_DAO:
            dao = SqlPersonneDaoImpl.getInstance();
            break;
        }
        return dao;
    }
}
