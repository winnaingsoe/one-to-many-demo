package com.example.onetomanydemo.dao;

import com.example.onetomanydemo.ds.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AuthorDao extends CrudRepository<Author,Integer> {

    @Query("select a from Author a join fetch a.books b where a.name =:name")
    Author fetchByName(String name);

    /*@Query("select a from Author a join fetch a.books b where a.name =?1")
    Author fetchByName(String name);*/

}
