import java.net.URL;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CurrencyConversion {

	public static void main(String args[]) {

		try {
			FileWriter fileWriter = null;

			String content = "1 USD is equal to Rs " + findExchangeRateAndConvert("USD", "INR", 1);
			File newTextFile = new File("/Users/akshay_bijawe/Desktop/file.txt");
			fileWriter = new FileWriter(newTextFile);
			fileWriter.write(content);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static Double findExchangeRateAndConvert(String from, String to, int amount) {
		try {
			// Yahoo Finance API
			URL url = new URL("http://finance.yahoo.com/d/quotes.csv?f=l1&s=" + from + to + "=X");
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = reader.readLine();
			if (line.length() > 0) {
				return Double.parseDouble(line) * amount;
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}