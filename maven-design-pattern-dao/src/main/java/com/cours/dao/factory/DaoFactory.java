package com.cours.dao.factory;

import com.cours.dao.AbstractPersonneDao;
import com.cours.dao.csv.CsvPersonneDao;
import com.cours.dao.manual.ManualPersonneDao;

public class DaoFactory
{
    public enum FactoryType {MANUAL_DAO, CSV_DAO, XML_DAO, JSON_DAO, SQL_DAO};
    
    public static AbstractPersonneDao getPersonneDao(FactoryType type)
    {
        AbstractPersonneDao dao = null;

        switch (type)
        {
        case MANUAL_DAO:
            dao = new ManualPersonneDao();
            break;
        case CSV_DAO:
            dao = new CsvPersonneDao();
            break;
        case XML_DAO:
            //dao = new Fedex(col, day);
            break;
        case JSON_DAO:
            //dao = new DHL(col, day);
            break;
        case SQL_DAO:
            //dao = new DHL(col, day);
            break;
        }
        return dao;
    }
}
