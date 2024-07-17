package com.alamin.ecommerce.service.implementations;

import com.alamin.ecommerce.dto.request.RequestAddressDTO;
import com.alamin.ecommerce.dto.request.RequestCustomerDTO;
import com.alamin.ecommerce.dto.response.ResponseCustomerDTO;
import com.alamin.ecommerce.exceptions.clazz.CustomerConflictException;
import com.alamin.ecommerce.exceptions.clazz.CustomerNotFoundException;
import com.alamin.ecommerce.exceptions.validators.RequestDTOValidator;
import com.alamin.ecommerce.mapper.request.RequestAddressMapper;
import com.alamin.ecommerce.mapper.request.RequestCustomerMapper;
import com.alamin.ecommerce.mapper.response.ResponseCustomerMapper;
import com.alamin.ecommerce.model.Customer;
import com.alamin.ecommerce.model.PresentAddress;
import com.alamin.ecommerce.repository.AddressRepository;
import com.alamin.ecommerce.repository.CustomerRepository;
import com.alamin.ecommerce.service.interfaces.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final RequestDTOValidator<RequestCustomerDTO> customerDTORequestDTOValidator;
    private final RequestDTOValidator<RequestAddressDTO> addressDTORequestDTOValidator;
    private final RequestCustomerMapper requestCustomerMapper;
    private final ResponseCustomerMapper responseCustomerMapper;
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    @Override
    public String createCustomer(RequestCustomerDTO dto) {
        if (dto == null){
            return null;
        }
        customerDTORequestDTOValidator.validate(dto);
        addressDTORequestDTOValidator.validate(dto.address());
        var custom = customerRepository.findByEmail(dto.email()).orElse(null);
        if (custom != null){
            throw new CustomerConflictException(String.format("Already customer %s existed.", dto.email()));
        }
//        Customer customer1 = customerRepository.findByEmail(dto.email()).orElse(null);
//        System.out.println(customer1.getEmail());
        Customer customer = requestCustomerMapper.apply(dto);
        PresentAddress address = addressRepository.save(customer.getAddress());
        customer.setAddress(address);
        customerRepository.save(customer);

        return "Customer created";
    }

    @Override
    public Set<ResponseCustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().map(responseCustomerMapper).collect(Collectors.toSet());

    }
}
