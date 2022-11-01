package ir.ac.financialStatement.rest.wrapper;

import java.util.Objects;

public class FSNoteBookWrapper {
    private Long _id;
    private Long _code;
    private String _name;

    /*Last Version*/
    private String _tableName;
    private String _tableTitle;
    private String _reportName;
    private Long _reportCode;
    private Long _reportID;

    public FSNoteBookWrapper() {
    }

    public FSNoteBookWrapper(Long _id, Long _code, String _name) {
        this._id = _id;
        this._code = _code;
        this._name = _name;
    }

    public Long get_id() {
        return _id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }

    public Long get_code() {
        return _code;
    }
    public void set_code(Long _code) {
        this._code = _code;
    }

    public String get_name() {
        return _name;
    }
    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_tableName() {
        return _tableName;
    }

    public void set_tableName(String _tableName) {
        this._tableName = _tableName;
    }

    public String get_tableTitle() {
        return _tableTitle;
    }

    public void set_tableTitle(String _tebleTitle) {
        this._tableTitle = _tebleTitle;
    }

    public String get_reportName() {
        return _reportName;
    }

    public void set_reportName(String _reportName) {
        this._reportName = _reportName;
    }

    public Long get_reportCode() {
        return _reportCode;
    }

    public void set_reportCode(Long _reportCode) {
        this._reportCode = _reportCode;
    }

    public Long get_reportID() {
        return _reportID;
    }

    public void set_reportID(Long _reportID) {
        this._reportID = _reportID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FSNoteBookWrapper that = (FSNoteBookWrapper) o;
        return Objects.equals(_id, that._id) && Objects.equals(_code, that._code) && Objects.equals(_name, that._name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _code, _name);
    }
}
