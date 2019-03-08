package hkc.address.service;

import hkc.address.entity.Address;

import java.util.List;


/*地名地址匹配引擎*/
public interface AddressMatchService {

    //正向匹配：根据经纬度坐标返回最近的几个地名地址
    public  List<Address> forwardMatchingAddressesBylonlat(double lon,double lat,double radius,int maxcount);

    //反向匹配:获取地名地址的坐标点位置，以经度、纬度的方式进行返回
    public double[] reverseMatchingLocationByAddress(Address address);

    public double resultCalculation();


}
