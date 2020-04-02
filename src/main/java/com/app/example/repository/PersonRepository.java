/**
 * 
 */
package com.app.example.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.example.entity.Person;

/**
 * @author mshaikh4
 *
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, BigInteger> {

}
