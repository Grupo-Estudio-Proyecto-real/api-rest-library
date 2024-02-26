package com.diplock.library.mapper;

import com.diplock.library.dataholders.CategoryDh;
import com.diplock.library.dtos.CategoryDto;
import com.diplock.library.entities.Book;
import com.diplock.library.entities.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-14T18:27:47+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category asEntity(CategoryDh categoryDh) {
        if ( categoryDh == null ) {
            return null;
        }

        Category category = new Category();

        category.setCategoryId( categoryDh.getCategoryId() );
        category.setName( categoryDh.getName() );
        category.setSubtopic( categoryDh.getSubtopic() );
        List<Book> list = categoryDh.getBookList();
        if ( list != null ) {
            category.setBookList( new ArrayList<Book>( list ) );
        }

        return category;
    }

    @Override
    public CategoryDto asDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setCategoryId( category.getCategoryId() );
        categoryDto.setName( category.getName() );
        categoryDto.setSubtopic( category.getSubtopic() );
        List<Book> list = category.getBookList();
        if ( list != null ) {
            categoryDto.setBookList( new ArrayList<Book>( list ) );
        }

        return categoryDto;
    }

    @Override
    public List<Category> asEntityList(List<CategoryDh> categoryDhList) {
        if ( categoryDhList == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( categoryDhList.size() );
        for ( CategoryDh categoryDh : categoryDhList ) {
            list.add( asEntity( categoryDh ) );
        }

        return list;
    }

    @Override
    public List<CategoryDto> asDtoList(List<Category> categoryList) {
        if ( categoryList == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( categoryList.size() );
        for ( Category category : categoryList ) {
            list.add( asDTO( category ) );
        }

        return list;
    }
}
