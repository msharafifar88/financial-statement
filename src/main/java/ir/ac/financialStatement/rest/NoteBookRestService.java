package ir.ac.financialStatement.rest;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import ir.ac.financialStatement.entity.notebook.FSNoteBook;
import ir.ac.financialStatement.entity.notebook.FSNoteBookColumn;
import ir.ac.financialStatement.entity.notebook.FSNoteBookRow;
import ir.ac.financialStatement.entity.notebook.FSNotebookCell;
import ir.ac.financialStatement.enumration.ColumnType;
import ir.ac.financialStatement.rest.wrapper.NotebookCellWrapper;
import ir.ac.financialStatement.rest.wrapper.NotebookColumnsWrapper;

import ir.ac.financialStatement.rest.wrapper.FSNoteBookWrapper;
import ir.ac.financialStatement.rest.wrapper.NotebookRowWrapper;
import ir.ac.financialStatement.service.NoteBookService;
import ir.ac.specialReport.service.AccountingSpecialService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.NumberFormat;
import java.util.*;

@ApplicationScoped
@Path("notebook")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NoteBookRestService {

    @Inject
    private NoteBookService noteBookService;
    @Inject
    private AccountingSpecialService accountingSpecialService;


    /*Get All Notebook*/
    @GET
    @Path("/list")
    public List<FSNoteBookWrapper> getAllNotebook() {

        List<FSNoteBook> list = noteBookService.findAll();

        List<FSNoteBookWrapper> wrapperList = new ArrayList<>(list.size());

        list.forEach(nb -> {
            FSNoteBookWrapper wrapper = new FSNoteBookWrapper(nb.getId(),nb.getCode(), nb.getName());
            wrapperList.add(wrapper);
        });
        return wrapperList;
    }

    @DELETE
    @Path("/delete/{id}")
    public void deleteNotebook(@PathParam("id") Long id){
        try {
            boolean b = noteBookService.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @GET
    @Path("/columns/{id}")
    public List<NotebookColumnsWrapper> getColumns(@PathParam("id") Long id) {
        List<NotebookColumnsWrapper> notebookColumnsWrappers =  new ArrayList<>();
        List<FSNoteBookColumn> noteBookColumns = noteBookService.findColumnsByID(id);

        noteBookColumns.forEach(column -> {
            notebookColumnsWrappers.add(new NotebookColumnsWrapper(column.getName(),column.getTitle()));
        });
        return notebookColumnsWrappers;
    }

   /* static String getValue(String o) {
        if(o.contains("1")){
            return "کد";
        }else if(o.contains("2")||o.contains("3")) {
            return "ریال";
        }else if(o.contains("4")) {
            return "نام";
        }
        return "بدون اسم";
    }*/
    @GET
    @Path("/data/{id}")
    public String getNotebook(@PathParam("id") Long id) {

        List<NotebookRowWrapper> notebookRowWrappers= new ArrayList<>();
        List<FSNoteBookRow>noteBookRows = noteBookService.showResult(id);
        JsonArray jsonArray = new JsonArray();
        int i = 0;
        for (FSNoteBookRow row : noteBookRows) {
            List<NotebookCellWrapper> notebookColumnWrappers = new ArrayList<>();
            com.google.gson.JsonObject json = new JsonObject();


            for (FSNotebookCell cell : row.getNotebookCells()) {
                  NotebookCellWrapper columnWrapper = new NotebookCellWrapper(cell.getValue(),cell.getColumnType(),cell.getColumn().getName());
                  notebookColumnWrappers.add(columnWrapper);
                  json.addProperty(cell.getColumn().getName(),cell.getColumnType().equals(ColumnType.DataType) ? NumberConverter(cell.getValue()) : cell.getValue());
            }
            jsonArray.add(json);
            Collections.sort(notebookColumnWrappers);
            NotebookRowWrapper notebookRowWrapper = new NotebookRowWrapper(row.getId(),i++,notebookColumnWrappers);
            notebookRowWrappers.add(notebookRowWrapper);

        }
        String s =jsonArray.toString();
        return s;
    }

    public String NumberConverter(Object value){
        if (value != null) {
            if (value instanceof Double || value instanceof Long) {
                NumberFormat numberFormat = NumberFormat.getInstance();
                return numberFormat.format(value).replaceAll(",", "");
            } else if (value instanceof String) {
                try{
                    Double dvalue = Double.parseDouble((String)value);
                    NumberFormat numberFormat = NumberFormat.getInstance();
                    return numberFormat.format(dvalue);
                }catch (Exception ex){
                    return (String) value;
                }
            }
        }
        return "";
    }
}
