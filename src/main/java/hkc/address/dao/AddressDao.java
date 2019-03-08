package hkc.address.dao;


import hkc.address.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressDao {
    List<Address> query1(@Param("name") String name);
    List<Address> query(@Param("name") String name, @Param("city") String city);

}