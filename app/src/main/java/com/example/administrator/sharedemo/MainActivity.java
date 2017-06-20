package com.example.administrator.sharedemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.sharedemo.sina.WBShareActivity;
import com.example.administrator.sharedemo.wxapi.WXEntryActivity;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ImageView weixin;
    ImageView qq;
    ImageView sina;
    Context  context;
    AlertDialog dialog;
    private IWXAPI wxApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View view = View.inflate(MainActivity.this,R.layout.share_dialog,null);
                weixin = (ImageView) view.findViewById(R.id.weixin);
                qq = (ImageView) view.findViewById(R.id.qq);
                sina = (ImageView) view.findViewById(R.id.sina);
                builder.setView(view);
                dialog=builder.create();
                dialog.setView(view,5,5,5,5);
                dialog.show();
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.guide_save_succ_dlg_enter);
                view.startAnimation(anim);
                WindowManager.LayoutParams layoutParams = dialog.getWindow().getAttributes();
                layoutParams.width = layoutParams.MATCH_PARENT;
                layoutParams.height = layoutParams.WRAP_CONTENT;
                dialog.getWindow().setGravity(Gravity.BOTTOM);
                dialog.getWindow().setAttributes(layoutParams);

                weixin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                       WXEntryActivity wxEntryActivity = new WXEntryActivity(MainActivity.this);
//                        wxEntryActivity.shareWeixin();
                        startActivity(new Intent(MainActivity.this,WXEntryActivity.class));
                        dialog.dismiss();
//                        finish();
                    }
                });


                qq.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this,WXEntryActivity.class));
                    }
                });

                sina.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, WBShareActivity.class));
                    }
                });
            }
        });



    }



}
