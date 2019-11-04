package me.youdontfind.service.hospital;

import javassist.NotFoundException;
import me.youdontfind.bean.hospital.workers.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DoctorService {

    Page<Doctor> getAllDoctors(Doctor filterObject, Pageable pageable);

    Page<Doctor> getAllDoctors(Pageable pageable);

    Doctor getDoctor(String id) throws NotFoundException;

}
