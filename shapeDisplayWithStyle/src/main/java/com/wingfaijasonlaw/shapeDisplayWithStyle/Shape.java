/**
 * Created by Wing Fai Jason Law on 3/18/2016.
 * Citation:
 * http://stackoverflow.com/questions/13777888/factory-pattern-with-inheritance
 * http://stackoverflow.com/questions/16042550/inserting-an-element-at-the-beginning-of-vector
 * http://stackoverflow.com/questions/13029261
 *                              /design-patterns-factory-vs-factory-method-vs-abstract-factory
 * http://www.codeproject.com/Articles/825700/Beginners-Guide-to-Android-Animation-Graphics#canvas
 */

package com.wingfaijasonlaw.shapeDisplayWithStyle;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public abstract class Shape extends View {

    public Shape(Context context) {
        super(context);
    }

    public Shape(Context context, int style){
        super(context);
    }

    void setShapeAlpha(float alpha){
        this.setAlpha(alpha);
    }

    float getShapeAlpha(){
        return this.getAlpha();
    }

    void removeShape(){
        this.setVisibility(GONE);
    }

    public enum ShapeType {
        CIRCLE, RECTANGLE;
    }

    // ShapeType will be given by the child class
    abstract ShapeType getShapeType();

    @Override
    public abstract void onDraw(Canvas canvas);
}
