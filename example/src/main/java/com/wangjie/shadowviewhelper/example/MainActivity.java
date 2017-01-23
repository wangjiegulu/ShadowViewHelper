package com.wangjie.shadowviewhelper.example;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.TextView;

import com.wangjie.shadowviewhelper.ShadowProperty;
import com.wangjie.shadowviewhelper.ShadowViewDrawable;

public class MainActivity extends Activity implements View.OnClickListener {
    private View shadowViewA;
    private View shadowViewB;
    private View shadowViewC;
    private View shadowImageC;
    private TextView shadowTvC;

    private View shadowViewD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shadowViewA = findViewById(R.id.activity_main_shadow_view_a);
        shadowViewB = findViewById(R.id.activity_main_shadow_view_b);
        shadowViewC = findViewById(R.id.activity_main_shadow_view_c);
        shadowViewC.setOnClickListener(this);

        shadowImageC = findViewById(R.id.activity_main_shadow_view_c_iv);
        shadowViewD = findViewById(R.id.activity_main_shadow_view_d);

        shadowTvC = (TextView) findViewById(R.id.activity_main_shadow_view_c_tv);

        // all sides shadow
        ShadowProperty sp = new ShadowProperty()
                .setShadowColor(0x77000000)
                .setShadowDy(dip2px(this, 0.5f))
                .setShadowRadius(dip2px(this, 3))
                .setShadowSide(ShadowProperty.ALL);
        ShadowViewDrawable sd = new ShadowViewDrawable(sp, Color.WHITE, 0, 0);
        ViewCompat.setBackground(shadowViewA, sd);
        ViewCompat.setLayerType(shadowViewA, ViewCompat.LAYER_TYPE_SOFTWARE, null);

        // only left and top sides shadow
        sp = new ShadowProperty()
                .setShadowColor(0x77FF0000)
                .setShadowDy(dip2px(this, 0.5f))
                .setShadowRadius(dip2px(this, 3))
                .setShadowSide(ShadowProperty.LEFT | ShadowProperty.BOTTOM);
        sd = new ShadowViewDrawable(sp, Color.TRANSPARENT, 0, 0);
        ViewCompat.setBackground(shadowViewB, sd);
        ViewCompat.setLayerType(shadowViewB, ViewCompat.LAYER_TYPE_SOFTWARE, null);

        // only top and bottom sides shadow
        sp = new ShadowProperty()
                .setShadowColor(0x77000000)
                .setShadowDy(dip2px(this, 0.5f))
                .setShadowRadius(dip2px(this, 3))
                .setShadowSide(ShadowProperty.TOP | ShadowProperty.BOTTOM);
        sd = new ShadowViewDrawable(sp, Color.WHITE, 0, 0);
        ViewCompat.setBackground(shadowViewC, sd);
        ViewCompat.setLayerType(shadowViewC, ViewCompat.LAYER_TYPE_SOFTWARE, null);

        sp = new ShadowProperty()
                .setShadowColor(0x77000000)
                .setShadowDy(dip2px(this, 0.5f))
                .setShadowRadius(dip2px(this, 3))
                .setShadowSide(ShadowProperty.BOTTOM | ShadowProperty.RIGHT);
        sd = new ShadowViewDrawable(sp, Color.WHITE, 0, 0);
        ViewCompat.setBackground(shadowImageC, sd);
        ViewCompat.setLayerType(shadowImageC, ViewCompat.LAYER_TYPE_SOFTWARE, null);


        // only all sides except top shadow
        sp = new ShadowProperty()
                .setShadowColor(0x770000FF)
                .setShadowDy(dip2px(this, 0.5f))
                .setShadowRadius(dip2px(this, 3))
                .setShadowSide(ShadowProperty.LEFT | ShadowProperty.RIGHT | ShadowProperty.BOTTOM);
        sd = new ShadowViewDrawable(sp, Color.TRANSPARENT, 0, 0);
        ViewCompat.setBackground(shadowViewD, sd);
        ViewCompat.setLayerType(shadowViewD, ViewCompat.LAYER_TYPE_SOFTWARE, null);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_shadow_view_c:
                shadowTvC.append("hello shadow!...");
                break;
            default:
                break;
        }
    }

    public static int dip2px(Context context, float dpValue) {
        try {
            final float scale = context.getResources().getDisplayMetrics().density;
            return (int) (dpValue * scale + 0.5f);
        } catch (Throwable throwable) {
            // igonre
        }
        return 0;
    }

}
