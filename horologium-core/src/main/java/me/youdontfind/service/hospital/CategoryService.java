package me.youdontfind.service.hospital;

import me.youdontfind.bean.hospital.workers.feature.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    Page<Category> getAllCategory(Pageable pageable);

}
