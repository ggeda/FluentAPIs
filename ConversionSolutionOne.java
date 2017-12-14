import java.text.DecimalFormat;

public class ConversionSolutionOne {
	
	/*
	* The Challenge:
    * Implement a utility class/prototype with a Fluent Interface, which can perform conversions
    * between various units of temperature measurement. The class/prototype can be implemented in a
    * programming language of your choice.
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
    *
    * @auther : Genene Geda
    * @since 2017-12-13
	* Reference : Fluent interface API style as discussed by Martin Fowler here:
    * https://www.martinfowler.com/bliki/FluentInterface.html
	 */
	
	public enum Unit {C, F, K}

	private Unit fromUnit;
	private Unit toUnit;
	private double fromValue;

	private ConversionSolutionOne(double fromValue, Unit fromUnit) {
		this.fromUnit = fromUnit;
		this.fromValue = fromValue;
	}

	public static ConversionSolutionOne convertFrom (double value, Unit fromUnit) {
		return new ConversionSolutionOne(value, fromUnit);
	}

	public ConversionSolutionOne convertTo (Unit toUnit) {
		this.toUnit = toUnit;
		return this;
	}

	public double execute() {
		return compute (fromValue, fromUnit, toUnit);
	}


	private Double compute(double fromValue, Unit fromUnit, Unit toUnit) {

		if ( fromUnit == null ) throw new IllegalArgumentException("Convert From Unit is required");
		if ( toUnit == null) throw new IllegalArgumentException("Convert To Unit is required");

		DecimalFormat df = new DecimalFormat("##.00");

		//Allowed conversions are - 1. From C --> F 2) K --> C 3) F --> K
		if (fromUnit.equals(Unit.C) && toUnit.equals(Unit.F)) {
			return Double.valueOf(df.format(((fromValue * 2) + 32.00 )));
		} else if (fromUnit.equals(Unit.K) && toUnit.equals(Unit.C)) {
			return Double.valueOf(df.format(fromValue - 273.15));
		} else if (fromUnit.equals(Unit.F) && toUnit.equals(Unit.K)) {
			return Double.valueOf(df.format((fromValue + 459.67)/2));
		} else {
			throw new RuntimeException("Supported conversions are : 1. From C --> F 2) K --> C 3) F --> K ");
		}
	}

	public static void main(String[] args) {

        Double resultCtoF = ConversionSolutionOne.convertFrom(80.85, ConversionSolutionOne.Unit.C).convertTo(ConversionSolutionOne.Unit.F).execute();

        System.out.println("Conversion resultCtoF is: " + resultCtoF);

        Double resultKtoC = ConversionSolutionOne.convertFrom(60, ConversionSolutionOne.Unit.K).convertTo(ConversionSolutionOne.Unit.C).execute();

        System.out.println("Conversion resultKtoC is: " + resultKtoC);

        Double resultFtoK = ConversionSolutionOne.convertFrom(92, ConversionSolutionOne.Unit.F).convertTo(ConversionSolutionOne.Unit.K).execute();

        System.out.println("Conversion resultFtoK is: " + resultFtoK);
	}
}