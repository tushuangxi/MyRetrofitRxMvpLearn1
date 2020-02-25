package com.config.lding.learnmvp.libding.rerxmvp.interfaceUtils;

import com.config.lding.learnmvp.libding.entity.GetListRsp;
import java.util.Map;
import rx.Subscriber;

public class interfaceUtilsAll {


    //base MVP
    public interface BaseModel {
        void getGetListRsp(Subscriber<GetListRsp> subscriber, Map<String, String> params);

    }

    public interface BasePresenter<T extends Baseview> {
        void attachView(T view);
        void detachView();
        void searchUser(Map params);

    }

    public interface Baseview {
        void showProgressDialog();
        void hideProgressDialog();
        void showText(GetListRsp getListRsp);
        void showErrorMessage(String text);
    }

}
