package com.exercise2;

import com.exercise2.exception.PaymentException;
import com.exercise2.model.Affiliate;
import com.exercise2.model.Bill;
import com.exercise2.model.Customer;
import com.exercise2.model.Employee;
import com.exercise2.service.payment.PaymentService;
import com.exercise2.service.payment.PaymentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
class Exercise2ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void TestNetPayableAmount()
	{
		List<Employee> testemployees = new ArrayList<>();
		Employee employee1 = new Employee();
		employee1.phoneNumber = "07030000000";
		testemployees.add(employee1);

		List<Affiliate> testaffiliates = new ArrayList<>();
		Affiliate affiliate1 = new Affiliate();
		affiliate1.phoneNumber = "07040000000";
		testaffiliates.add(affiliate1);

		List<Customer> testcustomers = new ArrayList<>();
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, -3);
		Customer customer1 = new Customer();
		customer1.phoneNumber = "07050000000";
		customer1.dateJoined = c.getTime();
		testcustomers.add(customer1);

		Bill bill = new Bill();
		bill.amount = 990;
		bill.isGroceries = false;
		bill.phoneNumber = "07050000000";

		double ExpectedPayableAmount = 945;

		double payableAmount = 0;

		try {
			PaymentService paymentService = new PaymentServiceImpl(testcustomers, testaffiliates, testemployees);
			payableAmount = paymentService.GetNetPayableAmount(bill);
		} catch (PaymentException e) {
			throw new RuntimeException(e);
		}
		Assert.isTrue(payableAmount == ExpectedPayableAmount);
	}
}
