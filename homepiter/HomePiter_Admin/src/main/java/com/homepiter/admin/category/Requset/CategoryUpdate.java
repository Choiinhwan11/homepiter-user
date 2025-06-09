package com.homepiter.admin.category.Requset;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryUpdate {



    public String categoryId ;
    public String categoryName ;
    public String categoryDesc ;
    public String categoryType ;
    public String categoryStatus ;
    public String categoryCreate ;
    public String categoryModify ;
    public String categoryDelete ;
    public String categoryTitle ;
    public String categoryIcon ;
    public String categoryLink ;
    public String categoryParentId ;

}
