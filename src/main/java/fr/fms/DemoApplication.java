package fr.fms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.fms.dao.ArticleRepository;
import fr.fms.entities.Article;

@SpringBootApplication
@RestController
public class DemoApplication implements CommandLineRunner{
	
	@Autowired
	ArticleRepository articleRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		generateBDD();
	}
	
	public void generateBDD(){
		articleRepository.save(new Article("Samsung S8",250));
		articleRepository.save(new Article("Samsung S9", 300));
		articleRepository.save(new Article("Iphone 10",500));		
		articleRepository.save(new Article("Xiaomi MI11",100));
		articleRepository.save(new Article("OnePlus 9 Pro",200));
		articleRepository.save(new Article("Google Pixel 5",350));
		articleRepository.save(new Article("Poco F3",150));
		
		articleRepository.save(new Article("Dell 810",550));
		articleRepository.save(new Article("Asus F756",600));
		articleRepository.save(new Article("Asus E80",700));
		articleRepository.save(new Article("MacBook Pro",1000));
		articleRepository.save(new Article("MacBook Air",1200));
		
		articleRepository.save(new Article("IPad XL 5",300));
		articleRepository.save(new Article("IPad XL 7",500));
		articleRepository.save(new Article("GoPro",200));
		
		articleRepository.save(new Article("Panasonic",1500));
		articleRepository.save(new Article("Philips",450));	

	}


}
