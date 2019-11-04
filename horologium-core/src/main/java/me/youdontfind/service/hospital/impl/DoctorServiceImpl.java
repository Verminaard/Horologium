package me.youdontfind.service.hospital.impl;

import javassist.NotFoundException;
import me.youdontfind.bean.hospital.workers.Doctor;
import me.youdontfind.repositories.DoctorRepository;
import me.youdontfind.service.hospital.DoctorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Page<Doctor> getAllDoctors(Doctor filterObject, Pageable pageable) {
        return doctorRepository.findAll(filterObject, pageable);
    }

    @Override
    public Page<Doctor> getAllDoctors(Pageable pageable) {
        return doctorRepository.findAll(pageable);
    }

    @Override
    public Doctor getDoctor(String id) throws NotFoundException {
        return doctorRepository.findById(id).orElseThrow(() -> new NotFoundException("License request not found"));
    }
}
