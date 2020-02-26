package bean;

import com.google.gson.Gson;
import com.google.gson.JsonNull;

import java.util.List;

public class Result {
    private int status = ApiConfig.ResponseStatus.REQUEST_SUCCESSFUL;
    private String info = ApiConfig.ResponseInfo.REQUEST_SUCCESSFULL;
    private Object data;
    public List<Object> list;

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

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public String toJson() {
        return gson.toJson(this);
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
