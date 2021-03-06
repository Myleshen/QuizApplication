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
        Set<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> grantedAuthorityList = new ArrayList<>();

        for (Role role : roles) {
            grantedAuthorityList.add(new SimpleGrantedAuthority(role.getRoleName()));
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
        return user.getIsExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getIsAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.getIsCredentialsExpired();
    }

    @Override
    public boolean isEnabled() {
        return user.getIsActive();
    }
}
