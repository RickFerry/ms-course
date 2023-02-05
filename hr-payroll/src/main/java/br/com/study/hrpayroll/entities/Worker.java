package br.com.study.hrpayroll.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Worker implements Serializable{
    
    private Long id;
    private String name;
    private Double dailyIncome;
}
