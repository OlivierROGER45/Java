package com.dao.factory.complexe;

import com.cours.dao.IPersonneDao;

public abstract class AbstractDaoFactory
{
    abstract public IPersonneDao getPersonneDao();
    
    public enum FactoryType {MANUAL_DAO, CSV_DAO, XML_DAO, JSON_DAO, SQL_DAO};
    
    public static AbstractDaoFactory getDaoFactory(FactoryType type)
    {
        AbstractDaoFactory dao = null;

        switch (type)
        {
        case MANUAL_DAO:
            dao = new ManualDaoFactory();
            break;
        case CSV_DAO:
            dao = new CsvDaoFactory();
            break;
        case XML_DAO:
            dao = new XmlDaoFactory();
            break;
        case JSON_DAO:
            dao = new JsonDaoFactory();
            break;
        case SQL_DAO:
            dao = new SqlDaoFactory();
            break;
        }
        return dao;
    }
}
