package ir.ac.common.interfaces;


import ir.ac.core.interfaces.Treeable;

/**
 * Created by majid on 7/12/16.
 */

public interface CmIndependent <E> extends Treeable<Long> {

    Long getId();
    String getCode();
    String getName();
    void setName(String s);
    boolean isActive();

    default Long getParentId(){return null;}

    default String getPathId() {
        return  "#"+ String.valueOf(getId()) ;
    }
    default String getPathCode() {
        return  "#"+ getCode() ;
    }

    default E getParent(){
        return null ;
    }


}
