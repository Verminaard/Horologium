package me.youdontfind.web.hospital;

import javassist.NotFoundException;
import me.youdontfind.bean.hospital.workers.Doctor;
import me.youdontfind.bean.hospital.workers.feature.Speciality;
import me.youdontfind.service.hospital.DoctorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping(value = "/getAll")
    public Page<Doctor> getAllDoctors(@PageableDefault(page = 0, size = 1000) Pageable pageable) {
        return doctorService.getAllDoctors(pageable);
    }

    @PostMapping(value = "/getAll")
    public Page<Doctor> getLicenseActivityPage(@PageableDefault(page = 0, size = 1000) Pageable pageable,
                                                                   @RequestBody Doctor filterObject) {
        return doctorService.getAllDoctors(filterObject, pageable);
    }

    @GetMapping(value = "/{id}/get")
    public Doctor getDoctorById(@PathVariable String id) throws NotFoundException {
        return doctorService.getDoctor(id);
    }
}
