package me.youdontfind.web.hospital;

import me.youdontfind.bean.hospital.workers.feature.Category;
import me.youdontfind.service.hospital.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/getAll")
    public Page<Category> getAllCategories(@PageableDefault(page = 0, size = 1000) Pageable pageable) {
        return categoryService.getAllCategory(pageable);
    }
}
