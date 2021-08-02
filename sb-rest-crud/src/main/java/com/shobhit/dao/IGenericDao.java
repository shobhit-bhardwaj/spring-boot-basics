package com.shobhit.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.shobhit.entity.IGenericEntity;

@NoRepositoryBean
public interface IGenericDao<T extends IGenericEntity<T>> extends JpaRepository<T, UUID> {
}