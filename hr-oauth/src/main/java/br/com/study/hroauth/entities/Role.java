package br.com.study.hroauth.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable{
	private static final long serialVersionUID = 2375915958439004025L;
	
    private Long id;
    private String roleName;
}
