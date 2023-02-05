package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController{
	@FXML
	private Button btnC, btnS, btnAdd, btnDif, btnMul, btnDiv, btnSqr, btnFra, btnLog, btnPer, btnEq, Btn;
	@FXML
	private TextField txtFld;
	
	private boolean Dot; // Czy w polu jest kropka
	
	private Calculator calculator;
	
	public CalculatorController() {
		//Tutaj nigdy nie edytowaæ zmiennych
		calculator = new CalcImpl();
	}
	
	public CalculatorController(CalcImpl calculator) {
		this.calculator = calculator;
	}
	
	@FXML
	public void initialize() {
		Dot = false; //Kropki nie ma poniewaz pole puste
	}
	
	@FXML
	public void onActionBtndot(ActionEvent event) { //Kontrola kropki
		if(!Dot)
		{
			if(txtFld.getText().equals(""))
			{
				txtFld.appendText("0.");
				Dot = true;
			}
			else
			{
				txtFld.appendText(".");
				Dot = true;
			}
		}
	}

	public void clearField() //Czyszczenie pola i resetowanie kropki
	{
		txtFld.setText("");
		Dot = false;
	}
	
	// Funkcje do przycisków obliczeñ
	
	@FXML
	public void onActionBtn(ActionEvent event) //Przyciski cyfr
	{
		if(calculator.getEq())
		{
			clearField();
			calculator.setEq(false);
		}
		Button button = (Button)event.getSource();
		txtFld.appendText(button.getText());
	}
	
	@FXML
	public void onActionBtnC(ActionEvent event) { //Kasowanie
		clearField();
		calculator.setVar1(null);
		calculator.setVar2(null);
		calculator.setEq(false);
	}
	
	@FXML
	public void onActionBtnS(ActionEvent event) { //Zmiana znaku
		if(!txtFld.getText().isEmpty())
		{
			txtFld.setText(String.valueOf(Double.parseDouble(txtFld.getText())*-1));
		}
	}
	
	@FXML
	public void onActionBtnEq(ActionEvent event) { //Rowna sie
		txtFld.setText(calculator.eqAction(txtFld.getText()));
	}

	@FXML
	public void onActionBtnAdd(ActionEvent event) { //Dodawanie
		txtFld.setText(calculator.doubleAction(txtFld.getText(),'+'));
	}
	@FXML
	public void onActionBtnDif(ActionEvent event) { //Odejmowanie
		txtFld.setText(calculator.doubleAction(txtFld.getText(),'-'));
	}
	@FXML
	public void onActionBtnDiv(ActionEvent event) { //Dzieleni
		txtFld.setText(calculator.doubleAction(txtFld.getText(),'/'));
	}
	@FXML
	public void onActionBtnMul(ActionEvent event) { //Mnozenie
		txtFld.setText(calculator.doubleAction(txtFld.getText(),'*'));
	}
	@FXML
	public void onActionBtnPer(ActionEvent event) { //Modulo
		txtFld.setText(calculator.doubleAction(txtFld.getText(),'%'));
	}
	
	@FXML
	public void onActionBtnSqr(ActionEvent event) { //Pierwiastek
		txtFld.setText(calculator.singleAction(txtFld.getText(),'s'));
	}
	@FXML
	public void onActionBtnFra(ActionEvent event) { //Ulamek
		txtFld.setText(calculator.singleAction(txtFld.getText(),'f'));
	}
	@FXML
	public void onActionBtnLog(ActionEvent event) { //Logarytm
		txtFld.setText(calculator.singleAction(txtFld.getText(),'l'));
	}
	
}
