package com.adminappproject.trajan.config;

import com.adminappproject.trajan.dto.PermissionDTO;
import com.adminappproject.trajan.dto.UserDTO;
import com.adminappproject.trajan.dto.UserRoleDTO;
import com.adminappproject.trajan.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Transactional
public class CustomUserDetailsService implements UserDetailsService {
	 private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);
	 
		private UserService userService;

	    public CustomUserDetailsService(UserService userService){
	        this.userService=userService;
	    }

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        try {
	            UserDTO user = userService.findByUsername(username);
	            if (user == null) {
	                LOGGER.debug("user not found with the provided username");
	                return null;
	            }
	            LOGGER.debug(" user from username " + user.toString());
	            return new User(user.getUsername(), user.getPassword(), getAuthorities(user));
	        }
	        catch (Exception e){
	            throw new UsernameNotFoundException("User not found");
	        }
	    }

	    private Set<GrantedAuthority> getAuthorities(UserDTO user){
	        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
			Set<PermissionDTO> permissionDTOs = new HashSet<PermissionDTO>();

			for(UserRoleDTO role : user.getRoles()) {
				for(PermissionDTO permissionDTO : role.getPermissions()) {
					authorities.add(new SimpleGrantedAuthority(permissionDTO.getCode()));
				}
	        }


			LOGGER.debug("user authorities are " + authorities.toString());
	        return authorities;
	    }

}
