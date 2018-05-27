package com.example.emartin.flashcards.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Custom View for a FlashCard
 * Contains a red line at the top the dynamically adds lines of text underscored by a blue line
 */
public class FlashCard extends View {

    //measure onMeasure():
    //layout onLayout(): don't override unless there are children
    //draw onDraw(): required for the custom view to appear, render view on the screen

    private Paint backgroundPaint;

    //create view from code, using 'new'
    public FlashCard(Context context) {
        //super(context);
        this(context, null);
    }

    //create view from xml
    public FlashCard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        backgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //...

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        final int canvasWidth = canvas.getWidth();
        final int canvasHeight = canvas.getHeight();

        //...

    }

}
