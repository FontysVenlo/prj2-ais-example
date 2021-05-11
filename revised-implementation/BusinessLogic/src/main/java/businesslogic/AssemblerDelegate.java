/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package businesslogic;

import genericdao.dao.DAOFactory;

/**
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
public interface AssemblerDelegate {
    public abstract CustomerManager getCustomerManager();
}
