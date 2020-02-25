package com.config.lding.learnmvp.libding.rerxmvp.model;

import com.config.lding.learnmvp.libding.entity.GetListRsp;
import com.config.lding.learnmvp.libding.http.manager.RetrofitManager;
import com.config.lding.learnmvp.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;

import java.util.Map;
import rx.Subscriber;

public class MainModel implements interfaceUtilsAll.BaseModel {
    @Override
    public void getGetListRsp(Subscriber<GetListRsp> subscriber, Map<String, String> params) {
        RetrofitManager.getInstance().getGetListRsp(subscriber,params);
    }
}
