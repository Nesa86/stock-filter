import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class MakeMeRich {
	public static final List<String> symbols = Arrays.asList("AMD", "HPQ", "IBM", "TXN", "VMW", "XRX", "AAPL", "ADBE",
			"AMZN", "CRAY", "CSCO", "SNE", "GOOG", "INTC", "INTU", "MSFT", "ORCL", "TIBX", "VRSN", "YHOO");

	public static void main(String[] args) throws IOException {
//
//		// 1. Print these symbols using a Java 8 for-each and lambdas
//		symbols.stream().forEach(System.out::println);
//		// 2. Use the StockUtil class to print the price of Bitcoin
//		System.out.println(StockUtil.prices.get("BTC-USD"));
//		// 3. Create a new List of StockInfo that includes the stock price
//		List<Double> stockInfo = StockUtil.prices.values().stream().collect(Collectors.toList());
//		// 4. Find the highest-priced stock under $500
//		List<Double> highPricedStock = stockInfo.stream().filter(price -> price < 500).sorted()
//				.collect(Collectors.toList());
//		Collections.reverse(highPricedStock);
//		System.out.println(highPricedStock);
//		System.out.println(highPricedStock.get(0));
//

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter movie name bellow, to retrieve its plot.\nType 'exit' to quit.");
		String movie = scanner.nextLine().replaceAll(" ", "+");

		while (!movie.isEmpty() || movie.equalsIgnoreCase("exit")) {
			
			try {
				URL request = new URL("http://www.omdbapi.com/?t=" + movie + "&apikey=a52b509b");
				String response = IOUtils.toString(request.openStream(), "UTF-8");
				JSONObject json = new JSONObject(response);
				System.out.println(json.get("Plot"));
				movie = scanner.nextLine().replaceAll(" ", "+");
				System.out.println();
			} catch (JSONException e) {
			
				System.out.println("Movie not found");
				break;
			}

		}
	}

}
