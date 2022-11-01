package ir.ac.common.entity;


import ir.ac.common.interfaces.CmIndependent;
import ir.ac.core.annotation.UsecaseSupport;
import ir.ac.core.enumration.SubSystem;
import ir.ac.core.enumration.UsecaseType;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * Created by Mohsen Mostafavi on 7/2/2016.
 */
@Entity

@Table(name = "CM_UNIT")
@NamedQueries({
        @NamedQuery(name = "findByNumberType", query = "select unit from CmUnit unit where unit.numberTypeEnum=:numberTypeEnum"),
        @NamedQuery(name = "findUnitByName", query = "select unit from CmUnit unit where unit.name=:name"),
        @NamedQuery(name = "findUnitByCode", query = "select unit from CmUnit unit where unit.codeDigit=:code"),
        @NamedQuery(name = "countUnit", query = "select count(unit) from CmUnit unit where unit.name=:name or unit.codeDigit=:code"),
        @NamedQuery(name = "findAllSortedInUnit",query = "select unit from CmUnit unit order by unit.codeDigit asc"),
        @NamedQuery(name = "countUnitByNameOrCodeForEdit", query = "select count(unit) from CmUnit unit where unit.id not in :id and (unit.name=:name)"),
        @NamedQuery(name = "findLastCodeOfUnit" , query = "select unit.codeDigit from CmUnit unit order by unit.codeDigit desc")

})
@Cacheable
@org.hibernate.annotations.Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@UsecaseSupport(subSystem = SubSystem.Common,usecaseType = UsecaseType.Process)
public class CmUnit extends AbstractCmUnit implements CmIndependent<CmUnit> {
    public CmUnit(){
    }


}
