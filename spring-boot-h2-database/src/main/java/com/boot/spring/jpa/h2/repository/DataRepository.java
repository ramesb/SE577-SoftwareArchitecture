package com.boot.spring.jpa.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.spring.jpa.h2.model.Repo;

public interface DataRepository extends JpaRepository<Repo, Long> {
  List<Repo> findByPublished(boolean published);

  List<Repo> findByTitleContaining(String title);
}
