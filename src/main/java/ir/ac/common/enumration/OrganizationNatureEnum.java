package ir.ac.common.enumration;

import ir.ac.core.interfaces.Enumable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hossein on 3/8/17.
 */
public enum OrganizationNatureEnum implements Enumable {

    IndependentAccounting("independentAccounting", "message.organization.nature.independentAccounting",true),
    Dependent("dependent", "message.organization.nature.dependent",false),
    Session("session","message.organization.nature.session",false);

    private final String key;
    private final String label;
    private boolean isCenter;

    OrganizationNatureEnum(String key, String label, boolean isCenter) {
        this.key = key;
        this.label = label;
        this.isCenter = isCenter;
    }

    public static  OrganizationNatureEnum getValue (String key){
        if (key!=null){
            if (key.equals(IndependentAccounting.getKey())){
                return IndependentAccounting;
            }else if (key.equals(Dependent.getKey())){
                return Dependent;
            }else if (key.equals(Session.getKey())){
                return Session;
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

    public boolean isCenter() {
        return isCenter;
    }

    public static List<OrganizationNatureEnum> getCenterNatures(){
        List<OrganizationNatureEnum> centerNatures = new ArrayList<>(0);
        for(OrganizationNatureEnum organizationNatureEnum : values()){
            if(organizationNatureEnum.isCenter()){
                centerNatures.add(organizationNatureEnum);
            }
        }
        return centerNatures;
    }

    public static List<OrganizationNatureEnum> getOrganizationNatures(){
        List<OrganizationNatureEnum> organizationNatures = new ArrayList<>(0);
        for(OrganizationNatureEnum organizationNatureEnum : values()){
            if(!organizationNatureEnum.isCenter()){
                organizationNatures.add(organizationNatureEnum);
            }
        }
        return organizationNatures;
    }

    public static List<OrganizationNatureEnum> findAll() {
            return Arrays.asList(values());
        }

}
