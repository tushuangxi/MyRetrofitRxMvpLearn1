package com.config.lding.learnmvp.libding.rerxmvp.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.config.lding.learnmvp.R;
import com.config.lding.learnmvp.libding.entity.GetListRsp;
import com.config.lding.learnmvp.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.config.lding.learnmvp.libding.rerxmvp.presenter.MainPresenter;
import com.config.lding.learnmvp.libding.http.ServiceMapParams;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements interfaceUtilsAll.Baseview{

    @BindView(R.id.tv)
    TextView tv;
    private ProgressDialog dialog;
    private MainPresenter mMainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        mMainPresenter=new MainPresenter();
        mMainPresenter.attachView(this);
    }

    private void initView() {
        dialog=new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("正在搜索中");
    }

    @OnClick(R.id.search_btn)
    public void onClick() {
        mMainPresenter.searchUser(ServiceMapParams.getGetListRspMapParams());
    }

    @Override
    public void showProgressDialog() {
        dialog.show();
    }

    @Override
    public void hideProgressDialog() {
        dialog.dismiss();
    }

    @Override
    public void showText(GetListRsp getListRsp) {

        tv.setText(getListRsp.getFemale().iterator().next().getName());
    }


    @Override
    public void showErrorMessage(String text) {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMainPresenter!=null)
            mMainPresenter.detachView();
    }
}
