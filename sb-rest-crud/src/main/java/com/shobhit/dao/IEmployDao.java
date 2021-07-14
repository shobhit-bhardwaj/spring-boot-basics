package com.shobhit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shobhit.entity.Employ;

public interface IEmployDao extends JpaRepository<Employ, Integer> {
}