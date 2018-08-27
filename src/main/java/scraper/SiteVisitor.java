package scraper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class SiteVisitor {

	/**
	 * Liefert Html Text zu einer bestimmten url
	 * 
	 * @param url
	 *            Ist die bestimmte Url
	 * @return HTML Text
	 * @throws MalformedURLException
	 */
	public String visit(String url) {
		String htmlText = null;
		URL oracle;
		try {
			oracle = new URL(url);
			try (BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()))) {
				htmlText = "";
				String inputLine;
				while ((inputLine = in.readLine()) != null)
					htmlText += inputLine;
				in.close();
			} catch (IOException ioExep) {
				ioExep.printStackTrace();
			}
		} catch (MalformedURLException malformExep) {
			malformExep.printStackTrace();
		}
		return htmlText;
	}

	public static void main(String[] args) {
		SiteVisitor test = new SiteVisitor();

		String ret = test.visit("http://www.google.de");
		System.out.println(ret);
	}

}
