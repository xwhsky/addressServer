package hkc.address.dao;

import hkc.address.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AddressMapperTest extends BaseTest {

	@Autowired
	private AddressDao addressMapper;


	@Test
	public void testHelloWorld() throws Exception {
		List res = addressMapper.query1("邮电路14号");
		System.out.println("hello,world");
	}
}
