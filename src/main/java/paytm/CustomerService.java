package paytm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerService {

	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerService(final CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/customers")
	public ResponseEntity<List<Customer>> findAll() {
		return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/customers/{id}")
	public ResponseEntity<Customer> findOne(@PathVariable("id") int id) {
		if (customerRepository.exists(id)) {
			return new ResponseEntity<>(customerRepository.findOne(id),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = "/api/customers")
	public ResponseEntity<Customer> create(@RequestBody final Customer customer) {
		return new ResponseEntity<>(customerRepository.save(customer),
				HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/api/customers/{id}")
	public ResponseEntity<Customer> update(@PathVariable("id") int id,
			@RequestBody final Customer customer) {
		if (customerRepository.exists(id)) {
			customer.setId(id);
			return new ResponseEntity<>(customerRepository.save(customer),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/api/customers/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		if (customerRepository.exists(id)) {
			customerRepository.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}
