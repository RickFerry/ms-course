package br.com.study.hroauth.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = 439311252199146583L;
	
    @NonNull
    private Long id;
    
    @NonNull
    private String name;
    
    @NonNull
    private String email;
    
    @NonNull
    private String password;

    @Setter(value = AccessLevel.NONE)
    private Set<Role> roles = new HashSet<>();
}
