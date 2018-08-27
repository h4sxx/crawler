package scraper;

import org.junit.Test;
import static org.junit.Assert.*;
public class SiteVisitorTest {
	
	@Test
	public void testVisit(){
		
		SiteVisitor siteVisitor = new SiteVisitor();
		String siteText = siteVisitor.visit("google.de");
		assertNotNull(siteText);
		
	}

}
