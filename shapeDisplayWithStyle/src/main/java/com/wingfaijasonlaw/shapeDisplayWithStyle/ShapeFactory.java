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

public class ShapeFactory {
    private int myStyle;

    // default constructor
    public ShapeFactory(){
        // set style to default
        this.myStyle = 0;
    }

    // constructor
    public ShapeFactory(int style){
        // set the style to whatever is given.
        this.myStyle = style;
    }

    // method to return corresponding shape
    public Shape getShape(Context context, String shape){

        if("CIRCLE".equals(shape)){
            return new Circle(context, this.myStyle);
        }else if("RECTANGLE".equals(shape)){
            return new Rectangle(context, this.myStyle);
        }

        return null;
    }

    // method that return circle shape
    public Shape getCircle(Context context){
        return getShape(context, "CIRCLE");
    }

    // mehtod that return rectangle shape
    public Shape getRectangle(Context context){
        return getShape(context, "RECTANGLE");
    }
}
