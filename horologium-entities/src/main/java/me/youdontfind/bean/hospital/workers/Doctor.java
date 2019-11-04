package me.youdontfind.bean.hospital.workers;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.youdontfind.bean.base.Person;
import me.youdontfind.bean.hospital.workers.feature.Category;
import me.youdontfind.bean.hospital.workers.feature.Speciality;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Doctor")
@EqualsAndHashCode(callSuper = true)
public class Doctor extends Person {

    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
