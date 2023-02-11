package br.com.study.hrpayroll.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable{
	private static final long serialVersionUID = -6482387152307636368L;
	
	private String name;
    private Double dailyIncome;
    private Integer days;

    public double getTotal(){
        return this.dailyIncome * this.days;
    }
}
