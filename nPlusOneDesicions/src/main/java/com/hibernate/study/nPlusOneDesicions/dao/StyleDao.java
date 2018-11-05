package com.hibernate.study.nPlusOneDesicions.dao;

import com.hibernate.study.nPlusOneDesicions.entity.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StyleDao extends JpaRepository<Style, Long> {

}
