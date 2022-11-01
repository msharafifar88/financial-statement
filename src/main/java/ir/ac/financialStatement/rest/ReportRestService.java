package ir.ac.financialStatement.rest;

import ir.ac.financialStatement.entity.FSColumn;
import ir.ac.financialStatement.entity.FSFinancialStatement;
import ir.ac.financialStatement.entity.FSRow;
import ir.ac.financialStatement.rest.wrapper.FSWrapper;
import ir.ac.financialStatement.service.ColumnService;
import ir.ac.financialStatement.service.RowService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Path("report")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReportRestService {

    @Inject
    private RowService rowService;
    @Inject
    private ColumnService columnService;

    @GET
    @Path("/rows")
    public List<FSRow> getAllRows() {
        return rowService.findAll();
    }

    @GET
    @Path("/columns")
    public List<FSColumn> getAllColumns() {
        return columnService.findAll();
    }


}
