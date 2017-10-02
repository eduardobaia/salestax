package com.liferay.taxsales.service;

import java.util.List;

import com.liferay.taxsales.dto.InputDTO;

public interface CalcTaxService {

	
	public void calculateTaxes(List<InputDTO> inputDTOList);

	
}
