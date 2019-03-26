package hkc.address.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hkc.address.dto.GlobalVariables;
import hkc.address.service.AddressService;
import hkc.address.dto.ExcelReader;
import hkc.address.dto.HttpCaller;
import hkc.address.entity.Address;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;


/**
 * @author xwh19
Http请求统一定义：
Get请求以@RequestParam(value = "name") String name
Post请求以@RequestBody方式
 */
@Controller
@RequestMapping("/addressService")
public class AddressController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    Backbone.emulateJSON = true;

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private AddressService addressService;



    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test() throws Exception {
        return "123";
    }


    @RequestMapping(value = "/query1")
    public @ResponseBody
    List<Address> query1(@RequestParam(value = "name") String name){
        return addressService.query1(name);
    }

    @RequestMapping(value = "/getAddressByPolygon")
    public @ResponseBody
    List<Address> spatial_query(@RequestParam(value = "extent") String extent)throws JSONException{

        return addressService.getAddressByPolygon(extent);
    }

    @RequestMapping(value = "/getAddressByBuffer")
    public @ResponseBody
    List<Address> getAddressByBuffer(@RequestParam(value = "espg") Integer espg,@RequestParam(value = "distance") Double distance,@RequestParam(value = "x") Double x,@RequestParam(value = "y") Double y){
        return addressService.getAddressByBuffer(espg,distance,x,y);
    }

    @RequestMapping(value = "/getAddressByQuery", method = RequestMethod.GET)
    @ResponseBody
    Map query1(@RequestParam("address") String address, @RequestParam("pageSize") Integer pageSize, @RequestParam("currentpage") Integer currentpage) throws IOException {
        Address address1 = mapper.readValue(address, Address.class);
        PageHelper.startPage(currentpage, pageSize);
        List<Address> addressList = addressService.getAddressByQuery(address1);
        PageInfo<Address> pageInfo = new PageInfo<>(addressList);

        Map<String, Object> result = new HashMap<>();
        result.put("success", true);

        Map<String, Object> data = new HashMap<>();
        data.put("pageSize", pageSize);
        data.put("currentpage", pageInfo.getPageNum());
        data.put("totalSize", pageInfo.getTotal());
        data.put("data", pageInfo.getList());

        result.put("data", data);
        return result;
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public @ResponseBody
    List<Address> query( String name,String city){
//    List<Address> query1(@RequestParam(value="list") List<String> list){
        System.out.println("name:" + name + "city" + city);
        return addressService.query(name,city);
    }

//    //空间查询（地址、建筑、单位、人口）
//    @RequestMapping(value = "/getNearestAddressByLocation", method = RequestMethod.GET)
//    @ResponseBody
//    Map getNearestAddressByLocation(@RequestParam("x") Double x, @RequestParam("y") Double y, @RequestParam("z") Double z, @RequestParam("espg") Integer espg,
//                                    @RequestParam("distance") Double distance, @RequestParam("addtype") String addtype, @RequestParam("pageSize") Integer pageSize, @RequestParam("currentpage") Integer currentpage) throws IOException {
//        PageHelper.startPage(currentpage, pageSize);
//
//        List addressList = addressService.getNearestAddressByLocation(x, y, z, espg, distance, addtype);
//        PageInfo pageInfo = new PageInfo(addressList);
//
//        Map<String, Object> result = new HashMap<>();
//        result.put("success", true);
//
//        Map<String, Object> data = new HashMap<>();
//        data.put("pageSize", pageSize);
//        data.put("currentpage", pageInfo.getPageNum());
//        data.put("totalSize", pageInfo.getTotal());
//        data.put("data", pageInfo.getList());
//
//        result.put("data", data);
//        return result;
//    }


//    Map getAreaContent(AddressAl addressAl){
//        switch (addressAl.getAddtype()){
//            case "1":
//                //区域乏味
//                break;
//            case "2":
//                //建筑物
//                Address ad = new Address();
//                ad.setAddress(addressAl.getGuid());
//                Building2d building2d =  addressService.getBuilding2d(ad).get(0);
//
//                break;
//
//        }
//        return  null;
//    }


    //地名搜索引擎使用（地址处理）
    @RequestMapping(value = "/transformAddresses", method = RequestMethod.GET)
    @ResponseBody
    public List transformAddresses(@RequestParam(value = "filename") String filename, @RequestParam(value = "columnname") String columnname) throws Exception {
        String file = GlobalVariables.UPLOAD_FILE_PATH + "/" + filename;
        List<String> addresses = ExcelReader.GetExcelRowsByColumn(file, columnname);

        List<HashMap<String, String>> hashMapList = new ArrayList<>();

        for (String address : addresses) {
            HttpCaller httpCaller = new HttpCaller();
            String httpAddress = GlobalVariables.getProperty(GlobalVariables.AddressSearchUrl) + address;
            StringBuffer stringBuffer = httpCaller.sendGet(httpAddress);
            JSONArray jsonArray = new JSONArray(stringBuffer);
            JSONObject jsonObject = jsonArray.getJSONObject(0);

            //guid?哪里的
            String guid = jsonObject.getString("guid");

            String name = jsonObject.getString("name");
            String type = jsonObject.getString("type");
            String percent = jsonObject.getString("percent");

            HashMap<String, String> data = new HashMap<>();
            data.put("srcAdd", address);
            data.put("trgAdd", name);
            data.put("type", type);
            data.put("percent", percent);

            hashMapList.add(data);
        }
        return hashMapList;
    }

    JSONObject formatObject(Object object, boolean flag) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.append("success", flag);
        if (object != null) {
            jsonObject.append("data", object);
        } else {
            jsonObject.append("data", "");
        }
        return jsonObject;
    }



}
