package hkc.address.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//全局变量
public class GlobalVariables {
    private static final Logger logger = LoggerFactory.getLogger(GlobalVariables.class);
    private static GlobalVariables instance;

    private static Properties props;

    static{
        loadProps();
    }

    //数据库分词的标识
    public static final String DatabaseSplitChar = ",";

    //地名地址搜索服务地址
    public static final String AddressSearchUrl = "addressSearch.Url";

    public static final String Access_Control_Allow_Origin = "server.access-control-allow-origin";

    //文件上传文件夹
    public  static final String UPLOAD_FILE_PATH = "/files";

    //统一入库的投影信息
    public static final Integer SystemESPG=4549;


    synchronized static private void loadProps(){
//        logger.info("开始加载userConfig.properties文件内容.......");
        props = new Properties();
        InputStream in = null;
        try {
//　　　　　　　<!--第一种，通过类加载器进行获取properties文件流-->
            //    in = GlobalVariables.class.getClassLoader().getResourceAsStream("userConfig.properties");
//　　　　　　  <!--第二种，通过类进行获取properties文件流-->
            in = GlobalVariables.class.getResourceAsStream("/userConfig.properties");
            props.load(in);

//            //加载数据
//            AddressSearchUrl = getProperty("addressSearch.Url");
//            instance.Access_Control_Allow_Origin = props.getProperty("web.Access-Control-Allow-Origin");
//            instance.SystemESPG = Integer.parseInt(props.getProperty("db.SystemESPG"));
//            instance.UPLOAD_FILE_PATH = props.getProperty("web.UPLOAD-FILE-PATH");
        } catch (FileNotFoundException e) {
//            logger.error("userConfig.properties文件未找到");
        } catch (IOException e) {
//            logger.error("userConfig.properties文件加载出现IOException");
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
//                logger.error("userConfig.properties文件流关闭出现异常");
            }
        }
//        logger.info("加载properties文件内容完成...........");
//        logger.info("properties文件内容：" + props);
    }

    public static String getProperty(String key) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }


}


