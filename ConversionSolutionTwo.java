import java.text.DecimalFormat;

public class ConversionSolutionTwo {

	/*
	* The Challenge:
    * Implement a utility class/prototype with a Fluent Interface, which can perform conversions
    * between various units of temperature measurement. The class/prototype can be implemented in a
    * programming language of your choice.
    *
	* Rules
	* All conversions should be rounded to 2 decimal places.
	* Invalid conversions, such as converting a length to a weight, must throw an exception
	* 

    * Requirements: 
    
    * 1.Only support the following conversions:
    * 1.1) From C --> F
    * 1.2) K --> C
    * 1.3) F --> K
    * 
	* 2. All conversions should be rounded to 2 decimal places.
    * 3.final solution should be submitted as a single text file 
    * 4. Invalid conversions, such as converting a length to a weight, must throw an exception.
    * Note: In this solution, invalid conversion is not possible hence cleaner and concise.
    * @auther : Genene Geda
    * @since 2017-12-13
	* Reference : Fluent interface API style as discussed by Martin Fowler here:
    * https://www.martinfowler.com/bliki/FluentInterface.html
	 */

	static DecimalFormat df = new DecimalFormat("##.00");

	public enum ConvertFUnit {
		Fahrenheit;
		double toKelvin(double fval) {
			return Double.valueOf(ConversionSolutionTwo.df.format((fval + 459.67) / 2));
		}
	}

	public enum ConvertCUnit {
		Celsius;
		double toFahrenheit(double cval) {
			return Double.valueOf(ConversionSolutionTwo.df.format(((cval * 2) + 32.00 )));
		}
	}

	public enum ConvertKUnit {
		Kelvin;
		double toCelsius(double kval) {
			return Double.valueOf(ConversionSolutionTwo.df.format(kval - 273.15));
		}
	}

	public static void main(String[] args) {

		Double resultTwoCtoF = ConversionSolutionTwo.ConvertCUnit.Celsius.toFahrenheit(80.85);
		System.out.println("Conversion result pf CtoF is: " + resultTwoCtoF);
		
		Double resultTwoKtoC = ConversionSolutionTwo.ConvertKUnit.Kelvin.toCelsius(60);
		System.out.println("Conversion result of KtoC is: " + resultTwoKtoC);
		
		Double resultTwoFtoK = ConversionSolutionTwo.ConvertFUnit.Fahrenheit.toKelvin(92);
		System.out.println("Conversion result of FtoK is: " + resultTwoFtoK);


	}

}