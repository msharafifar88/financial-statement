package ir.ac.financialStatement.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "FS_CONFIGURATION")
@NamedQueries({
        @NamedQuery(name = "findAllConfiguration",query = "select conf from FSConfiguration  conf  order by conf.code")
       // @NamedQuery(name = "findAllConfiguration",query = "select conf from FSConfiguration  conf where conf.fiscalyear=:year and conf.active=true")


})
public class FSConfiguration extends AbstractFSConfiguration {

}
