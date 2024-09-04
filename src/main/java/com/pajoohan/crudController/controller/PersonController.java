package com.pajoohan.crudController.controller;

import com.pajoohan.crudController.baseClass.BaseCrudController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pajoohan.crudController.dto.PersonDto;
import com.pajoohan.crudController.model.PersonEntity;


@RestController
@RequestMapping("/person")
public class PersonController extends BaseCrudController<PersonEntity, PersonDto> {


}
