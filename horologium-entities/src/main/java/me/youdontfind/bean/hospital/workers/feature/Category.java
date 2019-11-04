package me.youdontfind.bean.hospital.workers.feature;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.youdontfind.bean.base.GenericCatalogEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Category")
@EqualsAndHashCode(callSuper = true)
public class Category extends GenericCatalogEntity {

}
