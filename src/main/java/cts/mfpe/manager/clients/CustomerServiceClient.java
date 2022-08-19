package cts.mfpe.manager.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import cts.mfpe.manager.entities.Customer;

@FeignClient(name="customer-service",url = "http://0customermicroservice-env.eba-cp9cmhes.us-west-1.elasticbeanstalk.com/customer")
public interface CustomerServiceClient {

	@GetMapping("/getCustomerDetails/{id}")
	Customer getCustomerDetails(@PathVariable int id,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)
					throws Exception;
	
	@GetMapping("/getAllCustomers")
	List<Customer> getAllCustomers(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)
			throws Exception;
}
