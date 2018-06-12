package com.dao.factory.complexe;

import com.cours.dao.IPersonneDao;
import com.cours.dao.impl.XmlPersonneDaoImpl;

public class XmlDaoFactory extends AbstractDaoFactory
{
    public IPersonneDao getPersonneDao()
    {
        return XmlPersonneDaoImpl.getInstance();
    }

}
