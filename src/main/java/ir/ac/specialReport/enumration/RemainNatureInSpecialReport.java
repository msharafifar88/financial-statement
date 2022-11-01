package ir.ac.specialReport.enumration;

import ir.ac.core.interfaces.Enumable;
import java.util.Arrays;
import java.util.List;

public enum RemainNatureInSpecialReport implements Enumable {

    remain("remain", "message.remainNatureEnum.type.remain"),
    debit("debit", "message.remainNatureEnum.type.debit"),
    credit("credit", "message.remainNatureEnum.type.credit"),
    currencyRemain("currencyRemain", "message.remainNatureEnum.type.currencyRemain"),
    currencyDebit("currencyDebit", "message.remainNatureEnum.type.currencyDebit"),
    currencyCredit("currencyCredit", "message.remainNatureEnum.type.currencyCredit"),
    officialCurrencyDebit("officialCurrencyDebit", "message.remainNatureEnum.type.officialCurrencyDebit"),
    officialCurrencyCredit("officialCurrencyCredit", "message.remainNatureEnum.type.officialCurrencyCredit"),
    officialCurrencyBalance("officialCurrencyBalance", "message.remainNatureEnum.type.officialCurrencyBalance");

    private final String key;
    private final String label;

    RemainNatureInSpecialReport(String key, String label) {
        this.label = label;
        this.key = key;
    }

    public String getKey() {
        return key;
    }
    public String getLabel() {
        return label;
    }

    public static RemainNatureInSpecialReport getValue (String key){
        if (key!=null){
            if (key.equals(remain.getKey())){
                return remain;
            }else if (key.equals(debit.getKey())){
                return debit;
            }else if (key.equals(credit.getKey())){
                return credit;
            }else if (key.equals(currencyRemain.getKey())){
                return currencyRemain;
            }else if (key.equals(currencyDebit.getKey())){
                return currencyDebit;
            }else if (key.equals(currencyCredit.getKey())){
                return currencyCredit;
            }else if (key.equals(officialCurrencyDebit.getKey())){
                return officialCurrencyDebit;
            }else if (key.equals(officialCurrencyCredit.getKey())){
                return officialCurrencyCredit;
            }else if (key.equals(officialCurrencyBalance.getKey())){
                return officialCurrencyBalance;
            }
        }
        return null;
    }

    public static List<RemainNatureInSpecialReport> findAll(){ return Arrays.asList(values());}

}
