package application;

public class CalcImpl implements Calculator {

	private char action; // Polecenie
	private Double var1;
	private Double var2;
	private boolean eq = false; // Czy to co wyœwietlane jest wynikiem "="
	
	public boolean getEq()
	{
		return eq;
	}
	public void setVar1(Double newVar1)
	{
		var1 = newVar1;
	}
	public void setVar2(Double newVar2)
	{
		var2 = newVar2;
	}
	public void setEq(boolean newEq)
	{
		eq = newEq;
	}
	
	public String eqAction(String txt)
	{
		if(var1 != null)
		{
			if(var2 == null)
			{
				if(txt.isEmpty())
				{
					eq = true;
					return "Blad!";
				}
				else
				{
					var2 = Double.parseDouble(txt);
				}
			}
			if(!eq)
			{
				var2 = Double.parseDouble(txt);
			}
			switch(action)
			{
				case '+':
					var1 = var1 + var2;
					eq = true;
					return String.valueOf(var1);
				case '-':
					var1 = var1 - var2;
					eq = true;
					return String.valueOf(var1);
				case '*':
					var1 = var1 * var2;
					eq = true;
					return String.valueOf(var1);
				case '%':
					var1 = var1%var2;
					eq = true;
					return String.valueOf(var1);
				case '/':
					if(var2 != 0.0)
					{
						var1 = var1 / var2;
						eq = true;
						return String.valueOf(var1);
					}
					else
					{
						eq = true;
						return "Blad! Dzielenie przez 0!";
					}
			}
		}
		return txt;
	}
	
	public String doubleAction(String txt, char cmd)  // Funkcja do obs³ugi 2 wartoœci
	{
		if(txt.isEmpty())
		{
			action=cmd;
			return ""; 
		}
		else
		{
			if(var1!=null && !eq)
			{
				String result = eqAction(txt);
				action=cmd;
				return result;
			}
			else 
			{
				var1 = Double.parseDouble(txt);
				action=cmd;
				return "";
			}
		}
	}
	
	public String singleAction(String txt, char cmd) //Funkcja do obs³ugi dzia³añ na 1 wartoœci
	{
		if(!txt.isEmpty())
		{
			switch(cmd)
			{
				case 'l':
					return String.valueOf(Math.log(Double.parseDouble(txt)));
				case 'f':
					return String.valueOf(1/Double.parseDouble(txt));
				case 's':
					return String.valueOf(Math.sqrt(Double.parseDouble(txt)));
			}
			return "";
		}
		else
		{
			return "";
		}
	}
}