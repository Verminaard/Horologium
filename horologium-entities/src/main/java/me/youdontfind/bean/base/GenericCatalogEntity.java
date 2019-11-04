package me.youdontfind.bean.base;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Audited
@Data
@EqualsAndHashCode(callSuper = true)
public class GenericCatalogEntity extends GenericEntity {

    @Column(name = "name", nullable = false)
    @NotNull
    private String name;

    /**
     * Пометка на удаление
     */
    @Column(name = "deleted")
    private boolean deleted;

}
