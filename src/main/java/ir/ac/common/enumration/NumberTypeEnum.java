package ir.ac.common.enumration;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hossein on 3/7/17.
 */
public enum NumberTypeEnum {

    Numeric("Numeric","message.common.unit.numeric"),
    Decimal("Decimal","message.common.unit.decimal");

    private final String key;
    private final String name;

    NumberTypeEnum(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }
    public String getName() {
        return name;
    }

    public static  NumberTypeEnum getValue (String key){
        if (key!=null){
            if (key.equals(Numeric.getKey())){
                return Numeric;
            }else if (key.equals(Decimal.getKey())){
                return Decimal;
            }
        }
        return null;
    }

    public static List<NumberTypeEnum> findAll(){return Arrays.asList(values());}

}
