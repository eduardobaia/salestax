package com.liferay.taxsales.converter;

import java.math.BigDecimal;
import java.util.List;

import com.liferay.taxsales.dto.InputDTO;

public class ConverterDTO {

	public List<InputDTO> converterDTO(InputDTO inputDTO, BigDecimal taxSales
			, List<InputDTO> newInputDTOList){

		
		InputDTO newInputDTO = new InputDTO();
		
		newInputDTO.setName(inputDTO.getName());
		newInputDTO.setPrice(inputDTO.getPrice());
		newInputDTO.setFlagAddImportedTax(inputDTO.isFlagAddImportedTax());
		newInputDTO.setCalcPercentageTax(taxSales);
		newInputDTO.setFlagIsPercentageTaxDomestic(inputDTO.isFlagIsPercentageTaxDomestic());
		newInputDTO.setFlagIsExempt(inputDTO.isFlagIsExempt());
	
		//Add To List
		newInputDTOList.add(newInputDTO);
		
		return newInputDTOList;
	}
	
	
	
}
