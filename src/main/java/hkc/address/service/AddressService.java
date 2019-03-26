package hkc.address.service;

import hkc.address.entity.Address;

import java.util.List;

/**
 * 业务接口：站在"使用者"角度设计接口 三个方面：方法定义粒度，参数，返回类型（return 类型/异常）
 */
public interface AddressService {
	List<Address> query1(String name);
	List<Address> query(String name, String city);
	List<Address> getAddressByPolygon(String extent);
	List<Address> getAddressByBuffer(Integer espg,Double distance,Double x,Double y);
	List<Address> getAddressByQuery(Address address);
}
