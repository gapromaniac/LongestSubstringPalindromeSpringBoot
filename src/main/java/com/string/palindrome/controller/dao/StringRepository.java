package com.string.palindrome.controller.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.string.palindrome.controller.model.StringDTO;

public interface StringRepository extends JpaRepository<StringDTO, Integer>{

	List<StringDTO> findByInputString(String inputString);

}
