package net.canway.demos.demo.utils;


import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class MyResult<T> {
    private T data;
    private  Integer code;
    private String  status;

    public MyResult(){
    }

    public MyResult(T data, Integer code, String status){
        this.code = code;
        this.data = data;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                ", code=" + code +
                ", status='" + status + '\'' +
                '}';
    }
}
