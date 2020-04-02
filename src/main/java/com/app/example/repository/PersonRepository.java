/**
 * 
 */
package com.app.example.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.example.entity.Person;

/**
 * @author mshaikh4
 *
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, BigInteger> {

}
