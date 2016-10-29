/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.accessdata.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauricio
 */
@Entity
@Table(name = "GroupTable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupTable.findAll", query = "SELECT g FROM GroupTable g"),
    @NamedQuery(name = "GroupTable.findByGroupId", query = "SELECT g FROM GroupTable g WHERE g.groupTablePK.groupId = :groupId"),
    @NamedQuery(name = "GroupTable.findByUserId", query = "SELECT g FROM GroupTable g WHERE g.groupTablePK.userId = :userId")})
public class GroupTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GroupTablePK groupTablePK;
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public GroupTable() {
    }

    public GroupTable(GroupTablePK groupTablePK) {
        this.groupTablePK = groupTablePK;
    }

    public GroupTable(int groupId, int userId) {
        this.groupTablePK = new GroupTablePK(groupId, userId);
    }

    public GroupTablePK getGroupTablePK() {
        return groupTablePK;
    }

    public void setGroupTablePK(GroupTablePK groupTablePK) {
        this.groupTablePK = groupTablePK;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupTablePK != null ? groupTablePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupTable)) {
            return false;
        }
        GroupTable other = (GroupTable) object;
        if ((this.groupTablePK == null && other.groupTablePK != null) || (this.groupTablePK != null && !this.groupTablePK.equals(other.groupTablePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.unkitsolutions.accessdata.entity.GroupTable[ groupTablePK=" + groupTablePK + " ]";
    }
    
}
