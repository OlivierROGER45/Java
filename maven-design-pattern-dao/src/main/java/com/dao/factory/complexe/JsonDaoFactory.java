package com.dao.factory.complexe;

import com.cours.dao.IPersonneDao;
import com.cours.dao.impl.JsonPersonneDaoImpl;

public class JsonDaoFactory extends AbstractDaoFactory
{
    public IPersonneDao getPersonneDao()
    {
        return JsonPersonneDaoImpl.getInstance();
    }
}
