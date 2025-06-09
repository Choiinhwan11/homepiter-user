package com.homepiter.admin.category.service;

import com.homepiter.admin.category.Requset.CategoryCreateRequest;
import com.homepiter.admin.category.Requset.CategoryDTO;
import com.homepiter.admin.category.Requset.CategoryUpdate;
import com.homepiter.admin.category.entity.Category;
import com.homepiter.admin.category.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> topCategories = categoryRepository.findByParentIsNull();
        return topCategories.stream()
                .map(CategoryDTO::from)
                .collect(Collectors.toList());
    }



    @Override
    public void createCategory(CategoryCreateRequest request) {
        Category parent = null;
        if (request.getParentId() != null) {
            parent = categoryRepository.findById(request.getParentId())
                    .orElseThrow(() -> new IllegalArgumentException("상위 카테고리를 찾을 수 없습니다."));
        }
        Category category = new Category(request.getName(), parent);
        categoryRepository.save(category);
    }


    @Override
    @Transactional
    public void updateCategory(Long id, CategoryUpdate request) {

        categoryRepository.updateCategory(id, request.getCategoryName());
    }




    @Override
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new IllegalArgumentException("해당 카테고리를 찾을 수 없습니다.");
        }
        categoryRepository.deleteById(id);
    }
}
