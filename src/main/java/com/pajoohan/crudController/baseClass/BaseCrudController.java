package com.pajoohan.crudController.baseClass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class BaseCrudController<E, D extends BaseDto<E, D>> {

    @PersistenceContext
    private EntityManager entityManager;

    @JsonIgnore
    private final Class<E> clazzE;

    @JsonIgnore
    private final Class<D> clazzD;

    public BaseCrudController() {
        this.clazzE = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.clazzD = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @GetMapping
    public List<D> getAll() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        D mapper = this.clazzD.getDeclaredConstructor().newInstance();
        List<E> eList = entityManager.createQuery("FROM " + clazzE.getSimpleName(), this.clazzE).getResultList();
        return mapper.entityListToDtoList(eList);
    }


    @GetMapping("/{id}")
    public D get(@PathVariable Long id) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        D mapper = this.clazzD.getDeclaredConstructor().newInstance();
        E e = entityManager.find(this.clazzE, id);
        return mapper.entityToDto(e);
    }

    @PostMapping
    @Transactional
    public D create(@RequestBody D d) {

        d.InsertValidation();
        E e = d.dtoToEntity(d);
        entityManager.persist(e);
        return d.entityToDto(e);
    }

    @PutMapping
    @Transactional
    public D update(@RequestBody D d) {

        d.updateValidation();
        E e = d.dtoToEntity(d);
        entityManager.merge(e);
        return d.entityToDto(e);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {

        E e = entityManager.find(this.clazzE, id);
        entityManager.remove(e);
    }
}
