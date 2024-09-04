package com.pajoohan.crudController.baseClass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class BaseDto<ENTITY, DTO> {

    @JsonIgnore
    private final ModelMapper modelMapper = new ModelMapper();

    @JsonIgnore
    private final Type typeE;

    @JsonIgnore
    private final Type typeD;

    protected BaseDto() {
        this.typeE = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.typeD = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    //Validations
    public void InsertValidation() {
        //Left this Blank
    }

    public void updateValidation() {
        //Left this Blank
    }


    //Mappers
    public DTO entityToDto(ENTITY e) {
        return modelMapper.map(e, this.typeD);
    }

    public List<DTO> entityListToDtoList(List<ENTITY> eList) {
        return modelMapper.map(eList, new TypeToken<>() {
        }.getType());
    }


    public ENTITY dtoToEntity(DTO d) {
        return modelMapper.map(d, this.typeE);
    }

    public List<ENTITY> dtoListToEntityList(List<DTO> dList) {
        return modelMapper.map(dList, new TypeToken<>() {
        }.getType());
    }

}
