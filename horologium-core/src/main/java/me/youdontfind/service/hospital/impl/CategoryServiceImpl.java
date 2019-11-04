package me.youdontfind.service.hospital.impl;

import me.youdontfind.bean.hospital.workers.feature.Category;
import me.youdontfind.repositories.CategoryRepository;
import me.youdontfind.service.hospital.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<Category> getAllCategory(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
}
