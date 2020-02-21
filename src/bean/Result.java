package bean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonNull;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class Result {
    private int status = ApiConfig.ResponseStatus.STATUS_REQUEST_SUCCESSFULL;
    private String info = ApiConfig.ResponseInfo.INFO_REQUEST_SUCCESSFULL;
    private Object data;
    public List<Object> list = new ArrayList<>();

    public static Gson gson = new Gson();//GsonBuilder()
//            .excludeFieldsWithModifiers(Modifier.PROTECTED)
//            .serializeNulls()
//            .create();
    public static String toJson(Object o) {
        if (o == null) {
            return gson.toJson(JsonNull.INSTANCE);
        }
        return gson.toJson(o);
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
