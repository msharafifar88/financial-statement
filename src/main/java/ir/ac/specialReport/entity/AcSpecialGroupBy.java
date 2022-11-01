package ir.ac.specialReport.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by majid on 6/6/17.
 */
@Entity
@Table(name = "AC_SPECIAL_REPORT_ROW")
public class AcSpecialGroupBy extends AcSpecialElement {

    public AcSpecialGroupBy() {
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
