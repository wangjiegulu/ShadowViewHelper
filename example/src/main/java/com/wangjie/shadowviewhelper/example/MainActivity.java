package com.wangjie.shadowviewhelper.example;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.wangjie.androidbucket.utils.ABTextUtil;
import com.wangjie.androidinject.annotation.annotations.base.AILayout;
import com.wangjie.androidinject.annotation.annotations.base.AIView;
import com.wangjie.androidinject.annotation.present.AIActionBarActivity;
import com.wangjie.shadowviewhelper.ShadowProperty;
import com.wangjie.shadowviewhelper.ShadowViewHelper;

@AILayout(R.layout.activity_main)
public class MainActivity extends AIActionBarActivity {
    @AIView(R.id.activity_main_shadow_view_a)
    private View shadowViewA;

    @AIView(R.id.activity_main_shadow_view_b)
    private View shadowViewB;

    @AIView(R.id.activity_main_shadow_view_c)
    private View shadowViewC;
    @AIView(R.id.activity_main_shadow_view_c_iv)
    private View shadowImageC;

    @AIView(R.id.activity_main_shadow_view_d)
    private View shadowImageD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // View A
        ShadowProperty shadowProperty = new ShadowProperty()
                .setShadowColor(0x77000000)
                .setShadowRadius(ABTextUtil.dip2px(context, 4));

        ShadowViewHelper.bindShadowHelper(shadowProperty, shadowViewA);
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) shadowViewA.getLayoutParams();
        lp.leftMargin = -shadowProperty.getShadowOffset();
        lp.rightMargin = -shadowProperty.getShadowOffset();
        shadowViewA.setLayoutParams(lp);


        // View B
        ShadowViewHelper.bindShadowHelper(
                new ShadowProperty()
                        .setShadowColor(0x77000000)
                        .setShadowDy(ABTextUtil.dip2px(context, 0.5f))
                        .setShadowRadius(ABTextUtil.dip2px(context, 3))
                , shadowViewB);

        // View C
        ShadowViewHelper.bindShadowHelper(
                new ShadowProperty()
                        .setShadowColor(0x77000000)
                        .setShadowRadius(ABTextUtil.dip2px(context, 6))
                , shadowViewC);

        ShadowViewHelper.bindShadowHelper(
                new ShadowProperty()
                        .setShadowColor(0x77000000)
                        .setShadowRadius(ABTextUtil.dip2px(context, 4))
                , shadowImageC);

        // View D
        int r = ABTextUtil.dip2px(context, 4);
        ShadowViewHelper.bindShadowHelper(
                new ShadowProperty()
                        .setShadowColor(0x77000000)
                        .setShadowRadius(ABTextUtil.dip2px(context, 5))
                , shadowImageD, r, r);


    }


}
