package com.example.administrator.sharedemo.sina;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.sharedemo.Constants;
import com.example.administrator.sharedemo.R;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.share.WbShareHandler;
import com.sina.weibo.sdk.utils.Utility;

public class WBShareActivity extends Activity  implements WbShareCallback{
    private WbShareHandler mWbShareHandler;
    private SsoHandler mSsoHandler;
    public static final String KEY_SHARE_TYPE = "key_share_type";
    public static final int SHARE_CLIENT = 1;
    public static final int SHARE_ALL_IN_ONE = 2;
    private int mShareType = SHARE_CLIENT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wbshare);
        WbSdk.install(this,new AuthInfo(this,Constants.APP_KEY,Constants.REDIRECT_URL,Constants.SCOPE));
        mSsoHandler = new SsoHandler(this);
        mWbShareHandler = new WbShareHandler(this);
        mWbShareHandler.registerApp();
        shareToWeibo(true);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        mWbShareHandler.doResultIntent(intent,this);
    }

    @Override
    public void onWbShareSuccess() {
        Toast.makeText(this, "分享成功", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onWbShareCancel() {
        Toast.makeText(this,
               "取消分享" + "Error Message: ",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onWbShareFail() {
        Toast.makeText(this, "分享失败" + "Error Message:", Toast.LENGTH_LONG).show();
    }


    private void shareToWeibo(boolean hasWeb){
        WeiboMultiMessage weiboMessage = new WeiboMultiMessage();
        if (hasWeb){
            weiboMessage.mediaObject =getWebpageObj();
            mWbShareHandler.shareMessage(weiboMessage,false);
        }
//        weiboMessage.textObject = getTextObj();
//        weiboMessage.imageObject = getImageObj();
    }




    /**
     * 创建多媒体（网页）消息对象。
     *
     * @return 多媒体（网页）消息对象。
     */
    private WebpageObject getWebpageObj() {
        WebpageObject mediaObject = new WebpageObject();
        mediaObject.identify = Utility.generateGUID();
        mediaObject.title ="测试title";
        mediaObject.description = "测试描述";
        Bitmap  bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.send_img);
        // 设置 Bitmap 类型的图片到视频对象里         设置缩略图。 注意：最终压缩过的缩略图大小不得超过 32kb。
        mediaObject.setThumbImage(bitmap);
        mediaObject.actionUrl = "http://news.sina.com.cn/c/2013-10-22/021928494669.shtml";
        mediaObject.defaultText = "Webpage 默认文案";
        return mediaObject;
    }

}
