package com.gfs.erm.web.form;

/**
 * This class contain a data of success occurrence into UI layer.
 */
public class GeneralSuccessForm extends BaseForm {
    
	private static final long serialVersionUID = 1L;
	
    /** The successfully message description */
    private String successMessage;

    /////////////////////////////////////////////
    public String getSuccessMessage() {
        return successMessage;
    }
    public void setSuccessMessage(String newValue) {
        this.successMessage = newValue;
    }
	@Override
	public String execute() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		
	}
}
