package ir.ac.common.rest.wrapper;

import com.fasterxml.jackson.annotation.JsonValue;
import ir.ac.common.entity.CmOrganization;

import javax.persistence.JoinColumn;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class OrganizationWrapper {

    private Long _id;
    private String _code;
    private String _name;
    private Long _parentID;
    private Set<OrganizationWrapper> _children;
    private boolean _leaf;


    public OrganizationWrapper(CmOrganization organization) {
        this._id = organization.getId();
        this._name = organization.getName();
        this._code = organization.getCode();
        this._parentID = organization.getParentId();
        this._leaf = organization.isLeaf();
        this._children = organization.getChildren().stream().map(OrganizationWrapper::new).collect(Collectors.toSet());
    }

    public Long get_id() {
        return _id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }

    public String get_code() {
        return _code;
    }
    public void set_code(String _code) {
        this._code = _code;
    }

    public String get_name() {
        return _name;
    }
    public void set_name(String _name) {
        this._name = _name;
    }

    public Long get_parentID() {
        return _parentID;
    }
    public void set_parentID(Long _parentID) {
        this._parentID = _parentID;
    }

    public Set<OrganizationWrapper> get_children() {
        return _children;
    }
    public void set_children(Set<OrganizationWrapper> _children) {
        this._children = _children;
    }

    public boolean is_leaf() {
        return _leaf;
    }
    public void set_leaf(boolean _leaf) {
        this._leaf = _leaf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationWrapper that = (OrganizationWrapper) o;
        return _leaf == that._leaf && Objects.equals(_id, that._id) && Objects.equals(_code, that._code) && Objects.equals(_name, that._name) && Objects.equals(_parentID, that._parentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _code, _name, _parentID, _leaf);
    }
}
