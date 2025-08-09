package driver;

import com.verizon.pojo.Customer;
import com.verizon.pojo.Tones;
import com.verizon.service.Invoice;
import com.verizon.service.Subscription;

public class RunTest {

	public static void main(String[] args) {
		//**************************************//
		Customer c = new Customer();
		c.setCustomerId(1);
		c.setCustomerName("Avinash");
		c.setMobile("7981468974");
		c.setBalance(10000);
		//*************************************//
		Tones t = new Tones();
		t.setToneId(1);
		t.setTitle("saregama");
		t.setArtist("Arjit singh");
		t.setPrice(15);
		//************************************//
		Subscription s = new Subscription();
	
		s.subscribe(c,t);
	}

}
