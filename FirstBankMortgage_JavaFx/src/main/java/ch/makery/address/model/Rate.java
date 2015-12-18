package ch.makery.address.model;


import org.apache.poi.ss.formula.functions.FinanceLib;

import base.RateDAL;
import domain.RateDomainModel;


public class Rate extends RateDAL{
	
	public static double getPayment(int CreditScore, int NumberOfPayments, int CostOfHouse)
	{
		//FinalExam
		//	Normally this kind of method would be in a BLL, but alas...
		
		//	Figure out payment based on:
		//	Interest rate
		//	PV
		//	FV (make FV = 0, unless you want a balloon payment
		//	Compounding = True
		//	Number of Payments (passed in)
		
		double payments = FinanceLib.pmt((getRate(CreditScore)/100.0)/12,NumberOfPayments,CostOfHouse,0,false);
		
		return payments;
	}
}
