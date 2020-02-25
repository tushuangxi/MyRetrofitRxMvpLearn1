package com.config.lding.learnmvp.libding.http;

import com.config.lding.learnmvp.libding.entity.GetListRsp;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;


public interface ApiService {

    String APP_HOST = "http://api.zhuishushenqi.com";//正式接口
    String FUNCTION_INDEX = "/cats/lv2/statistics/";
    String FUNCTION_LOGIN =  "/cats/lv2/statistics/";

    /*登录  GetListRsp  */
    @GET(FUNCTION_LOGIN)
    Observable<GetListRsp> getGetListRsp(@QueryMap Map<String, String> params);
}
