package com.diplock.library.mapper;

import com.diplock.library.dataholders.AuthorDh;
import com.diplock.library.dataholders.BookDh;
import com.diplock.library.dataholders.CategoryDh;
import com.diplock.library.dataholders.PublisherDh;
import com.diplock.library.dtos.BookDto;
import com.diplock.library.entities.Author;
import com.diplock.library.entities.Book;
import com.diplock.library.entities.Category;
import com.diplock.library.entities.Publisher;
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
public class BookMapperImpl implements BookMapper {

    @Override
    public Book asEntity(BookDh bookDh) {
        if ( bookDh == null ) {
            return null;
        }

        Book book = new Book();

        book.setIsbn( bookDh.getIsbn() );
        book.setTitle( bookDh.getTitle() );
        book.setPages( bookDh.getPages() );
        book.setSummary( bookDh.getSummary() );
        book.setEditionDate( bookDh.getEditionDate() );
        book.setCoverImage( bookDh.getCoverImage() );
        book.setBookFile( bookDh.getBookFile() );
        book.setFilePath( bookDh.getFilePath() );
        book.setLanguage( bookDh.getLanguage() );
        book.setAuthor( authorDhToAuthor( bookDh.getAuthor() ) );
        book.setCategory( categoryDhToCategory( bookDh.getCategory() ) );
        book.setPublisher( publisherDhToPublisher( bookDh.getPublisher() ) );

        return book;
    }

    @Override
    public BookDto asDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setIsbn( book.getIsbn() );
        bookDto.setTitle( book.getTitle() );
        bookDto.setPages( book.getPages() );
        bookDto.setSummary( book.getSummary() );
        bookDto.setEditionDate( book.getEditionDate() );
        bookDto.setCoverImage( book.getCoverImage() );
        bookDto.setBookFile( book.getBookFile() );
        bookDto.setFilePath( book.getFilePath() );
        bookDto.setLanguage( book.getLanguage() );
        bookDto.setAuthor( book.getAuthor() );
        bookDto.setCategory( book.getCategory() );
        bookDto.setPublisher( book.getPublisher() );

        return bookDto;
    }

    @Override
    public List<Book> asEntityList(List<BookDh> bookDhList) {
        if ( bookDhList == null ) {
            return null;
        }

        List<Book> list = new ArrayList<Book>( bookDhList.size() );
        for ( BookDh bookDh : bookDhList ) {
            list.add( asEntity( bookDh ) );
        }

        return list;
    }

    @Override
    public List<BookDto> asDtoList(List<Book> books) {
        if ( books == null ) {
            return null;
        }

        List<BookDto> list = new ArrayList<BookDto>( books.size() );
        for ( Book book : books ) {
            list.add( asDto( book ) );
        }

        return list;
    }

    protected Author authorDhToAuthor(AuthorDh authorDh) {
        if ( authorDh == null ) {
            return null;
        }

        Author author = new Author();

        author.setAuthorId( authorDh.getAuthorId() );
        author.setFirstName( authorDh.getFirstName() );
        author.setLastName( authorDh.getLastName() );

        return author;
    }

    protected Category categoryDhToCategory(CategoryDh categoryDh) {
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

    protected Publisher publisherDhToPublisher(PublisherDh publisherDh) {
        if ( publisherDh == null ) {
            return null;
        }

        Publisher publisher = new Publisher();

        publisher.setPublisherId( publisherDh.getPublisherId() );
        publisher.setName( publisherDh.getName() );
        publisher.setLocation( publisherDh.getLocation() );
        publisher.setCountry( publisherDh.getCountry() );

        return publisher;
    }
}
