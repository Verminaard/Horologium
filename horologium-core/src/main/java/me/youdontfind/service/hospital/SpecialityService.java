package me.youdontfind.service.hospital;

import me.youdontfind.bean.hospital.workers.feature.Speciality;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SpecialityService {

    Page<Speciality> getAllSpeciality(Pageable pageable);

}
