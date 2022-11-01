package ir.ac.common.service;


import ir.ac.common.dao.OrganizationDao;
import ir.ac.common.entity.CmOrganization;
import ir.ac.common.entity.CmOrganizationKind;
import ir.ac.common.entity.CmOrganizationType;
import ir.ac.common.entity.CmResultCountSP;
import ir.ac.common.enumration.OrganizationNatureEnum;
import ir.ac.core.exception.DuplicateDataException;
import ir.ac.core.exception.RelationDataException;
import ir.ac.core.exception.SPValidationException;
import ir.ac.core.exception.SaveRecordException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by majid on 7/16/16.
 */
@RequestScoped
public class OrganizationService {
    @Inject
    OrganizationDao organizationDao;

    public void create(CmOrganization organization) throws DuplicateDataException, SaveRecordException {
        if (canSave(organization)) {
            organizationDao.create(organization);
        }
    }

    public void edit(CmOrganization organization) throws DuplicateDataException, RelationDataException,SaveRecordException, SPValidationException {
        CmResultCountSP resultCountSP = organizationDao.organizationValidation(organization.getId(),1l);
        if (resultCountSP.getResultCount() == 0l) {
            if (canEdit(organization)) {
                organizationDao.edit(organization);
            }
        } else {
            throw new SPValidationException(resultCountSP.getResultName());
        }
    }

    public void editTransfer(CmOrganization organization) throws DuplicateDataException,RelationDataException,SaveRecordException{
            if (canEdit(organization)) {
                organizationDao.edit(organization);
            }
    }

    public void limitedEdit(CmOrganization organization) throws DuplicateDataException,RelationDataException,SaveRecordException {
        if (organizationDao.countByNameForEdit(organization) == 0l) {
            organizationDao.edit(organization);
        } else {
            throw new DuplicateDataException();
        }
    }

    /* find Organization ID*/

    public CmOrganization findOrganizationByID(Long id) {
        try {
            CmOrganization organization = organizationDao.findById(id);
            return organization;
        } catch (NullPointerException e) {
            return null;
        } catch (NoResultException e) {
            return null;
        }
    }

    public void editCostCenterOrganization(CmOrganization organization) throws DuplicateDataException,RelationDataException,SaveRecordException {
        organizationDao.edit(organization);
    }

    public void editLeaf(CmOrganization organization) throws DuplicateDataException,RelationDataException,SaveRecordException{
        organizationDao.edit(organization);
    }

    public void delete(CmOrganization organization) throws RelationDataException, SPValidationException {
        if (canDelete(organization)) {
            organization.setActive(true);
//            organizationDao.delete(organization);
            organizationDao.deleteNativeQuery(organization.getId());
        }
    }

    public List<CmOrganization> findAllOrganization(CmOrganization organization){
        try{
            return organizationDao.findAll(organization);
        }catch (Exception e){
            //logger.error("No Result" , e);
            return new ArrayList<CmOrganization>(0);
        }
    }

    public List<CmOrganization> findOrganizationByPathcode(CmOrganization organization){
        try{
            return organizationDao.findOrganizationByPathcode(organization);
        }catch (Exception e){
            //logger.error("No Result" , e);
            return new ArrayList<CmOrganization>(0);
        }
    }

    public List<CmOrganization> findOrganizationByPathcode(String organizationPathCode){
        try{
            return organizationDao.findOrganizationByPathcode(organizationPathCode);
        }catch (Exception e){
            //logger.error("No Result" , e);
            return new ArrayList<CmOrganization>(0);
        }
    }

    /*public List<CmOrganization> findAllOrganizationWithAccountingType(CmOrganization organization){
        try {
            return organizationDao.findAllOrganizationWithAccountingType(organization);
        }catch (Exception e){
            logger.error("No Result" , e);
            return new ArrayList<>(0);
        }
    }*/

    public CmOrganization findByName(String string){
        try {
            return organizationDao.findByName(string);
        }catch (Exception e){
            return new CmOrganization();
        }
    }

    public List<CmOrganization> findListByName(CmOrganization organization, String name){
        try {
            return organizationDao.findListByName(organization, name);
        }catch (Exception e){
            return new ArrayList<CmOrganization>(0);
        }
    }

    public List<CmOrganization> findListByCode(CmOrganization organization, Long code){
        try {
            return organizationDao.findListByCode(organization, code);
        }catch (Exception e){
            return new ArrayList<CmOrganization>(0);
        }
    }

    public List<CmOrganization> findByPath(String path){
        try {
            return organizationDao.findByPath(path);
        }catch (Exception e){
            return new ArrayList<CmOrganization>(0);
        }
    }

    public List<CmOrganization> findByChildren(CmOrganization organization){
        try {
            return organizationDao.findOrganizationByChildren(organization);
        }catch (Exception e){
            return new ArrayList<CmOrganization>(0);
        }
    }

    public boolean disableObject(CmOrganization organization) throws Exception{
        return organizationDao.disableObject(organization);
    }

    public boolean enableObject(CmOrganization organization) throws Exception{
        return organizationDao.enableObject(organization);
    }

    public boolean canSave(CmOrganization organization) throws DuplicateDataException {
        boolean b = false;
        if (organizationDao.countByName(organization) == 0l){
            b =  true;
        }else {
            throw new DuplicateDataException();
        }
        if (organizationDao.countByCode(organization) == 0l){
            b =  true;
        }else {
            throw new DuplicateDataException();
        }
        return b;
    }

    public boolean canEdit(CmOrganization organization) throws DuplicateDataException,RelationDataException,SaveRecordException{
        boolean b = false;
        if (organizationDao.countByNameForEdit(organization) == 0l){
            b =  true;
        }else {
            throw new DuplicateDataException();
        }
        if (organizationDao.countByCodeForEdit(organization) == 0l){
            b =  true;
        }else {
            throw new DuplicateDataException();
        }
        return b;
    }

    public boolean canDelete(CmOrganization organization) throws RelationDataException,SPValidationException{

        boolean b = false;
        CmResultCountSP resultCountSP = organizationDao.organizationValidation(organization.getId(),1l);
        if (resultCountSP.getResultCount() == 0l){
            b=true;
        } else {
            throw new SPValidationException(resultCountSP.getResultName());
        }
        return b;

    }

    public List<CmOrganization> findByIndependentAccounting(){
        try{
            return organizationDao.findByIndependentAccounting();
        }catch (Exception e){
            return new ArrayList<>(0);
        }
    }

    public List<CmOrganization> findByIndependentAccountingAndAccounting(){
        try{
            return organizationDao.findByIndependentAccountingAndAccounting();
        }catch (Exception e){
            return new ArrayList<>(0);
        }
    }

    public List<CmOrganization> findByIndependentAccountingAndAccountingByParentOrganization(CmOrganization organization){
        try{
            return organizationDao.findByIndependentAccountingAndAccountingByParentOrganization(organization);
        }catch (Exception e){
            return new ArrayList<>(0);
        }
    }


    public List<CmOrganization> findOrganizationByParent(CmOrganization organization){
        try {
            return organizationDao.findOrganizationByParent(organization);
        }catch (Exception e){
            return new ArrayList<>(0);
        }
    }

    public List<CmOrganization> findOrganizationByIndependentAccounting(CmOrganization organization){
        try {
            return organizationDao.findOrganizationByIndependentAccounting(organization);
        }catch (Exception e){
            e.getMessage();
            return new ArrayList<>(0);
        }
    }



    public List<CmOrganization> findOrganizationByIndependentAccountingOrDependent(CmOrganization organization){
        try {
            return organizationDao.findOrganizationByIndependentAccountingOrDependent(organization);
        }catch (Exception e){
            return new ArrayList<>(0);
        }
    }

    public List<CmOrganization> findOrganizationsByIndependentAccounting(){
        try {
            return organizationDao.findOrganizationsByIndependentAccounting();
        }catch (Exception e){
            return new ArrayList<>(0);
        }
    }

    public List<CmOrganization> findOrganizationsByDependent(CmOrganization organization){
        try {
            return organizationDao.findOrganizationsByDependent(organization);
        }catch (Exception e){
            return new ArrayList<>(0);
        }
    }

    public List<CmOrganization> findOrganizationByIndependentAccountingOrderByPath(CmOrganization organization){
        try {
            return organizationDao.findOrganizationByIndependentAccountingOrderByPath(organization);
        }catch (Exception e){
            return new ArrayList<>(0);
        }
    }

    public List<CmOrganization> findIndependentAccountOrganizationsByName(CmOrganization organization, String name){
        try {
            return organizationDao.findIndependentAccountOrganizationsByName(organization, name);
        }catch (Exception e){
            return new ArrayList<CmOrganization>(0);
        }
    }

    public List<CmOrganization> findIndependentAccountOrganizationsByCode(CmOrganization organization, Long code){
        try {
            return organizationDao.findIndependentAccountOrganizationsByCode(organization, code);
        }catch (Exception e){
            return new ArrayList<CmOrganization>(0);
        }
    }

    /*public List<CmOrganization> findIndependentAccountOrgByName(String name){
        try {
            return organizationDao.findIndependentAccountOrgByName(name);
        }catch (Exception e){
            return new ArrayList<CmOrganization>(0);
        }
    }

    public List<CmOrganization> findIndependentAccountOrgByCode(Long code){
        try {
            return organizationDao.findIndependentAccountOrgByCode(code);
        }catch (Exception e){
            return new ArrayList<CmOrganization>(0);
        }
    }*/

    public List<CmOrganization> findByIndependentAccountingWihoutCurrentOrganization(CmOrganization organization){
        try{
            return organizationDao.findByIndependentAccountingWihoutCurrentOrganization(organization);
        }catch (Exception e){
            return new ArrayList<>(0);
        }

    }

    /*public CmOrganization findById(Long id){
        try {
            return organizationDao.findById(id);
        }catch (Exception e){
           // logger.error("No Result" , e);
            return new CmOrganization();
        }
    }*/

    public String findOrganizationNameById(Long id) {
        return organizationDao.findOrganizationNameById(id);
    }

    public List<CmOrganization> findLastLevelOrganization(String pathCode){
        try {
            return organizationDao.findLastLevelOrganization(pathCode);
        }catch (Exception e){
            //logger.error("No Result" , e);
            return new ArrayList<>(0);
        }
    }
//    public List<CmOrganization> findByListNotifyMaster(TrNotifyMaster notifyMaster){
//        try {
//            return organizationDao.findByListNotifyMaster(notifyMaster);
//        }catch (Exception e){
//            logger.error("No Result" , e);
//            return new ArrayList<>(0);
//        }
//    }

    public List<CmOrganization> findAll(){
        try {
            return organizationDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<CmOrganization> findAllActive(){
        try {
            return organizationDao.findAllActive();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /*public List<CmOrganization> findListIndependentAccountingByName(String name){
        try {
            return organizationDao.findListIndependentAccountingByName(name);
        }catch (Exception e){
            return new ArrayList<CmOrganization>(0);
        }
    }*/

    /*public List<CmOrganization> findListIndependentAccountingByCode(Long code){
        try {
            return organizationDao.findListIndependentAccountingByCode(code);
        }catch (Exception e){
            return new ArrayList<CmOrganization>(0);
        }
    }*/




    public List<CmOrganization> findOrganization(String organizationName, Long organizationCode,CmOrganization organization,
                                                 CmOrganizationKind organizationKind, CmOrganizationType organizationType,
                                                 OrganizationNatureEnum organizationNatureEnum, boolean deActive,
                                                 CmOrganization searchOrganization, boolean accounting){
        try {
            return organizationDao.findOrganization(organization,organizationName,organizationCode,organizationKind,organizationType,organizationNatureEnum,deActive,searchOrganization,accounting);
        }catch (Exception e){
            e.printStackTrace();
           // logger.error("No Result" , e);
            return new ArrayList<>();
        }
    }



    public List<CmOrganization> findIndependentOrganizationsWithOrganizationAndOrganizationTypes(CmOrganization organization, List<CmOrganizationType> organizationTypes){
        try {
            return organizationDao.findIndependentOrganizationsWithOrganizationAndOrganizationTypes(organization,organizationTypes);
        } catch (Exception e){
            e.printStackTrace();
           // logger.error("No Result" , e);
            return new ArrayList<>();
        }
    }

    /*public List<OrganizationCostCenterReportWrapper> findOrganizationCostCenterWrapperByOrganization(CmOrganization organization , CmCostCenter cmCostCenter){
      return  organizationDao.findOrganizationCostCenterWrapperByOrganization(organization,cmCostCenter);
    }*/

    public Long countActiveChildByParent(String pathCode) {
        try{
            return organizationDao.countActiveChildByParent(pathCode);
        }catch (Exception e){
            return 0l;
        }
    }

    public List<CmOrganization> traversOnOrganization(CmOrganization organization){
        List<CmOrganization> organizations = new ArrayList<>();
        organizations.add(organization);
        findByParent(organizations,organization);
        return organizations;
    }

    private void findByParent(List<CmOrganization> organizations,CmOrganization organization){
        if(organization.getParent() != null){
            CmOrganization newOrganization = new CmOrganization();
            newOrganization = organizationDao.findById(organization.getParent().getId());
            organizations.add(newOrganization);
            findByParent(organizations,newOrganization);
        }
    }

    public long countOrganizationById(Long id){
        try{
            return organizationDao.countOrganizationById(id);
        }catch (Exception e){
            return 0l;
        }
    }

    public void disableObjects(CmOrganization organization) throws Exception{
        organizationDao.disableObjects(organization);
    }

    public void enableObjects(CmOrganization organization) throws Exception{
        organizationDao.enableObjects(organization);
    }





    /*public List<CmOrganization> findOrganizationsWithStatement(CmPersonnel personnel){
        try {
            return organizationDao.findOrganizationsWithStatement(personnel);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("No Result" , e);
            return new ArrayList<>();
        }
    }*/

    public void organizationPathFix(CmOrganization organization, CmOrganization parentOrganization){
        organizationDao.organizationPathFix(organization,parentOrganization);
    }

    public void organizationJSONAndPathFix(List<CmOrganization> organizationList){
        organizationDao.organizationJSONAndPathFix(organizationList);
    }

    public CmOrganization findParentOrganization(){
        try {
            return organizationDao.findParentOrganization();
        }catch (Exception e){
            return new CmOrganization();
        }
    }

}
