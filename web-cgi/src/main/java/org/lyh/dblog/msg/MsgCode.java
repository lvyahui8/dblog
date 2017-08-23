package org.lyh.dblog.msg;

import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author lvyahui (lvyahui8@gmail.com,lvyahui8@126.com)
 * @since 2017/8/23 21:49
 */
public class MsgCode {
    public static final String C_SUCCESS        =   "0";
    public static final String C_PERM           =   "4003";
    public static final String C_404            =   "4004";
    public static final String C_PARAM          =   "4005";
    public static final String C_UNKOWN_ERROR   =   "5000";
    public static final String C_TIMEOUT        =   "5004";


    private static final String MSG_FILE = "msg.properties";
    private static Properties msgDict  = new Properties();

    static {
        loadProperties(MSG_FILE);

    }


    private static void loadProperties(String fileName) {
        try {
            InputStreamReader input = new InputStreamReader(MsgCode.class.getClassLoader().getResourceAsStream(fileName),
                    "UTF-8");
            try {
                msgDict.load(input);
            } finally {
                input.close();
            }
        } catch (Throwable e) {
            //   sout
        }
    }

    public static String getMsg(String code) {
        return msgDict.getProperty(code);
    }

}
