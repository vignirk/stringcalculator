package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains("-"))
                {
                	if(text.contains("//")) text = trim(text);
                	String negas = negatives(splitNumbers(text));
                	throw new IllegalArgumentException(negas);
                }
		else if(text.contains("//"))
                {
                	text = trim(text);
                	return sum(splitNumbers(text));
                }
		else if(text.contains(",") || text.contains("\\n")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static String trim(String text)
        {
        	String delimiter = text.substring(2, 3);
        	text = text.substring(5);
        	text = text.replaceAll(delimiter, ",");
        	return text;
        }
        
        private static String negatives(String[] numbers){
        	String negas = "";
        	for(String number : numbers){
        		if(toInt(number) < 0)
        		{
        			negas += number + ",";
        		}
            }
            return negas;
        }

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",|\\n");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }



}
