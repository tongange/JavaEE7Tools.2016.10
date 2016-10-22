package qin.javaee7.hibernate.domain;

import qin.javaee7.core.Gender;
import qin.javaee7.core.hibernate.SuperEntity7;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 员工实体类
 *
 * @author qinzhengying
 * @since 1.7
 */
@Entity
@Table(name = "javaee7_employee")
@SuppressWarnings("all")
public class Employee implements SuperEntity7<String>
{
    //region 主键
    private String id;

    @Id
    @GeneratedValue
    @Override
    public String getId()
    {
        return id;
    }

    @Override
    public void setId(String id)
    {
        this.id = id;
    }
    //endregion

    //region 员工姓名
    /**
     * 员工姓名
     */
    private String empName;

    @Column(length = 10)
    public String getEmpName()
    {
        return empName;
    }

    public void setEmpName(String empName)
    {
        this.empName = empName;
    }
    //endregion

    //region 员工性别
    /**
     * 员工性别
     */
    private Gender empGender;

    @Enumerated(EnumType.STRING)
    @Column
    public Gender getEmpGender()
    {
        return empGender;
    }

    public void setEmpGender(Gender empGender)
    {
        this.empGender = empGender;
    }
    //endregion

    //region 员工描述
    /**
     * 员工描述
     */
    private String empDescription;

    @Column(length = 3000)
    public String getEmpDescription()
    {
        return empDescription;
    }

    public void setEmpDescription(String empDescription)
    {
        this.empDescription = empDescription;
    }

    //endregion

    //region 员工所在部门简称
    /**
     * 员工所在部门简称
     */
    private String empDepartment;

    @Column(length = 30)
    public String getEmpDepartment()
    {
        return empDepartment;
    }

    public void setEmpDepartment(String empDepartment)
    {
        this.empDepartment = empDepartment;
    }
    //endregion

    //region 员工年龄
    /**
     * 员工年龄
     */
    private Integer empAge;

    @Column
    public Integer getEmpAge()
    {
        return empAge;
    }

    public void setEmpAge(Integer empAge)
    {
        this.empAge = empAge;
    }
    //endregion

    //region 员工联系方式
    /**
     * 员工联系方式
     */
    private Long empPhone;

    @Column
    public Long getEmpPhone()
    {
        return empPhone;
    }

    public void setEmpPhone(Long empPhone)
    {
        this.empPhone = empPhone;
    }
    //endregion
}