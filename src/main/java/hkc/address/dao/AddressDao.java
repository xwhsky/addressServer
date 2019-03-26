package hkc.address.dao;


import hkc.address.entity.Address;
import hkc.address.entity.AddressExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressDao {
    List<Address> query1(@Param("name") String name);
    List<Address> query(@Param("name") String name, @Param("city") String city);
    List<Address> getAddressByPolygon(@Param("extent") String extent);
    List<Address> getAddressByBuffer(@Param("wkt") String espg,@Param("distance") Double distance);
    List<Address> selectByExample(AddressExample addressExample);
}