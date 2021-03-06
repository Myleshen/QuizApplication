package com.myleshen.quiz.security.utility;

import com.myleshen.quiz.security.model.UserDetailsModel;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
public class ConvertUserDetailModelToUserDetailsUtility implements UserDetails {

    private UserDetailsModel user;

    public ConvertUserDetailModelToUserDetailsUtility(UserDetailsModel userDetailsModel){
        this.user = userDetailsModel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> grantedAuthorityList = new ArrayList<>();
        String[] rolesList = user.getRoles().split(",");
        for (String role: rolesList) {
            grantedAuthorityList.add(new SimpleGrantedAuthority(role));
        }
        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.getIsNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getIsAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.getIsCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return user.getIsActive();
    }
}
