package com.hibernate.study.nPlusOneDesicions.dao;

import com.hibernate.study.nPlusOneDesicions.entity.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StyleDao extends JpaRepository<Style, Long> {

}
