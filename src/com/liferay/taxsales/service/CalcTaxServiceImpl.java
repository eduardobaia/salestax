package com.liferay.taxsales.service;

import java.util.List;

import com.liferay.taxsales.dto.InputDTO;

public class CalcTaxServiceImpl implements CalcTaxService{

	@Override
	public void calculateTaxes(List<InputDTO> inputDTOList) {
		
		new CalculatorTaxServiceImpl().calculateTax(inputDTOList);
		
		
	}

}
