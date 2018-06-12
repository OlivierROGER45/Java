package com.dao.factory.complexe;

import com.cours.dao.IPersonneDao;
import com.cours.dao.impl.SqlPersonneDaoImpl;

public class SqlDaoFactory extends AbstractDaoFactory
{
    public IPersonneDao getPersonneDao()
    {
        return SqlPersonneDaoImpl.getInstance();
    }
}
