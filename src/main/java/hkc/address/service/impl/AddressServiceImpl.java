package hkc.address.service.impl;

import hkc.address.entity.AddressExample;
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

    @Override
    public List<Address> getAddressByPolygon(String extent) {
        return addressMapper.getAddressByPolygon(extent);
    }

    public List getAddressByBuffer(Integer espg, Double distance,Double x, Double y ) {

        String wkt = String.format("POINT(%f %f)", x, y);
        return addressMapper.getAddressByBuffer(wkt, distance);
    }

    @Override
    public List<Address> getAddressByQuery(Address address) {
        AddressExample addressExample = new AddressExample();
        AddressExample.Criteria criteria = addressExample.createCriteria();
        if (address.getName() != null)
            criteria.andNameLike("%" + address.getName() + "%");
        if (address.getAddress() != null)
            criteria.andAddressLike("%" + address.getAddress() + "%");
        if (address.getAddtype() != null)
            criteria.andAddtypeEqualTo(address.getAddtype());
        if (address.getCounty() != null)
            criteria.andCountyLike("%" + address.getCounty() + "%");
        if(address.getStreet()!=null)
            criteria.andStreetLike("%"+address.getStreet()+"%");
        if (address.getTown() != null)
            criteria.andTownLike("%" + address.getTown() + "%");
        if (address.getCommunit() != null)
            criteria.andCommunitLike("%" + address.getCommunit() + "%");
        return addressMapper.selectByExample(addressExample);
    }
}
