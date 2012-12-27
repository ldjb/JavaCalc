/*******************************************************************************
** Division.java                                                              **
** -------------------------------------------------------------------------- **
** Subclass of Operator.java. Performs division.                              **
** -------------------------------------------------------------------------- **
** Developed by Leon Byford <ldjb20@bath.ac.uk>                               **
** Last modified: 27 December 2012                                            **
*******************************************************************************/

public class Division extends Operator {
	public Division() {
		super.setData(new Object[] {3, "left"});
	}
	public Double operate(Double var1, Double var2) {
		return var1 / var2;
	}
}