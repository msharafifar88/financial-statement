package ir.ac.specialReport.enumration;

import ir.ac.core.interfaces.Enumable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by armiiit on 8/20/18.
 */
public enum IndependentAccountEnum implements Enumable {

    AccountingType("accountingType", "message.accounting.account.accountingType"),
    Organization("organization","message.common.organization"),
    OrganizationType("organizationType","message.common.organizationKind.title"),
    DocumentSubject("documentSubject","message.accounting.documentSubject.name"),
    DocumentCode("documentCode","message.treasury.drawCheque.document.code"),
    DocumentDate("documentDate","message.treasury.drawCheque.document.date");


    private final String key;
    private final String label;

    IndependentAccountEnum(String key, String label) {
        this.key = key;
        this.label = label;
    }

    public static List<IndependentAccountEnum> findAll(){return Arrays.asList(values());}

    public static IndependentAccountEnum getValue(String key){
        if (key!=null){
            if (key.equals(AccountingType.getKey())){
                return AccountingType;
            } else if (key.equals(Organization.getKey())){
                return Organization;
            } else if (key.equals(OrganizationType.getKey())){
                return OrganizationType;
            } else if (key.equals(DocumentSubject.getKey())){
                return DocumentSubject;
            } else if (key.equals(DocumentCode.getKey())){
                return DocumentCode;
            }else if (key.equals(DocumentDate.getKey())){
                return DocumentDate;
            }
        }
        return null;
    }

    public String getKey() {
        return key;
    }
    public String getLabel() {
        return label;
    }
}
