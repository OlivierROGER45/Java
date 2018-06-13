package com.cours.dao.factory;

import com.cours.dao.AbstractPersonneDao;
import com.cours.dao.csv.CsvPersonneDao;
import com.cours.dao.json.JsonPersonneDao;
import com.cours.dao.manual.ManualPersonneDao;
import com.cours.dao.sql.SqlPersonneDao;
import com.cours.dao.xml.XmlPersonneDao;

public class DaoFactory
{
    public enum FactoryType {MANUAL_DAO, CSV_DAO, XML_DAO, JSON_DAO, SQL_DAO};
    
    public static AbstractPersonneDao getPersonneDao(FactoryType type)
    {
        AbstractPersonneDao dao = null;

        switch (type)
        {
        case MANUAL_DAO:
            dao = ManualPersonneDao.getInstance();
            break;
        case CSV_DAO:
            dao = CsvPersonneDao.getInstance();
            break;
        case XML_DAO:
            dao = XmlPersonneDao.getInstance();
            break;
        case JSON_DAO:
            dao = JsonPersonneDao.getInstance();
            break;
        case SQL_DAO:
        	dao = SqlPersonneDao.getInstance();
            break;
        }
        return dao;
    }
}
