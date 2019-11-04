package me.youdontfind.bean.hospital.workers.feature;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.youdontfind.bean.base.GenericCatalogEntity;
import me.youdontfind.bean.base.GenericEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Speciality")
@EqualsAndHashCode(callSuper = true)
public class Speciality extends GenericCatalogEntity {

    @Column(name = "code", nullable = false)
    @NotNull
    private String code;

}
