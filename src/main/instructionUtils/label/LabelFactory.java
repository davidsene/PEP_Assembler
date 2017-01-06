package main.instructionUtils.label;

import java.util.ArrayList;
import java.util.List;

import main.exception.AssemblerException;


public class LabelFactory {
	
	/**
	 * Hold the list of declared labels
	 */
	private List<Label> labelsList;
	
	
	/**
	 * Constructor
	 */
	public LabelFactory() {
		this.labelsList = new ArrayList<>();
	}



	/**
	 * Build a label object
	 * 
	 * @param labelNameWithDeuxpoints
	 * @param operandesString
	 * @param adress
	 * @return
	 * @throws AssemblerException
	 */
	public Label buildLabel(String labelNameWithDeuxpoints, String operandesString, int adress) throws AssemblerException{
		
		String labelName =labelNameWithDeuxpoints.substring(0,labelNameWithDeuxpoints.length()-1); 
		

		if(! operandesString.trim().isEmpty()){
			
			throw new AssemblerException("Syntax Error : Label Name should be single in a line ", AssemblerException.ERR_ASM_RUNTIME_FAILED);
		}
		
		Label lab =  new Label(labelName.trim(),adress);
		this.addLabeltoList(lab);
		
		return lab;	      
	}
	
	
	
	
	/**
	 * Add a new label object to the list of declared label 
	 * 
	 * @param label
	 * @throws AssemblerException for duplicated declaration
	 */
	private void addLabeltoList(Label label) throws AssemblerException{
		
		if( this.getLabelFromName(label.getName())!=null)
			throw new AssemblerException("Syntax Error : Duplicated Declaration for Label ' "+label.getName()+" '", AssemblerException.ERR_ASM_RUNTIME_FAILED);
		
		this.labelsList.add(label);
	}
	
	
	
	
	/**
	 * @param nom
	 * @return A label object from the list of declared labels 
	 */
	public Label getLabelFromName(String nom) {
		
		for (int i = 0; i < this.labelsList.size(); i++) {
			if ( this.labelsList.get(i).getName().compareToIgnoreCase(nom) == 0 )  return labelsList.get(i);	
		}
		
		return null;
	}
	
}
