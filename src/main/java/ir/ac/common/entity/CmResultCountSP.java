package ir.ac.common.entity;

import javax.persistence.*;

@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "projectValidation",procedureName = "CM_SP_Validation_Project",resultClasses = CmResultCountSP.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "P_ID"),
                        @StoredProcedureParameter(name = "Result", mode = ParameterMode.REF_CURSOR, type = Void.class)
                }),

        @NamedStoredProcedureQuery(name = "resourceValidation",procedureName = "CM_SP_Validation_Resource",resultClasses = CmResultCountSP.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "P_ID"),
                        @StoredProcedureParameter(name = "Result", mode = ParameterMode.REF_CURSOR, type = Void.class)
                }),

        @NamedStoredProcedureQuery(name = "organizationValidation",procedureName = "CM_SP_Validation_Organization",resultClasses = CmResultCountSP.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "P_ID"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "P_CHK_PARENT"),
                        @StoredProcedureParameter(name = "Result", mode = ParameterMode.REF_CURSOR, type = Void.class)
                }),

//        @NamedStoredProcedureQuery(name = "supplierValidation",procedureName = "CM_SP_Validation_Supplier",resultClasses = CmResultCountSP.class,
//                parameters = {
//                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "P_ID"),
//                        @StoredProcedureParameter(name = "Result", mode = ParameterMode.REF_CURSOR, type = Void.class)
//                }),
        @NamedStoredProcedureQuery(name = "personValidation",procedureName = "CM_SP_Validation_Person",resultClasses = CmResultCountSP.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "P_ID"),
                        @StoredProcedureParameter(name = "Result", mode = ParameterMode.REF_CURSOR, type = Void.class)
                }),

        @NamedStoredProcedureQuery(name = "budgetValidation",procedureName = "CM_SP_Validation_Budget",resultClasses = CmResultCountSP.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "P_ID"),
                        @StoredProcedureParameter(name = "Result", mode = ParameterMode.REF_CURSOR, type = Void.class)
                }),

        @NamedStoredProcedureQuery(name = "contractValidation",procedureName = "CM_SP_Validation_Contract",resultClasses = CmResultCountSP.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "P_ID"),
                        @StoredProcedureParameter(name = "Result", mode = ParameterMode.REF_CURSOR, type = Void.class)
                }),
        @NamedStoredProcedureQuery(name = "commonParameterValidation",procedureName = "CM_SP_Validation_CM_PARAMETER",resultClasses = CmResultCountSP.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "P_ID"),
                        @StoredProcedureParameter(name = "Result", mode = ParameterMode.REF_CURSOR, type = Void.class)
                }),
        @NamedStoredProcedureQuery(name = "costRevenueSubjectValidation",procedureName = "CM_SP_Validation_CostRev",resultClasses = CmResultCountSP.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "P_ID"),
                        @StoredProcedureParameter(name = "Result", mode = ParameterMode.REF_CURSOR, type = Void.class)
                }),
        @NamedStoredProcedureQuery(name = "validationDocument",procedureName = "CM_SP_Validation_Document",resultClasses = CmResultCountSP.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "P_ID_List"),
                        @StoredProcedureParameter(name = "Result", mode = ParameterMode.REF_CURSOR, type = Void.class)
                }),
        @NamedStoredProcedureQuery(name = "sanama",procedureName = "ac_sp_Modify_Sanama_Sub_Detail",resultClasses = CmResultCountSP.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "P_Fiscalyear_ID"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "P_Organization_ID"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "P_Accounting_Type"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "P_INDEPENDENT_ACCOUNT_ID"),
                        @StoredProcedureParameter(name = "Result", mode = ParameterMode.REF_CURSOR, type = Void.class)
                }),
        @NamedStoredProcedureQuery(name = "independentRelationValidation",procedureName = "CM_SP_Validation_Relation",resultClasses = CmResultCountSP.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "P_ID"),
                        @StoredProcedureParameter(name = "Result", mode = ParameterMode.REF_CURSOR, type = Void.class)
                }),
        @NamedStoredProcedureQuery(name ="goodsPropertyValidation",procedureName = "CM_SP_Validation_GOODSPROPRTY",resultClasses = CmResultCountSP.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "P_ID"),
                        @StoredProcedureParameter(name = "Result", mode = ParameterMode.REF_CURSOR, type = Void.class)
                } ),
        @NamedStoredProcedureQuery(name = "fundValidation",procedureName = "CM_SP_VALIDATION_FUND",resultClasses = CmResultCountSP.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "P_ID"),
                        @StoredProcedureParameter(name = "Result", mode = ParameterMode.REF_CURSOR, type = Void.class)
                })

})

public class CmResultCountSP {

    private Long id;
    private Long resultCount;
    private String resultName;

    public CmResultCountSP() {
    }


    @Id
    @Column(name = "ID")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "Result_Count")
    public Long getResultCount() {
        return resultCount;
    }
    public void setResultCount(Long resultCount) {
        this.resultCount = resultCount;
    }

    @Column(name = "Result_NAME")
    public String getResultName() {
        return resultName;
    }
    public void setResultName(String resultName) {
        this.resultName = resultName;
    }
}