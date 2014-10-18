package is.ru.stringcalculator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        	
        	String rules = text.substring(0, text.indexOf('\n'));
        	text = text.substring(text.indexOf('\n')+1);
        	if(!rules.substring(2, 3).equals("["))
        	{
        		String delimiter = rules.substring(2, 3);
        		text = text.replaceAll(Pattern.quote(delimiter), ",");
        	}
        	else
        	{
        		Pattern p = Pattern.compile("\\[([^]]*)\\]"); // Finnum allt i sviga
            	Matcher m = p.matcher(rules);
            	while (m.find())
            	{
            	  text = text.replaceAll(Pattern.quote(m.group(1)), ","); // Breytum ollu i kommu
            	}
        	}
        	return text;
        }	

        private static String negatives(String[] numbers){
        	String negas = "Negatives not allowed: ";
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
		    if (toInt(number) <= 1000)
    		    {
        		total += toInt(number);
        	    }
		}
		return total;
    }



}
