package me.youdontfind.web.hospital;

import me.youdontfind.bean.hospital.workers.feature.Speciality;
import me.youdontfind.service.hospital.SpecialityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/speciality")
public class SpecialityController {

    private final SpecialityService specialityService;

    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @GetMapping(value = "/getAll")
    public Page<Speciality> getAllSpecialities(@PageableDefault(page = 0, size = 1000) Pageable pageable) {
        return specialityService.getAllSpeciality(pageable);
    }
}
