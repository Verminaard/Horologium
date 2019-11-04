package me.youdontfind.repositories;

import me.youdontfind.bean.hospital.workers.Doctor;
import me.youdontfind.repositories.common.CustomRevisionRepository;

public interface DoctorRepository extends CustomRevisionRepository<Doctor, String> {
}
