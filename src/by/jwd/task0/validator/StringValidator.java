package by.jwd.task0.validator;

public interface StringValidator {
	
	String STRING_AS_INT_ARRAY_REGEX = "^(-?\\d{1,10},\\s)+$";
	
	boolean validateString(String stringAsInt);

}
