package com.homepiter.admin.category.Requset;

import com.homepiter.admin.category.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private Long id;
    private String name;
    private List<CategoryDTO> children;

    public static CategoryDTO from(Category category) {
        return new CategoryDTO(
                category.getId(),
                category.getName(),
                category.getChildren().stream()
                        .map(CategoryDTO::from)
                        .collect(Collectors.toList())
        );
    }

    @Data
    public class CategoryCreateRequest {
        private String name;
        private Long parentId;
    }

    @Data
    public class CategoryUpdateRequest {
        private String name;
    }


    }
