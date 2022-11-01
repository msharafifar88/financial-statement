
package ir.ac.specialReport.enumration;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shaghayegh on 1/25/17.
 */
public enum AccountBalanceTypeEnum {

    nothing("nothing", "message.accountBalanceType.type.nothing"),
    debtor("debtor", "message.accountBalanceType.type.debtor"),
    creditor("creditor", "message.accountBalanceType.type.creditor");

    private final String key;
    private final String name;

    AccountBalanceTypeEnum(String key, String name) {
        this.name = name;
        this.key = key;
    }

    public String getKey() {
        return key;
    }
    public String getName() {
        return name;
    }

    public static AccountBalanceTypeEnum getValue (String key){
        if (key!=null){
            if (key.equals(nothing.getKey())){
                return nothing;
            }else if (key.equals(debtor.getKey())){
                return debtor;
            }else if (key.equals(creditor.getKey())){
                return creditor;
            }
        }
        return null;
    }

    public static List<AccountBalanceTypeEnum> findAll(){ return Arrays.asList(values());}

}
