package fr.fms.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.fms.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{
	public List<Article> findAll();
	public Page<Article> findByDescriptionContains(String description, Pageable pageable);
	public void deleteById(Long id);
	
	@Modifying
	@Transactional
	@Query("update Article a set a.price= :p where a.id= :id")
	public void updateArticlePrice(@Param("p")double price,@Param("id")long id);

}
