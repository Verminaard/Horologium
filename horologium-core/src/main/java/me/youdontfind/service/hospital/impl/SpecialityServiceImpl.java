package me.youdontfind.service.hospital.impl;

import me.youdontfind.bean.hospital.workers.feature.Speciality;
import me.youdontfind.repositories.SpecialityRepository;
import me.youdontfind.service.hospital.SpecialityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialityServiceImpl(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Page<Speciality> getAllSpeciality(Pageable pageable) {
        return specialityRepository.findAll(pageable);
    }
}
