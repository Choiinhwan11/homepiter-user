package com.homepiter.admin.category.service;

import com.homepiter.admin.category.Requset.CategoryCreateRequest;
import com.homepiter.admin.category.Requset.CategoryDTO;
import com.homepiter.admin.category.Requset.CategoryUpdate;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    void createCategory(CategoryCreateRequest requset);

    void updateCategory(Long id, CategoryUpdate request);

    void deleteCategory(Long id);
}
