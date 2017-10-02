package com.liferay.taxsales.dto;

import java.math.BigDecimal;

public class InputDTO {

	private String name;
	private BigDecimal price = new BigDecimal(0);
	private boolean flagIsPercentageTaxDomestic;
	private boolean flagAddImportedTax;
	private boolean flagIsExempt;
	private BigDecimal calcPercentageTax = new BigDecimal(0);





	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public boolean isFlagIsPercentageTaxDomestic() {
		return flagIsPercentageTaxDomestic;
	}
	public void setFlagIsPercentageTaxDomestic(boolean flagIsPercentageTaxDomestic) {
		this.flagIsPercentageTaxDomestic = flagIsPercentageTaxDomestic;
	}
	public boolean isFlagAddImportedTax() {
		return flagAddImportedTax;
	}
	public void setFlagAddImportedTax(boolean flagAddImportedTax) {
		this.flagAddImportedTax = flagAddImportedTax;
	}
	public boolean isFlagIsExempt() {
		return flagIsExempt;
	}
	public void setFlagIsExempt(boolean flagIsExempt) {
		this.flagIsExempt = flagIsExempt;
	}
	public BigDecimal getCalcPercentageTax() {
		return calcPercentageTax;
	}
	public void setCalcPercentageTax(BigDecimal calcPercentageTax) {
		this.calcPercentageTax = calcPercentageTax;
	}

 
	
	@Override
	public String toString() {
		return "\n\n Name=" + name + ",\n Price="+ price+ "]";
	}





}
