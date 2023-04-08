package com.icrhrm1_automation;

public class DemoLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MathsFunctional mf=( c, d)->   {   //()->this is called lambda expression
			int result=c+d;    //It is applicable to only Functional interface
			return result;
			
			
		};
		int ad=mf.add(10, 20);
		System.out.println(ad);
	}
	}


