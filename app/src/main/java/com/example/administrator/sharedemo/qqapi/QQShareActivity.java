package com.example.administrator.sharedemo.qqapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.sharedemo.Constants;
import com.example.administrator.sharedemo.R;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.utils.ThreadManager;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import java.util.ArrayList;

public class QQShareActivity extends AppCompatActivity {
    private Tencent mTencent;
    private Bundle mParam;
    private IUiListener mIUiListener = new IuiListener();
    private QzoneListener mQzoneListener = new QzoneListener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqshare);
        mTencent = Tencent.createInstance(Constants.QQAPPID,getApplicationContext());
        shareToQQ();
    }

    class IuiListener implements IUiListener{

        @Override
        public void onComplete(Object o) {

        }

        @Override
        public void onError(UiError uiError) {

        }

        @Override
        public void onCancel() {

        }
    }

    class QzoneListener implements IUiListener{

        @Override
        public void onComplete(Object o) {

        }

        @Override
        public void onError(UiError uiError) {

        }

        @Override
        public void onCancel() {

        }
    }

    private void shareToQQ(){
        mParam = new Bundle();
        mParam.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE,QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
        mParam.putString(QQShare.SHARE_TO_QQ_TITLE,"我会留下去");
        mParam.putString(QQShare.SHARE_TO_QQ_SUMMARY,"这是分享的摘要");
        mParam.putString(QQShare.SHARE_TO_QQ_AUDIO_URL,"http://www.qq.com/news/1.html");
        mParam.putString(QQShare.SHARE_TO_QQ_IMAGE_URL,"http://imgcache.qq.com/qzone/space_item/pre/0/66768.gif");// 网络图片地址　
        mParam.putString(QQShare.SHARE_TO_QQ_APP_NAME, "应用名称");// 应用名称
        mParam.putString(QQShare.SHARE_TO_QQ_EXT_INT, "其它附加功能");

        ThreadManager.getMainHandler().post(new Runnable() {
            @Override
            public void run() {
                mTencent.shareToQQ(QQShareActivity.this,mParam,mIUiListener);
            }
        });
    }

    private void shareToQzone() {
        mParam = new Bundle();
        mParam.putInt(QzoneShare.SHARE_TO_QZONE_KEY_TYPE, QzoneShare.SHARE_TO_QZONE_TYPE_IMAGE_TEXT);
        mParam.putString(QzoneShare.SHARE_TO_QQ_TITLE, "标题");// 标题
        mParam.putString(QzoneShare.SHARE_TO_QQ_SUMMARY, "要分享的摘要");// 摘要
        mParam.putString(QzoneShare.SHARE_TO_QQ_TARGET_URL, "http://www.qq.com/news/1.html");// 内容地址
        ArrayList<String> imgUrlList = new ArrayList<>();
        imgUrlList.add("http://f.hiphotos.baidu.com/image/h%3D200/sign=6f05c5f929738bd4db21b531918a876c/6a600c338744ebf8affdde1bdef9d72a6059a702.jpg");
        mParam.putStringArrayList(QzoneShare.SHARE_TO_QQ_IMAGE_URL, imgUrlList);// 图片地址
        // 分享操作要在主线程中完成
        ThreadManager.getMainHandler().post(new Runnable() {
            @Override
            public void run() {
                 mTencent.shareToQzone(QQShareActivity.this,mParam,mQzoneListener);
            }
        });
    }

}
