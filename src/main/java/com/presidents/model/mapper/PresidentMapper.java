package com.presidents.model.mapper;

import com.presidents.model.entity.President;
import com.presidents.model.dto.PresidentDto;


public interface PresidentMapper {

   static PresidentDto toDto(President president){
       return PresidentDto.builder()
               .id(president.getId())
               .name(president.getName())
               .surname(president.getSurname())
               .party(president.getParty())
               .termFrom(president.getTermFrom())
               .termTo(president.getTermTo())
               .build();
   }

   static President toEntity(PresidentDto presidentDto){
       return President.builder()
               .id(presidentDto.getId())
               .name(presidentDto.getName())
               .surname(presidentDto.getSurname())
               .party(presidentDto.getParty())
               .termFrom(presidentDto.getTermFrom())
               .termTo(presidentDto.getTermTo())
               .build();
   }
}
