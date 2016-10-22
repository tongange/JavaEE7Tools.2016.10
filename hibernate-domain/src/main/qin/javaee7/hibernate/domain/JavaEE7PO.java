package qin.javaee7.hibernate.domain;

import qin.javaee7.core.hibernate.SuperEntity7;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "javaee7_po")
public class JavaEE7PO implements SuperEntity7<Integer>
{
    private Integer id;

    @Override
    @Id
    @GeneratedValue
    public Integer getId()
    {
        return id;
    }

    @Override
    public void setId(Integer id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("JavaEE7PO{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}