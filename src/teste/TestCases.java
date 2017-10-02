package teste;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.liferay.taxsales.dto.InputDTO;
import com.liferay.taxsales.service.CalcTaxServiceImpl;

import junit.framework.TestCase;



public class TestCases extends TestCase{

	
	public void testeScenarioInput01(){
		
		
		InputDTO inputDTO = null;
		
		List<InputDTO> inputDTOList = new ArrayList<InputDTO>();
		
		inputDTO = new InputDTO();
		
		inputDTO.setName("BOOK");
		
		inputDTO.setFlagIsExempt(true);
		inputDTO.setPrice(new BigDecimal(12.49));
		
		inputDTOList.add(inputDTO);
		
		inputDTO = new InputDTO();
		
		inputDTO.setName("Music CD");
		
		inputDTO.setPrice(new BigDecimal(14.99));
		inputDTO.setFlagIsPercentageTaxDomestic(true);
			
		inputDTOList.add(inputDTO);
		
		inputDTO = new InputDTO();
		
		inputDTO.setName("Chocolate Bar");
		
		inputDTO.setPrice(new BigDecimal(0.85));
		inputDTO.setFlagIsExempt(true);
		
		inputDTOList.add(inputDTO);
		
		new CalcTaxServiceImpl().calculateTaxes(inputDTOList);
		
		
	}
	
	
	public void testeScenario02(){
		
	InputDTO inputDTO = null;
		
		List<InputDTO> inputDTOList = new ArrayList<InputDTO>();
		
		inputDTO = new InputDTO();
		
		inputDTO.setName("Imported box of chocolates ");
		inputDTO.setFlagAddImportedTax(true);
		inputDTO.setPrice(new BigDecimal(10.00));
		
		inputDTOList.add(inputDTO);
		
		inputDTO = new InputDTO();
		
		inputDTO.setName("Imported bottle of perfume");
		
		inputDTO.setPrice(new BigDecimal(47.50));
		inputDTO.setFlagAddImportedTax(true);
		inputDTO.setFlagIsPercentageTaxDomestic(true);
			
		inputDTOList.add(inputDTO);
		
		new CalcTaxServiceImpl().calculateTaxes(inputDTOList);
		
		
		
	}
	
}
