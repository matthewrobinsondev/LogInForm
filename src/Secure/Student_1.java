/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secure;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author MattyRobbo31
 */
@Entity
@Table(name = "STUDENT", catalog = "", schema = "CIS4005")
@NamedQueries({
    @NamedQuery(name = "Student_1.findAll", query = "SELECT s FROM Student_1 s")
    , @NamedQuery(name = "Student_1.findById", query = "SELECT s FROM Student_1 s WHERE s.id = :id")
    , @NamedQuery(name = "Student_1.findByForename", query = "SELECT s FROM Student_1 s WHERE s.forename = :forename")
    , @NamedQuery(name = "Student_1.findBySurname", query = "SELECT s FROM Student_1 s WHERE s.surname = :surname")
    , @NamedQuery(name = "Student_1.findByStudentno", query = "SELECT s FROM Student_1 s WHERE s.studentno = :studentno")
    , @NamedQuery(name = "Student_1.findByFullparttime", query = "SELECT s FROM Student_1 s WHERE s.fullparttime = :fullparttime")
    , @NamedQuery(name = "Student_1.findByBirthdate", query = "SELECT s FROM Student_1 s WHERE s.birthdate = :birthdate")})
public class Student_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "FORENAME")
    private String forename;
    @Basic(optional = false)
    @Column(name = "SURNAME")
    private String surname;
    @Basic(optional = false)
    @Column(name = "STUDENTNO")
    private String studentno;
    @Basic(optional = false)
    @Column(name = "FULLPARTTIME")
    private String fullparttime;
    @Column(name = "BIRTHDATE")
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    public Student_1() {
    }

    public Student_1(Integer id) {
        this.id = id;
    }

    public Student_1(Integer id, String forename, String surname, String studentno, String fullparttime) {
        this.id = id;
        this.forename = forename;
        this.surname = surname;
        this.studentno = studentno;
        this.fullparttime = fullparttime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        String oldForename = this.forename;
        this.forename = forename;
        changeSupport.firePropertyChange("forename", oldForename, forename);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        String oldSurname = this.surname;
        this.surname = surname;
        changeSupport.firePropertyChange("surname", oldSurname, surname);
    }

    public String getStudentno() {
        return studentno;
    }

    public void setStudentno(String studentno) {
        String oldStudentno = this.studentno;
        this.studentno = studentno;
        changeSupport.firePropertyChange("studentno", oldStudentno, studentno);
    }

    public String getFullparttime() {
        return fullparttime;
    }

    public void setFullparttime(String fullparttime) {
        String oldFullparttime = this.fullparttime;
        this.fullparttime = fullparttime;
        changeSupport.firePropertyChange("fullparttime", oldFullparttime, fullparttime);
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        Date oldBirthdate = this.birthdate;
        this.birthdate = birthdate;
        changeSupport.firePropertyChange("birthdate", oldBirthdate, birthdate);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student_1)) {
            return false;
        }
        Student_1 other = (Student_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Secure.Student_1[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
