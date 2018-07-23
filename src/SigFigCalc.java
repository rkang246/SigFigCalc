import java.text.*;

/**Operations
 */

public class SigFigCalc {
	public SigFigCalc() {}
    /** Returns the number of significant figures in a number.
     * 
     *  @param num, the number to be counted for significant figures
     *  @return the number of significant figures in num
     *  Precondition: num is a nonempty string which can be parsed into a double.
     *  Postcondition: an integer is returned for the number of significant figures in the input
     */
    public int countSigFigs(String num) {
    	
        if (Double.parseDouble(num) == 0) { //"0", or any of its variants, has zero significant figures
            return 0;
        }
        
        int sigFigs = 0; //Value to return
        
        int decPointInd = -1;
        /**
         * non-zero digits are always significant
         */
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) != '0' && num.charAt(i) != '.' && num.charAt(i) != '-') {
                sigFigs++;
            }
            if (num.charAt(i) == '.') {
                decPointInd = i;
            }
        }
        
        /**
         * Zeros between two non-zero are sig
         */
        int firstNonZero = -1;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) != '0' && num.charAt(i) != '.' && num.charAt(i) != '-') {
                firstNonZero = i;
                break;
            }
        }

        for (int i = firstNonZero; i < num.length(); i++) {
            if (num.charAt(i) == '0') {
                int temp = 0;
                while (true) {
                    temp++;
                    i++;
                    
                    if (i >= num.length()) {
                        break;
                    }
                    if (num.charAt(i) != '0') {
                        sigFigs += temp;
                        break;
                        
                    }
                    
                }
            }
        }

        /**
         * trailing zeros with decimal are significant
         */
        //System.out.println(decPointInd + " " + firstNonZero);
        if (decPointInd != -1) {
            int trailingZeros = 0;
            for (int i = num.length() - 1; i >= decPointInd; i--) {
                if (num.charAt(i) == '0') {
                    trailingZeros++;
                }
                else {
                    sigFigs += trailingZeros;
                    break;
                }
            }
        }
        return sigFigs;

    }
    
    /** Adds two numbers together in accordance to significant figure rules
     * 
     * @param d1, the first number to be added
     * @param d2, the second number to be added
     * @return the sum of d1 and d2, following significant figure rules
     * Precondition: Both d1 and d2 are nonempty strings which can be parsed into a double
     * Postcondition: A string is returned representing the sum of d1 and d2 in accordance to significant figure rules
     */
    public String add(String d1, String d2) {
        
        String result = "" + (Double.parseDouble(d1) + Double.parseDouble(d2)); //Add the numbers
        
        //Determine the least precise value
        int dpi1 = -1;
        int dpi2 = -1;
        for (int i = 0; i < d1.length(); i++) {
            if (d1.charAt(i) == '.') {
                dpi1 = i;
                break;
            }
        }
        for (int i = 0; i < d2.length(); i++) {
            if (d2.charAt(i) == '.') {
                dpi2 = i;
                break;
            }
        }
        
        //If one or both numbers have no decimal, just round to whole number
        if (dpi1 == -1 || dpi2 == -1) {
        	DecimalFormat df = new DecimalFormat("0");
        	return "" + (df.format(Double.parseDouble(result)));
        }
        
        int toR = Math.min(d1.length() - dpi1 - 1, d2.length() - dpi2 - 1);
        
        int decInd = 0;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '.') {
                decInd = i;
                break;
            }
        }
        //('decInd #s.toR#s) Round the sum based on the least precise value's decimal places
        String format = "";
        for (int i = 0; i < decInd; i++) {
            format += "0";
        }
        format+=".";
        for (int j = 0; j < toR; j++) {
            format+= "0";
        }
        
        DecimalFormat df = new DecimalFormat(format);
        return "" + df.format(Double.parseDouble(result));
    }
    
    /** Subtract two numbers together in accordance to significant figure rules
     * 
     * @param d1, the first number to be subtracted from
     * @param d2, the second number to be subtracted by
     * @return the difference between d1 and d2, following significant figure rules
     * Precondition: Both d1 and d2 are nonempty strings which can be parsed into a double
     * Postcondition: A string is returned representing the difference between d1 and d2 in accordance to significant figure rules
     */
    public String subtract(String d1, String d2) {
        //Additional method works with negatives.
    	//Therefore...
    	if (d2.charAt(0) == '-') { //prevent "--3"
    		return add(d1, d2.substring(1));
    	}
    	return add(d1, "-" + d2);
        
    }

    /** Round a number to an amount of significant figures
     * 
     * @param num, the number to be rounded
     * @param sigFigs, the number of significant figures num is to be rounded to
     * @return num rounded to sigFigs significant figures
     * Precondition: num is a nonempty string which can be parsed into a double and sigFigs is an integer
     * Postcondition: A string is returned representing num rounded to sigFig significant figures
     */
    public String roundTo(String num, int sigFigs) {
    	
    	//0 Sig figs is 0
    	if (sigFigs == 0) {
    		return "0";
    	}
    	//if num does not have enough significant figures, if num has a decimal point, add zeros, else, add a decimal point plus zeros
    	//Increase sig figs
    	if (countSigFigs(num) < sigFigs) {
    		boolean hasDecimal = false;
    		for (int i = 0; i < num.length(); i++) {
    			if (num.charAt(i) == '.') {
    				hasDecimal = true;
    				break;
    			}
    		}
    		String addOn = "";
    		if (!hasDecimal) {
    			addOn += ".";
    		}
    		for (int i = 0; i < sigFigs - countSigFigs(num); i++) {
    			addOn += "0";
    		}
    		num += addOn;
    	}
    	
    	//if num has too many significant figures, decrease
    	//Decrease sig figs
    	while (countSigFigs(num) > sigFigs) {
    		int decInd = -1;
    		for (int i = 0; i < num.length(); i++) {
    			if (num.charAt(i) == '.') {
    				decInd = i;
    				break;
    			}
    		}
    		if (decInd != -1) {
    			String format = "";
    			for (int i = 0; i < num.length() - 1; i++) {
    				if (num.charAt(i) != '.' && num.charAt(i) != '-') {
    					format += "0";
    				}
    				else if (num.charAt(i) == '.') {
    					format += ".";
    				}
    			}
    			DecimalFormat df = new DecimalFormat(format);
    			num = "" + (df.format(Double.parseDouble(num)));
    		}
    		else if (decInd == -1) {
    			for (int i = num.length() - 1; i >= 0; i--) {
    				if (num.charAt(i) != '0' && num.charAt(i) != '-') {
    					StringBuilder sb = new StringBuilder(num);
    					sb.setCharAt(i, '0');
    					num = sb.toString();
    					break;
    				}
    			}
    		}
    	}
    		
    	//remove final decimal point if need be
    	if (num.charAt(num.length() - 1) == '.' && num.charAt(num.length() - 2) != '0') {
    		num = num.substring(0, num.length() - 1);
    	}
    	return num;
    
    }

    /** Multiplies two numbers in accordance to significant figure rules
     * 
     * @param d1, the first factor to be multiplied
     * @param d2, the second factor to be multiplied
     * @return The product of d1 and d2, following significant figures rules
     * Precondition: Both d1 and d2 are nonempty strings which can be parsed into a double
     * Postcondition: A string is returned representing the product of d1 and d2 in accordance to sig fig rules
     */
    public String multiply(String d1, String d2) {
    	int toRound = Math.min(countSigFigs(d1), countSigFigs(d2));
    	if (Double.isInfinite(Double.parseDouble(d1) * Double.parseDouble(d2))) {
    		return "Error: Overflow";
    	}
    	return roundTo("" + (Double.parseDouble(d1) * Double.parseDouble(d2)), toRound);
    }
    
    /** Divides two numbers in accordance to significant figure rules
     * 
     * @param d1, the dividend
     * @param d2, the divisor
     * @return The quotient of d1 and d2, following significant figures rules
     * Precondition: Both d1 and d2 are nonempty strings which can be parsed into a double
     * Postcondition: A string is returned representing the quotient of d1 and d2 in accordance to sig fig rules
     */
    public String divide(String d1, String d2) {
    	if (Double.parseDouble(d2) == 0) {
    		return "Error: Divide by 0";
    	}
    	int toRound = Math.min(countSigFigs(d1), countSigFigs(d2));
    	return roundTo("" + (Double.parseDouble(d1) / Double.parseDouble(d2)), toRound);
    }
    
    /** Finds the square root of a number in accordance to significant figure rules
     * 
     * @param d1, the number to find the square root of
     * @return The square root of d1, following significant figure rules
     * Precondition: d1 is a nonempty string which can be parsed into a double
     * Postcondition: A string is returned representing the square root of d1 in accordance to sig fig rules
     */
    public String sqrt(String d1) {
    	if (Double.parseDouble(d1) < 0) {
    		return "Error: Nonreal answers";
    	}
    	int toRound = countSigFigs(d1);
    	return roundTo("" + (Math.sqrt(Double.parseDouble(d1))), toRound);
    }
    
    /** Finds the exponent of a number in accordance to significant figure rules
     * 
     * @param d1, the base
     * @param d2, the power
     * @return d1^d2, following significant figure rules
     * Precondition: Both d1 and d2 are nonempty strings which can be parsed into a double
     * Postcondition: A string is returned representing d1^d2 in accordance to sig fig rules
     */
    public String exp(String d1, String d2) {
    	if (Double.parseDouble(d1) == 0 && d2.contains("-")) {
    		return "Error: Divide by 0";
    	}
    	if (Double.isInfinite(Math.pow(Double.parseDouble(d1), Double.parseDouble(d2)))) {
    		return "Error: Overflow";
    	}
    	int toRound = countSigFigs(d1);
    	return roundTo("" + (Math.pow(Double.parseDouble(d1), Double.parseDouble(d2))), toRound);
    }

}