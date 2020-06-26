package be.ipam.SGBD.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import be.ipam.SGBD.Repositories.*;
import be.ipam.SGBD.classes.*;



@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  @Autowired
  ReaderDAO readerDAO;


  @Override
  public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
    
	  Optional<Reader> stu = readerDAO.findByemail(mail);
	    
	  Optional<JwtUserDetails> user = Optional.empty();
	  
	  if(stu.isPresent()) {
		  user = Optional.of(new JwtUserDetails(stu.get().getReaderId(),stu.get().getEmail(),stu.get().getPassword(),"ROLE_READER")); 
	  }
	  


	  if (!user.isPresent()) {
		  throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", mail));
	  }

	  return user.get();
  }

}