package com.dao.factory.complexe;

import com.cours.dao.IPersonneDao;
import com.cours.dao.impl.ManualPersonneDaoImpl;

public class ManualDaoFactory extends AbstractDaoFactory
{
    public IPersonneDao getPersonneDao()
    {
        return ManualPersonneDaoImpl.getInstance();
    }
}
