package com.diplock.library.mapper;

import com.diplock.library.dataholders.PublisherDh;
import com.diplock.library.dtos.PublisherDto;
import com.diplock.library.entities.Book;
import com.diplock.library.entities.Publisher;
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
public class PublisherMapperImpl implements PublisherMapper {

    @Override
    public Publisher asEntity(PublisherDh publisherDh) {
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

    @Override
    public PublisherDto asDto(Publisher publisher) {
        if ( publisher == null ) {
            return null;
        }

        PublisherDto publisherDto = new PublisherDto();

        publisherDto.setPublisherId( publisher.getPublisherId() );
        publisherDto.setName( publisher.getName() );
        publisherDto.setLocation( publisher.getLocation() );
        publisherDto.setCountry( publisher.getCountry() );
        List<Book> list = publisher.getBookList();
        if ( list != null ) {
            publisherDto.setBookList( new ArrayList<Book>( list ) );
        }

        return publisherDto;
    }

    @Override
    public List<Publisher> asEntityList(List<PublisherDh> publisherDhList) {
        if ( publisherDhList == null ) {
            return null;
        }

        List<Publisher> list = new ArrayList<Publisher>( publisherDhList.size() );
        for ( PublisherDh publisherDh : publisherDhList ) {
            list.add( asEntity( publisherDh ) );
        }

        return list;
    }

    @Override
    public List<PublisherDto> asDtoList(List<Publisher> publishers) {
        if ( publishers == null ) {
            return null;
        }

        List<PublisherDto> list = new ArrayList<PublisherDto>( publishers.size() );
        for ( Publisher publisher : publishers ) {
            list.add( asDto( publisher ) );
        }

        return list;
    }
}
