package fr.fms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.dao.ArticleRepository;
import fr.fms.entities.Article;

@Controller

public class ArticleController {

	@Autowired
	ArticleRepository articleRepository;
	
	//@RequestMapping(value="/index", method=RequestMethod.GET)

	@GetMapping("/")
	   public String main() {
	      return "main";
	   }
	
	@GetMapping("/login")
	public String login(){
		return "login";				// vise la vue
	}
	
@GetMapping("/index")
	public String index(Model model, @RequestParam(name="page", defaultValue= "1") int page,
			@RequestParam(name="keyword", defaultValue= "") String kw
			) {								// recupere le model pour faire les opérations
		//pagination
		Page<Article> articles = articleRepository.findByDescriptionContains(kw, PageRequest.of(page, 5));
		model.addAttribute("listArticle" , articles.getContent());
		model.addAttribute("pages" , new int[articles.getTotalPages()]);
		model.addAttribute("currentPage" , page);
		model.addAttribute("keyword" , kw);
		
		
		return "articles";				// vise la vue
	}
	
	@GetMapping("/article")
	public String article(){
		return "article";				// vise la vue
	}


@GetMapping("/delete")
public String delete(Long id, int page, String keyword) {
	articleRepository.deleteById(id);
	return "redirect:/index?page="+page+"&keyword="+keyword;
}

@PostMapping("/update")
public String update(@RequestParam(name="id", defaultValue= "1") Long id, @RequestParam(name="price", defaultValue= "0") double price, @RequestParam(name="page", defaultValue= "0") int page, @RequestParam(name="keyword", defaultValue= "") String keyword) {
	// double price = Double.parseDouble(newPrice);
	articleRepository.updateArticlePrice(price, id);
	return "redirect:/index?page="+page+"&keyword="+keyword;
}

@PostMapping("/save")
public String save(Model model, @Valid Article article, BindingResult bindingResult) {
	if(bindingResult.hasErrors()) return "article";
	articleRepository.save(article);
	return "article";
}




// -----------------------
@ModelAttribute("article")
public Article createModel() {
    return new Article();
}

	
	


}
