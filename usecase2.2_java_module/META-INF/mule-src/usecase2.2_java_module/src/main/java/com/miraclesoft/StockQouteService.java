package com.miraclesoft;
public class StockQouteService {
	public static String sayHello(String name,String country)
	{
	return "Hello "+name +" from "+country;	
	}
	public String getStockPrice(String stockSymbol)
	{
		if(stockSymbol.equals("Microsoft")){
			return "100";
	}
	else if(stockSymbol.equals("Google")){
		return "200";
	}
	else{
		return "Stock doesn't exist";
	}
	}
}
