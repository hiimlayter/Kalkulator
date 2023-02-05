package application;

public interface Calculator {

	public void setVar1(Double newVar1);
	public void setVar2(Double newVar2);
	public void setEq(boolean newEq);
	public boolean getEq();
	
	public String eqAction(String txt);
	public String doubleAction(String txt, char cmd);
	public String singleAction(String txt, char cmd);
}
