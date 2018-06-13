package com.dao.factory.complexe;

import com.cours.dao.IPersonneDao;

public abstract class AbstractDaoFactory
{
    abstract IPersonneDao getPersonneDao();
    
    public enum FactoryType {MANUAL_DAO, CSV_DAO, XML_DAO, JSON_DAO, SQL_DAO};
    
    public static AbstractDaoFactory getPersonneDao(FactoryType type)
    {
        AbstractDaoFactory dao = null;

        switch (type)
        {
        case MANUAL_DAO:
            dao = new ManualDaoFactory().getPersonneDao(type);
            break;
        case CSV_DAO:
            dao = new CsvDaoFactory().getPersonneDao(type);
            break;
        case XML_DAO:
            dao = new XmlDaoFactory().getPersonneDao(type);
            break;
        case JSON_DAO:
            dao = new JsonDaoFactory().getPersonneDao(type);
            break;
        case SQL_DAO:
            dao = new SqlDaoFactory().getPersonneDao(type);
            break;
        }
        return dao;
    }
}
