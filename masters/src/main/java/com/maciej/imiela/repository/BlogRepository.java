package com.maciej.imiela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maciej.imiela.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
