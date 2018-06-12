package com.dao.factory.complexe;

import com.cours.dao.IPersonneDao;
import com.cours.dao.impl.CsvPersonneDaoImpl;

public class CsvDaoFactory extends AbstractDaoFactory
{
    public IPersonneDao getPersonneDao()
    {
        return CsvPersonneDaoImpl.getInstance();
    }
}
