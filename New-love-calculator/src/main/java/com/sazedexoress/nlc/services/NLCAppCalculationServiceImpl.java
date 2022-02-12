package com.sazedexoress.nlc.services;

import org.springframework.stereotype.Service;

@Service
public class NLCAppCalculationServiceImpl implements NLCAppCalculationService{

	public static String LC_APP_FORMULA="FLAMES";
	
	@Override
	public String calculateRelation(String userName, String crashName) {
		
		int totalLengthOfBothName=userName.concat(crashName).toCharArray().length;
		int formulaLength=LC_APP_FORMULA.toCharArray().length;
		int result=totalLengthOfBothName % formulaLength;
		char resultChar=LC_APP_FORMULA.charAt(result);
		String resultString=whatsBetweenUs(resultChar);
		return resultString;
	}

	@Override
	public String whatsBetweenUs(char calculationResult) {
		
		String resultString=null;
		if (calculationResult=='F') {
			resultString=LoveCalculatorConstant.LC_APP_F;
		}
		else if (calculationResult=='L') {
			resultString=LoveCalculatorConstant.LC_APP_L;	
				}
		else if (calculationResult=='A') {
			resultString=LoveCalculatorConstant.LC_APP_A;
		}
		else if (calculationResult=='M') {
			resultString=LoveCalculatorConstant.LC_APP_M;
		}
		else if (calculationResult=='E') {
			resultString=LoveCalculatorConstant.LC_APP_E;
		}
		else if (calculationResult=='S') {
			resultString=LoveCalculatorConstant.LC_APP_S;
		}
		return resultString;
	}

}
