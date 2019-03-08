package hkc.address.web;

import hkc.address.dto.GlobalVariables;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


/**
 * @author Kemin
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class AddressControllerTest extends AbstractContextControllerTests {

    private MockMvc mockMvc;
    private String listUrl = "/addressService/transformAddress/{srcAdd}";
    private String detailUrl = "/book/{bookId}/detail";
    private String appointUrl = "/book/{bookId}/appoint";


    private String pid = "{d7b9920a-0e86-49c5-8ee0-5fe6543b2d99}";

@Test
public  void testAddressSimple(){
    
}
    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(status().isOk()).alwaysDo(print()).build();
    }

    @Test
    public void list() throws Exception {
        String address = "文三路";
        String url = "http://10.10.1.200:888/searchkey/{address}";
        String add =  GlobalVariables.getProperty(GlobalVariables.AddressSearchUrl);


//        try {
//            HttpCaller httpCaller = new HttpCaller();
//            String httpAddress = GlobalVariables.AddressSearchUrl + srcAdd;
//            return httpCaller.sendGet(httpAddress).toString();
//        } catch (Exception e) {
//            return e.getMessage();
//        }


//        ResultActions resultActions1 = this.mockMvc.perform(get(url, address));
//        HttpCaller httpCaller = new HttpCaller();
//        StringBuffer response = httpCaller.sendGet("http://10.10.1.200:888/searchkey/路");
//		response =  httpCaller.sendGet("http://localhost:59007//addressService/transformAddress/路");
//        String responseString = this.mockMvc.perform(get(listUrl, address))
//                .andExpect(status().isOk())    //返回的状态是200
//                .andDo(print())         //打印出请求和相应的内容
//                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
//        System.out.println("-----返回的json = " + responseString);
//        JSONObject resultObj = JSON.parseObject(result);

        MvcResult mvcResult = this.mockMvc.perform(get(listUrl, address))
                .andExpect(status().isOk())    //返回的状态是200
                .andDo(print())         //打印出请求和相应的内容
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println("请求状态码：" + status);
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("接口返回结果：" + result);
//        JSONObject resultObj = JSON.parseObject(result);
//        // 判断接口返回json中success字段是否为true
//        Assert.assertTrue(resultObj.getBooleanValue("success"));


    }


}
