package ir.ac.financialStatement.rest.wrapper;


import ir.ac.common.entity.CmFiscalyear;
import ir.ac.common.entity.CmOrganization;
import ir.ac.financialStatement.entity.FSFinancialStatement;

public class FSWrapper {

    private Long _id;
    private Long _code;
    private String _name;
    private Long _organizationID;
    private String _organizationName;
    private String _organizationCode;
    private Long _yearID;
    private String _yearName;
    private String _yearCode;

    public FSWrapper() {
    }

    public FSFinancialStatement createFSFinancialStatement(FSWrapper fsWrapper, CmOrganization organization, CmFiscalyear fiscalyear){

        FSFinancialStatement fsFinancialStatement = new FSFinancialStatement();
        fsFinancialStatement.setCode(fsWrapper.get_code());
        fsFinancialStatement.setName(fsWrapper.get_name());
        fsFinancialStatement.setCmOrganization(organization);
        fsFinancialStatement.setCmFiscalyear(fiscalyear);
        return fsFinancialStatement;
    }

    public FSWrapper(Long id, Long code, String name, Long organizationID, String organizationName, String organizationCode, Long yearID, String yearName, String yearCode) {
        this._id = id;
        this._code = code;
        this._name = name;
        this._organizationID = organizationID;
        this._organizationName = organizationName;
        this._organizationCode = organizationCode;
        this._yearID = yearID;
        this._yearName = yearName;
        this._yearCode = yearCode;
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

    public Long get_organizationID() {
        return _organizationID;
    }

    public void set_organizationID(Long _organizationID) {
        this._organizationID = _organizationID;
    }

    public String get_organizationName() {
        return _organizationName;
    }

    public void set_organizationName(String _organizationName) {
        this._organizationName = _organizationName;
    }

    public String get_organizationCode() {
        return _organizationCode;
    }

    public void set_organizationCode(String _organizationCode) {
        this._organizationCode = _organizationCode;
    }

    public Long get_yearID() {
        return _yearID;
    }

    public void set_yearID(Long _yearID) {
        this._yearID = _yearID;
    }

    public String get_yearName() {
        return _yearName;
    }

    public void set_yearName(String _yearName) {
        this._yearName = _yearName;
    }

    public String get_yearCode() {
        return _yearCode;
    }

    public void set_yearCode(String _yearCode) {
        this._yearCode = _yearCode;
    }
}
