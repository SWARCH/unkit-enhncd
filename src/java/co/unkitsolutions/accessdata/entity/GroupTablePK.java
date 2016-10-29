/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.accessdata.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author mauricio
 */
@Embeddable
public class GroupTablePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "groupId")
    private int groupId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userId")
    private int userId;

    public GroupTablePK() {
    }

    public GroupTablePK(int groupId, int userId) {
        this.groupId = groupId;
        this.userId = userId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) groupId;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupTablePK)) {
            return false;
        }
        GroupTablePK other = (GroupTablePK) object;
        if (this.groupId != other.groupId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.unkitsolutions.accessdata.entity.GroupTablePK[ groupId=" + groupId + ", userId=" + userId + " ]";
    }
    
}
