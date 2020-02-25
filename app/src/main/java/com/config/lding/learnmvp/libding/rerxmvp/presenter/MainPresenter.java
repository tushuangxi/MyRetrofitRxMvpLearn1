package com.config.lding.learnmvp.libding.rerxmvp.presenter;

import com.config.lding.learnmvp.libding.entity.GetListRsp;
import com.config.lding.learnmvp.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.config.lding.learnmvp.libding.rerxmvp.model.MainModel;
import java.util.Map;
import rx.Subscriber;

public class MainPresenter implements interfaceUtilsAll.BasePresenter {
    private interfaceUtilsAll.Baseview mMainView;
    private MainModel mMainModel;
    public MainPresenter(){
        mMainModel=new MainModel();
    }

    @Override
    public void attachView(interfaceUtilsAll.Baseview view) {
        mMainView=view;
    }

    @Override
    public void detachView() {
        mMainView=null;
    }



    @Override
    public void searchUser(Map params) {
        if (mMainModel!=null){
            mMainModel.getGetListRsp(new Subscriber<GetListRsp>() {
                @Override
                public void onStart() {
                    //先显示对话框
                    mMainView.showProgressDialog();
                }
                @Override
                public void onCompleted() {
                    //请求结束，对话框消失
                    mMainView.hideProgressDialog();
                }

                @Override
                public void onError(Throwable e) {
                    mMainView.showErrorMessage("搜索失败");
                    mMainView.hideProgressDialog();
                }

                @Override
                public void onNext(GetListRsp getListRsp) {
                    mMainView.showText(getListRsp);
                }
            },params);
        }

    }
}
