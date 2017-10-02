package com.liferay.taxsales.service;

import java.util.List;

import com.liferay.taxsales.dto.InputDTO;

public interface CalculatorTaxService {

	
	public void calculateTax(List<InputDTO> inputDTOList);
	
	public List<InputDTO> calculateTaxPercentage(List<InputDTO> inputDTOList);
	
	public void displayAll(List<InputDTO> inputDTOList);
	
	
}
