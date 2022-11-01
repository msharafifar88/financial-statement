package ir.ac.specialReport.entity;

import ir.ac.core.annotation.UsecaseSupport;
import ir.ac.core.enumration.SubSystem;
import ir.ac.core.enumration.UsecaseType;

import javax.persistence.*;

/**
 * Created by shaghayegh on 7/29/17.
 */
@Entity
@Table(name = "AC_SPECIAL_REPORT_TYPE")
@NamedQueries({
        @NamedQuery(name = "findAllReportType",query = "select specialReportType from AcSpecialReportType specialReportType"),
        @NamedQuery(name = "findReportTypeByName",query = "select specialReportType from AcSpecialReportType specialReportType where specialReportType.name=:name"),
        @NamedQuery(name = "findReportTypeByCode",query = "select specialReportType from AcSpecialReportType specialReportType where specialReportType.code=:code"),
        @NamedQuery(name = "countReportTypeByNameOrCode",query = "select count(specialReportType) from AcSpecialReportType specialReportType where specialReportType.name=:name or specialReportType.code=:code"),
        @NamedQuery(name = "countReportTypeByNameOrCodeForEdit",query = "select count(specialReportType) from AcSpecialReportType specialReportType where specialReportType.id not in :id and (specialReportType.name like :name or specialReportType.code like :code)"),
})
@UsecaseSupport(subSystem = SubSystem.Accounting,usecaseType = UsecaseType.Process)
public class AcSpecialReportType extends AbstractAcSpecialReportType {

    public AcSpecialReportType() {
    }
}
