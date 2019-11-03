package me.youdontfind.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Day")
@EqualsAndHashCode(callSuper = true)
public class TempHello extends GenericEntity{

    @Column
    private String tempColumn;

}
