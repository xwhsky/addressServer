package hkc.address.service.impl;

import hkc.address.service.AddressService;
import hkc.address.dao.AddressDao;
import hkc.address.entity.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xwh19
 */
@Service
public class AddressServiceImpl implements AddressService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AddressDao addressMapper;

    @Override
    public List<Address> query1(String name) {
        return addressMapper.query1(name);
    }

    @Override
    public List<Address> query(String name, String city) {
        return addressMapper.query(name,city);
    }
}
