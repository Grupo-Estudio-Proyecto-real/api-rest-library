package com.diplock.library.mapper;

import com.diplock.library.dataholders.AuthorDh;
import com.diplock.library.dtos.AuthorDto;
import com.diplock.library.entities.Author;
import com.diplock.library.entities.Book;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-12T20:42:49+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public Author asEntity(AuthorDh authorDh) {
        if ( authorDh == null ) {
            return null;
        }

        Author author = new Author();

        author.setAuthorId( authorDh.getAuthorId() );
        author.setFirstName( authorDh.getFirstName() );
        author.setLastName( authorDh.getLastName() );

        return author;
    }

    @Override
    public AuthorDto asDto(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDto authorDto = new AuthorDto();

        authorDto.setAuthorId( author.getAuthorId() );
        authorDto.setFirstName( author.getFirstName() );
        authorDto.setLastName( author.getLastName() );
        List<Book> list = author.getBookList();
        if ( list != null ) {
            authorDto.setBookList( new ArrayList<Book>( list ) );
        }

        return authorDto;
    }

    @Override
    public List<Author> asEntityList(List<AuthorDh> authorDhList) {
        if ( authorDhList == null ) {
            return null;
        }

        List<Author> list = new ArrayList<Author>( authorDhList.size() );
        for ( AuthorDh authorDh : authorDhList ) {
            list.add( asEntity( authorDh ) );
        }

        return list;
    }

    @Override
    public List<AuthorDto> asDtoList(List<Author> author) {
        if ( author == null ) {
            return null;
        }

        List<AuthorDto> list = new ArrayList<AuthorDto>( author.size() );
        for ( Author author1 : author ) {
            list.add( asDto( author1 ) );
        }

        return list;
    }
}
