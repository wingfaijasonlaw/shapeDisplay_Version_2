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

public class Circle extends Shape {
    private int circleStyle = 0;
    InitialShape myCir;

    public Circle(Context context) {
        super(context);
    }

    public Circle(Context context, int style){
        super(context);
        this.circleStyle = style;
        myCir = new InitialShape(this.circleStyle);
    }

    @Override
    public void onDraw(Canvas canvas) {
        setShapeAlpha(1.0f); // Set shape alpha to 1.0.
        // draw circle with height, width, and radius defined in InitialShape()

        if(circleStyle > 0){ // if style greater than zero is selected
            // circle with stroke color
            canvas.drawCircle(myCir.getX(), myCir.getY(),
                    myCir.getRadius() - 4, myCir.getStrokeShape());
        }

        // circle with fill color
        canvas.drawCircle(myCir.getX(), myCir.getY(),
                myCir.getRadius() - 5, myCir.getPaintShape());
    }

    @Override
    ShapeType getShapeType() {
        return ShapeType.CIRCLE;
    }
}
