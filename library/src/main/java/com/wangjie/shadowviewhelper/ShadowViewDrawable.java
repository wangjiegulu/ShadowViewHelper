package com.wangjie.shadowviewhelper;

import android.graphics.*;
import android.graphics.drawable.Drawable;

/**
 * <code>
 * if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
 * view.setLayerType(View.LAYER_TYPE_SOFTWARE, drawable.getPaint());
 * }
 * </code>
 * <p/>
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 5/2/15.
 */
public class ShadowViewDrawable extends Drawable {
    private Paint paint;

    private RectF bounds = new RectF();

    private int width;
    private int height;

    private ShadowProperty shadowProperty;
    private int shadowOffset;

    private RectF drawRect;

    private float rx;
    private float ry;

    public ShadowViewDrawable(ShadowProperty shadowProperty, int color, float rx, float ry) {
        this.shadowProperty = shadowProperty;
        shadowOffset = this.shadowProperty.getShadowOffset();

        this.rx = rx;
        this.ry = ry;

        paint = new Paint();
        paint.setAntiAlias(true);
        /**
         * 解决旋转时的锯齿问题
         */
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        /**
         * 设置阴影
         */
        paint.setShadowLayer(shadowProperty.getShadowRadius(), shadowProperty.getShadowDx(), shadowProperty.getShadowDy(), shadowProperty.getShadowColor());

        drawRect = new RectF();
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        if (bounds.right - bounds.left > 0 && bounds.bottom - bounds.top > 0) {
            this.bounds.left = bounds.left;
            this.bounds.right = bounds.right;
            this.bounds.top = bounds.top;
            this.bounds.bottom = bounds.bottom;
            width = (int) (this.bounds.right - this.bounds.left);
            height = (int) (this.bounds.bottom - this.bounds.top);

//            drawRect = new RectF(shadowOffset, shadowOffset, width - shadowOffset, height - shadowOffset);
//            drawRect = new RectF(0, 0, width, height - shadowOffset);

            int shadowSide = shadowProperty.getShadowSide();
            int left = (shadowSide & ShadowProperty.LEFT) == ShadowProperty.LEFT ? shadowOffset : 0;
            int top = (shadowSide & ShadowProperty.TOP) == ShadowProperty.TOP ? shadowOffset : 0;
            int right = width - ((shadowSide & ShadowProperty.RIGHT) == ShadowProperty.RIGHT ? shadowOffset : 0);
            int bottom = height - ((shadowSide & ShadowProperty.BOTTOM) == ShadowProperty.BOTTOM ? shadowOffset : 0);

            drawRect = new RectF(left, top, right, bottom);


            invalidateSelf();

        }
    }

    private PorterDuffXfermode srcOut = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);

    @Override
    public void draw(Canvas canvas) {
        paint.setXfermode(null);

        canvas.drawRoundRect(
                drawRect,
                rx, ry,
                paint
        );

        paint.setXfermode(srcOut);
//        paint.setColor(Color.TRANSPARENT);
        canvas.drawRoundRect(drawRect, rx, ry, paint);
    }

    public ShadowViewDrawable setColor(int color) {
        paint.setColor(color);
        return this;
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter cf) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }
}
