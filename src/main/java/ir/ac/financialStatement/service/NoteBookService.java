package ir.ac.financialStatement.service;

import ir.ac.financialStatement.dao.NoteBookDao;
import ir.ac.financialStatement.entity.notebook.FSNoteBook;
import ir.ac.financialStatement.entity.notebook.FSNoteBookColumn;
import ir.ac.financialStatement.entity.notebook.FSNoteBookRow;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class NoteBookService {

    @Inject
    NoteBookDao noteBookDao;

    public boolean delete(Long id) throws Exception{

        return noteBookDao.delete(findById(id));
    }

    /* Find All NoteBook*/
    public List<FSNoteBook> findAll() {
        return noteBookDao.findAll();
    }

    public FSNoteBook findById(Long id) {
        return noteBookDao.findByID(id);
    }

    public List<FSNoteBookColumn> findColumnsByID(Long nbID){
        return noteBookDao.findColumnByID(nbID);
    }
    public List<FSNoteBookRow> showResult(Long nbID){

        List<FSNoteBookRow> rows =noteBookDao.findRowByID(nbID);
        return rows ;
    }
}
