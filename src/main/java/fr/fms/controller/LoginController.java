package fr.fms.controller;

import java.security.Principal;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// definit REST
@RestController
public class LoginController

{
   @RolesAllowed("USER")
   @RequestMapping("/*")
   public String getUser()
   {
      return "Welcome User";
   }

   @RolesAllowed({"USER","ADMIN"})
   @RequestMapping("/admin")
   public String getAdmin()
   {
      return "Welcome Admin";
   }
   
   // utilisation des tokens
   @RequestMapping("/*")
   public String getUserInfo(Principal user) {
	   StringBuffer userInfo= new StringBuffer();			// StringBuffer met en mémoire l'user pour le rendre generique aux oAtuh
	   return userInfo.toString();
   }
   
   private StringBuffer getUsernamePasswordLoginInfo(Principal user)
   {
      StringBuffer usernameInfo = new StringBuffer();
      
      UsernamePasswordAuthenticationToken token = ((UsernamePasswordAuthenticationToken) user);
      if(token.isAuthenticated()){
         User u = (User) token.getPrincipal();
         usernameInfo.append("Welcome, " + u.getUsername());
      }
      else{
         usernameInfo.append("NA");
      }
      return usernameInfo;
   }
   
   private StringBuffer getOauth2LoginInfo(Principal user){
	   StringBuffer protectedInfo = new StringBuffer();
	   OAuth2AuthenticationToken authToken = ((OAuth2AuthenticationToken) user);
	}
   
}