package com.apress.catalog.mapper;

import com.apress.catalog.dto.CurrencyDTO;
import com.apress.catalog.model.Currency;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApiMapper {

    ApiMapper INSTANCE = Mappers.getMapper( ApiMapper.class );

    CurrencyDTO entityToDTO(Currency currency);

    Currency DTOToEntity(CurrencyDTO currency);
}
