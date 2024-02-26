package com.diplock.library.mapper;

import com.diplock.library.dataholders.LoanDh;
import com.diplock.library.dtos.LoanDto;
import com.diplock.library.entities.Loan;
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
public class LoanMapperImpl implements LoanMapper {

    @Override
    public Loan asEntity(LoanDh loanDh) {
        if ( loanDh == null ) {
            return null;
        }

        Loan loan = new Loan();

        loan.setLoanId( loanDh.getLoanId() );
        loan.setLoanDate( loanDh.getLoanDate() );
        loan.setReturnDate( loanDh.getReturnDate() );
        loan.setUser( loanDh.getUser() );
        loan.setBook( loanDh.getBook() );

        return loan;
    }

    @Override
    public LoanDto asDTO(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        LoanDto loanDto = new LoanDto();

        loanDto.setLoanId( loan.getLoanId() );
        loanDto.setLoanDate( loan.getLoanDate() );
        loanDto.setReturnDate( loan.getReturnDate() );
        loanDto.setUser( loan.getUser() );
        loanDto.setBook( loan.getBook() );

        return loanDto;
    }

    @Override
    public List<Loan> asEntityList(List<LoanDh> loanDhList) {
        if ( loanDhList == null ) {
            return null;
        }

        List<Loan> list = new ArrayList<Loan>( loanDhList.size() );
        for ( LoanDh loanDh : loanDhList ) {
            list.add( asEntity( loanDh ) );
        }

        return list;
    }

    @Override
    public List<LoanDto> asDTOList(List<Loan> loanList) {
        if ( loanList == null ) {
            return null;
        }

        List<LoanDto> list = new ArrayList<LoanDto>( loanList.size() );
        for ( Loan loan : loanList ) {
            list.add( asDTO( loan ) );
        }

        return list;
    }
}
