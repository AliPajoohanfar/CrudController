<h2> Base CRUD Conreoller for Java Spring : </h2>
<p>1- Create your Entity</p>
<p>2- Create your DTO and extend BaseDto<EntityName , DtoName></p>
<p>  2.1- if you need custom validation in Insert operation overide "void InsertValidation()"</p>
  <p>2.2- if you need custom validation in Update operation overide "void updateNTITY dtoToEntity(DTO d)Validation()"</p>
	<p>2.3- if you need custom Mapping overide DTO entityToDto(ENTITY e), List<DTO> entityListToDtoList(List<ENTITY> eList),  ENTITY dtoToEntity(DTO d),  List<ENTITY> dtoListToEntityList(List<DTO> dList) Methods.</p>
<p>3- Create Controller for your Entity and extend BaseCrudController<EntityName , DtoName></p>
<p>4- Now you have CRUD APIs to work with your Entity. you can add more Endpoint in your cointroller.</p>
