package bean;

public class ApiConfig {

    public static final class ResponseStatus {
        //请求成功
        public static final int STATUS_REQUEST_SUCCESSFULL = 200;
        //
        public static final int STATUS_REQUEST_FAILED = 201;

    }

    public static final class ResponseInfo {
        public static final String INFO_REQUEST_SUCCESSFULL = "successfull";
        public static final String STATUS_REQUEST_FAILED = "faile";

    }

    public static final class UserInfo {
        public static final String REGISER_SUCCESSFULL = "rigister successfull";
        public static final String REGISER_FAILED = "rigister failed";


        public static final String LOGIN_SUCCESSFULL = "Login successfull";
        public static final String LOGIN_FAILED = "Login failed";


    }
}