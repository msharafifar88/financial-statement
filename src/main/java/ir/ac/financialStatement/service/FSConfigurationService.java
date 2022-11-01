package ir.ac.financialStatement.service;

import ir.ac.common.entity.CmFiscalyear;
import ir.ac.core.exception.DuplicateDataException;
import ir.ac.core.exception.RelationDataException;
import ir.ac.core.exception.SaveRecordException;
import ir.ac.financialStatement.dao.FSConfigurationDao;
import ir.ac.financialStatement.entity.FSConfiguration;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequestScoped

public class FSConfigurationService {

    @Inject
    FSConfigurationDao configurationDao;


    public List<FSConfiguration> findAll(){
        try {
            List<FSConfiguration> fiscalyears = configurationDao.findAllConfigurationByYear();
            return Objects.requireNonNullElseGet(fiscalyears, () -> new ArrayList(0));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public FSConfiguration createConfiguration(FSConfiguration configuration){
        try {
            return configurationDao.create(configuration);
        } catch (DuplicateDataException e) {
            throw new RuntimeException(e);
        } catch (SaveRecordException e) {
            throw new RuntimeException(e);
        }
    }

    public FSConfiguration editConfiguration(FSConfiguration configuration){
        try {
            return configurationDao.edit(configuration);
        } catch (DuplicateDataException e) {
            throw new RuntimeException(e);
        } catch (RelationDataException e) {
            throw new RuntimeException(e);
        } catch (SaveRecordException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteConfiguration(Long id){
        try {
            return configurationDao.delete(id);
        } catch (RelationDataException e) {
            throw new RuntimeException(e);
        }
    }
}
