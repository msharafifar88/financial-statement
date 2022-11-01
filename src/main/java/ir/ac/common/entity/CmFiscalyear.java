package ir.ac.common.entity;

import ir.ac.common.interfaces.CmIndependent;
import ir.ac.core.annotation.UsecaseSupport;
import ir.ac.core.enumration.SubSystem;
import ir.ac.core.enumration.UsecaseType;

import javax.persistence.*;

/**
 * Created by majidmostafavi on 8/20/15.
 */
@Entity
@Cacheable
@Table(name = "CM_FISCALYEAR")
@NamedQueries({
        /*find by id*/
        @NamedQuery(name = "findYearById", query = "SELECT f FROM CmFiscalyear f WHERE f.id = :id"),
        @NamedQuery(name="findYearByDate",query="select fiscalyear from CmFiscalyear fiscalyear where fiscalyear.startDate<=:intendedDate and fiscalyear.endDate>=:intendedDate and fiscalyear.active=true order by fiscalyear.code asc "),
        @NamedQuery(name="countYearByDate",query="select count(fiscalyear) from CmFiscalyear fiscalyear where fiscalyear.startDate<=:intendedDate and fiscalyear.endDate>=:intendedDate and fiscalyear.active=true"),
        @NamedQuery(name="findFiscalYearByName",query="select fiscalyear from CmFiscalyear fiscalyear where fiscalyear.name=:name and fiscalyear.active=:true order by fiscalyear.code"),
        @NamedQuery(name="findFirstFiscalYear", query = "select fiscalyear from CmFiscalyear fiscalyear where " +
                "fiscalyear.startDate = (SELECT MAX(fiscalyear.startDate) FROM CmFiscalyear fiscalyear WHERE fiscalyear.active=:true) order by fiscalyear.code"),
        @NamedQuery(name = "countFiscalyearByNameOrCode", query = "select count(fiscalyear) from CmFiscalyear fiscalyear where fiscalyear.name=:name or fiscalyear.code=:code "),
        @NamedQuery(name = "findAllSortByYear",query = "select fiscalYear from CmFiscalyear fiscalYear order by fiscalYear.startDate desc "),
        @NamedQuery(name = "findLastFiscalYear",query = "select fiscalYear from CmFiscalyear fiscalYear order by fiscalYear.endDate desc "),
        @NamedQuery(name = "countTotalFiscalyear",query = "select count(fiscalYear) from CmFiscalyear fiscalYear"),
        @NamedQuery(name="findNextFiscalyears",query="select fiscalyear from CmFiscalyear fiscalyear where fiscalyear.startDate>=:intendedDate or fiscalyear.id=:id and fiscalyear.active=true order by fiscalyear.code"),
        @NamedQuery(name = "findFirstDateOfFirstFiscalyear",query = "select min(fiscalYear.startDate) from CmFiscalyear fiscalYear order by fiscalYear.startDate asc")
})
@UsecaseSupport(subSystem = SubSystem.Common,usecaseType = UsecaseType.Process)
public class CmFiscalyear extends AbstractCmFiscalyear implements CmIndependent {
    public CmFiscalyear() {
    }

}
