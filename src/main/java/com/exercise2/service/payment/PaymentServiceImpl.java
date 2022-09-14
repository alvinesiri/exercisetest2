package com.exercise2.service.payment;

import com.exercise2.model.Affiliate;
import com.exercise2.model.Bill;
import com.exercise2.model.Customer;
import com.exercise2.model.Employee;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Profile("!local")
public class PaymentServiceImpl implements PaymentService {

    List<Customer> customers;
    List<Affiliate> affiliates;
    List<Employee> employees;

    public PaymentServiceImpl(List<Customer> _customers, List<Affiliate> _affiliates, List<Employee> _employees)
    {
        customers = _customers;
        affiliates = _affiliates;
        employees = _employees;
    }

    @Override
    public double GetNetPayableAmount(Bill bill)
    {
        double amount = bill.getAmount();
        double discount = 0;
        customers.removeIf(s -> !s.phoneNumber.contains(bill.phoneNumber));
        Customer customer = customers.stream().findFirst().orElse(null);
        if(customer == null)
        {
            customer = new Customer();
            customer.setPhoneNumber(bill.phoneNumber);
            customer.setDateJoined(new Date());
        }
        boolean isAffiliate = affiliates.stream().anyMatch(x -> x.phoneNumber.contains(bill.phoneNumber));
        boolean isEmployee = employees.stream().anyMatch(x -> x.phoneNumber.contains(bill.phoneNumber));
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, -2);
        Date startDate = c.getTime();;

        if (bill.getIsGroceries())
        {
            if (isEmployee)
            {
                discount += amount * 0.3;
            }
            else if (isAffiliate)
            {
                discount += amount * 0.1;
            }
            else if (customer.dateJoined.compareTo(startDate)>0)
            {
                discount += amount * 0.05;
            };
        }

        double hundredDollarDiscount = Math.floor(amount/100) * 5;
        discount = discount + hundredDollarDiscount;

        double netPayableAmount = amount - discount;

        return Math.round(netPayableAmount);
    }
}
