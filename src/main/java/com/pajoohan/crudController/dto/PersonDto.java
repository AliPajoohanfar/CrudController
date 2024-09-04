package com.pajoohan.crudController.dto;

import com.pajoohan.crudController.baseClass.BaseDto;
import com.pajoohan.crudController.model.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto extends BaseDto<PersonEntity, PersonDto> {

    private Long id;
    private String name;
    private String family;
    private String nationalCode;


    //Override it if you need validation on insert
    @Override
    public void InsertValidation() {
        if (this.id != null) {
            throw new RuntimeException("ID MUST BE NULL");
        }
    }

    //Override it if you need validation on update
    @Override
    public void updateValidation() {
        if (this.id == null) {
            throw new RuntimeException("ID CAN'T BE NULL");
        }
    }

    //Override these if you need custom mapper
    @Override
    public PersonDto entityToDto(PersonEntity e) {
        return super.entityToDto(e);
    }

    @Override
    public PersonEntity dtoToEntity(PersonDto d) {
        return super.dtoToEntity(d);
    }

    @Override
    public List<PersonDto> entityListToDtoList(List<PersonEntity> eList) {
        return super.entityListToDtoList(eList);
    }

    @Override
    public List<PersonEntity> dtoListToEntityList(List<PersonDto> dList) {
        return super.dtoListToEntityList(dList);
    }
}