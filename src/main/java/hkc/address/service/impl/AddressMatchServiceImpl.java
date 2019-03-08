package hkc.address.service.impl;

import hkc.address.entity.Address;
import hkc.address.service.AddressMatchService;

import java.util.List;

/**
 * @author xwh19
 */
public class AddressMatchServiceImpl implements AddressMatchService {
    @Override
    public List<Address> forwardMatchingAddressesBylonlat(double lon, double lat, double radius, int maxcount) {
        return null;
    }

    @Override
    public double[] reverseMatchingLocationByAddress(Address address) {
        return new double[0];

    }

    @Override
    public double resultCalculation() {
        return 0;
    }
}
