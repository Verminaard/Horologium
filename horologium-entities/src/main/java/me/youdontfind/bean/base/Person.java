package me.youdontfind.bean.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.StringJoiner;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public class Person extends GenericCatalogEntity {

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "middleName")
    private String middleName;

    @Transient
    public String getFio() {
        StringJoiner joiner = new StringJoiner(" ");
        if (lastName != null) {
            joiner.add(lastName);
        }
        if (firstName != null) {
            joiner.add(firstName);
        }
        if (middleName != null) {
            joiner.add(middleName);
        }
        return joiner.toString();
    }
}
