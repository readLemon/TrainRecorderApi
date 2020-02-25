package bean;

public class ApiConfig {

    public static final class ResponseStatus {
        //请求成功
        public static final int REQUEST_SUCCESSFULL = 200;
        //请求失败
        public static final int REQUEST_FAILED = 201;
        //用户不存在
        public static final int INVALIB_USER = 114;

        //加入缺席次数失败
        public static final int ADD_ABSENT_FAILED = 911;
        //加入请假次数失败
        public static final int ADD_LEAVE_FAILED = 110;
        //获取个人缺席数据失败
        public static final int GET_ABSENTS_FAILED = 120;
        //获取个人请假数据失败
        public static final int GET_LEAVES_FAILED = 119;

    }

    public static final class ResponseInfo {
        public static final String REQUEST_SUCCESSFULL = "successfull";
        public static final String REQUEST_FAILED = "faile";

    }

    public static final class UserInfo {
        public static final String INVALIB_USER = "This user does not exist!";

        public static final String REGISER_SUCCESSFULL = "rigister successfull";
        public static final String REGISER_FAILED = "rigister failed";

        public static final String LOGIN_SUCCESSFULL = "Login successfull";
        public static final String LOGIN_FAILED = "Login failed";
    }
    public static final class TrainInfo{

        public static final String ADD_ABSENT_SUCCESS = "add absent successful";
        public static final String ADD_ABSENT_FAILED = "add absent failed";

        public static final String ADD_LEAVE_SUCCESS = "add leave successful";
        public static final String ADD_LEAVE_FAILED = "add leave failed";

        public static final String GET_ABSENTS_SUCCESSFUL = "get absents successful";
        public static final String GET_ABSENTS_FAILED = "get absents failed";

        public static final String GET_LEAVES_SUCCESSFULL = "get leaves successful";
        public static final String GET_LEAVES_FAILED = "get leaves failed";

    }

}