package com.homepiter.admin.category.controller;



import com.homepiter.admin.category.Requset.CategoryCreateRequest;
import com.homepiter.admin.category.Requset.CategoryDTO;
import com.homepiter.admin.category.Requset.CategoryUpdate;
import com.homepiter.admin.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/admin/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }



    /**
     * 카테고리 생성
     * */
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryCreateRequest request,
                                            @AuthenticationPrincipal UserDetails user) {
        if (!user.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("관리자만 카테고리를 생성할 수 있습니다.");
        }

        categoryService.createCategory(request);
        return ResponseEntity.ok("카테고리 생성 완료");
    }



    /**
     * 카테고리 수정
     * */
    @PostMapping(path ="/categoryUpdate/{id}")
    public ResponseEntity<?>updateCategory(@PathVariable Long id , @RequestBody CategoryUpdate request){
        categoryService.updateCategory(id, request);
        return ResponseEntity.ok("카테고리 업데이트 성공 했습니다 .");
    }



    /**
     * category delete
     * */
    @DeleteMapping(path = "/categoryDelete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("카테고리 삭제 성공했습니다 .");
    }

}
