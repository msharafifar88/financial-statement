package ir.ac.common.entity;


import ir.ac.core.annotation.UsecaseSupport;
import ir.ac.core.enumration.SubSystem;
import ir.ac.core.enumration.UsecaseType;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * Created by majid on 7/12/16.
 */
@Entity
@TableGenerator(name = "IndependentAccountSequenceGenerator" ,
        table = "CO_SEQUENCE" , pkColumnName = "TABLENAME" , valueColumnName = "CURRENTID" , pkColumnValue = "CM_INDEPENDENT_ACCOUNT" )
@Table(name = "CM_INDEPENDENT_ACCOUNT")
@NamedQueries({
        @NamedQuery(name = "findByName", query = "select independentAccount from CmIndependentAccount independentAccount where independentAccount.name=:name"),
        @NamedQuery(name = "findAllIndependentAccount", query = "select independentAccount from CmIndependentAccount independentAccount where independentAccount.active=true order by independentAccount.code asc "),
        @NamedQuery(name = "findAllActiveWithOrder", query = "select independentAccount from CmIndependentAccount independentAccount where independentAccount.active=true order by independentAccount.code asc "),
        @NamedQuery(name = "findFreeWithOrder", query = "select independentAccount from CmIndependentAccount independentAccount where independentAccount.free=true and independentAccount.active=true order by independentAccount.code asc "),
        @NamedQuery(name = "findAllActiveAndFreeAndNotSanamaWithOrder", query = "select independentAccount from CmIndependentAccount independentAccount where independentAccount.free=true and independentAccount.active=true and independentAccount.sanamaOnly=false order by independentAccount.code asc "),
        @NamedQuery(name = "findAllActiveAndNotSanamaWithOrder", query = "select independentAccount from CmIndependentAccount independentAccount where independentAccount.active=true and independentAccount.sanamaOnly=false order by independentAccount.code asc "),
        @NamedQuery(name = "findNotFreeWithOrder", query = "select independentAccount from CmIndependentAccount independentAccount where independentAccount.free=false and independentAccount.active=true order by independentAccount.code asc "),
        @NamedQuery(name = "lastIndependentAccountCode", query = "select independentAccount.code from CmIndependentAccount independentAccount order by independentAccount.code asc"),
        @NamedQuery(name = "findIndependentAccountByClass", query = "select independentAccount from CmIndependentAccount independentAccount where independentAccount.clazz=:clazz"),
        @NamedQuery(name = "findActiveIndependentAccountByClass", query = "select independentAccount from CmIndependentAccount independentAccount where independentAccount.clazz=:clazz and independentAccount.active=true order by independentAccount.code asc "),
        @NamedQuery(name = "findIndependentAccountHasSanamaTagName", query = "select independentAccount from CmIndependentAccount independentAccount where independentAccount.sanamaTagName is not null order by independentAccount.code asc "),
        @NamedQuery(name = "findIndependentAccountById", query = "select independentAccount from CmIndependentAccount independentAccount where independentAccount.id=:id"),
})
@Cacheable
@org.hibernate.annotations.Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@UsecaseSupport(subSystem = SubSystem.Common,usecaseType = UsecaseType.Process)
public class CmIndependentAccount extends AbstractCmIndependentAccount {
    public CmIndependentAccount() {
    }

}
