package com.liferay.taxsales.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.liferay.taxsales.converter.ConverterDTO;
import com.liferay.taxsales.dto.InputDTO;

public class CalculatorTaxServiceImpl implements CalculatorTaxService{

	private static final BigDecimal HUNDRED = new BigDecimal(100);
	private static final int IMPORTED_TAX = 5;
	private static final int SIMPLE_TAX = 10;
	private static final int BASIC_AND_IMPORTED_TAX = 15;
	private static final int ZERO = 0;
	private static final BigDecimal ROUND_OF_FACTOR = new BigDecimal("0.05");

	
	@Override
	public void calculateTax(List<InputDTO> inputDTOList) {
		// TODO Auto-generated method stub
		
		List<InputDTO> newInputDTOList = this.calculateTaxPercentage(inputDTOList);
		System.out.println(" \n \n \n  [PRODUCT LIST ] \n \n ");
		this.displayAll(newInputDTOList);
	}

	@Override
	public List<InputDTO> calculateTaxPercentage(List<InputDTO> inputDTOList) {
		// TODO Auto-generated method stub
		
		BigDecimal taxSales=null;
		BigDecimal taxPercentage=null;
		
		List<InputDTO> newInputDTOList = new ArrayList<InputDTO>();
		
//		if(inputDTOList !=null){
//			
//			for(int i=0; i<inputDTOList.size();  i++){
//				
//				
//				
//			}
//			
//		
//			
//		}
		
		for(InputDTO  inputDTO : inputDTOList){

			if(inputDTO.isFlagIsExempt()){
				taxPercentage = new BigDecimal(ZERO);
			} else if(inputDTO.isFlagIsPercentageTaxDomestic() && inputDTO.isFlagAddImportedTax()){
				taxPercentage = new BigDecimal(BASIC_AND_IMPORTED_TAX);
			} else if(inputDTO.isFlagAddImportedTax() ){
				taxPercentage = new BigDecimal(IMPORTED_TAX);
			}	else if(inputDTO.isFlagIsPercentageTaxDomestic()){
				taxPercentage = new BigDecimal(SIMPLE_TAX);
			}
			
			// Calculate the tax 
			taxSales = inputDTO.getPrice().multiply(taxPercentage).divide(HUNDRED);
			
			newInputDTOList = new ConverterDTO().converterDTO(inputDTO, taxSales, newInputDTOList);
			

		}
		return newInputDTOList;
	}

	@Override
	public void displayAll(List<InputDTO> inputDTOList) {
		// TODO Auto-generated method stub
		if(inputDTOList != null){
		
			System.out
			.println("=============================================================================");
			System.out.println("\t" + " Name "
					+ "\t" + "\t" + "\t" +"\t"+ " Price ");
			System.out
			.println("=============================================================================");

			for( InputDTO inputDTO: inputDTOList){
				System.out.println( inputDTO.getName()+ "\t \t"+ " > "
			     + addPriceAndTax(inputDTO.getCalcPercentageTax(), inputDTO.getPrice()));
				
			}
			
			System.out.println("\nAll Sales Tax : "
					+ allTaxTotal(inputDTOList)
					);
			
			System.out.println("TOTAL : "+ totalPrice(inputDTOList) );
			
		}
		
		
	}
	
	public BigDecimal addPriceAndTax(BigDecimal calculateTaxPercentage, BigDecimal price){
		BigDecimal additionalTax = calculateTaxPercentage.add(price);
		additionalTax= roundOff(additionalTax);
		
		return additionalTax;
	}


	private BigDecimal roundOff(BigDecimal value){
		value= value.divide(ROUND_OF_FACTOR);
		value=  new BigDecimal(Math.ceil(value.doubleValue()));
		value= value.multiply(ROUND_OF_FACTOR);
		
		return value;
	}
	
	
	private BigDecimal totalPrice(List<InputDTO> inputDTOList){
		
		BigDecimal total= new BigDecimal(0);
		
		if(inputDTOList !=null){
			
			for(InputDTO inputDTO: inputDTOList){
				
				total = total.add(inputDTO.getPrice().add(inputDTO.getCalcPercentageTax()));
				
			}
			
		}
		
		total= this.roundOff(total);
		
		return total;
	}
	
	
	private BigDecimal allTaxTotal(List<InputDTO> inputDTOList){
		
		BigDecimal total = new BigDecimal(0);
		
		if(inputDTOList != null){
			
			for(InputDTO inputDTO: inputDTOList){
				
				total= total.add(inputDTO.getCalcPercentageTax());
				
			}
			total = roundOff(total);
		}
		
		
		return total;
	}
	
	
	
	
	
}
