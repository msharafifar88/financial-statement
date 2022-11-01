package ir.ac.common.entity;


import ir.ac.common.interfaces.FiscalyearSupport;
import ir.ac.core.entity.AbstractEntity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * Created by majid on 9/26/16.
 */
@MappedSuperclass
public abstract class BaseFiscalyearEntity extends AbstractEntity implements FiscalyearSupport {

    @ManyToOne
    @JoinColumn(name = "CM_FISCALYEAR_ID", unique = false, nullable = false, insertable = true, updatable = true)
    CmFiscalyear fiscalyear;
    @Override
    public void setCmFiscalyear(CmFiscalyear fiscalyear) {
        this.fiscalyear=fiscalyear;
    }
    @Override
    public CmFiscalyear getCmFiscalyear() {
        return fiscalyear;
    }


}
