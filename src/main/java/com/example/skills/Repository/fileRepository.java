package com.example.skills.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.skills.Domain.FileEntity;

public interface fileRepository extends JpaRepository<FileEntity, Integer> {

}
