package com.wingfaijasonlaw.shapeDisplayWithStyle;

/**
 * Created by jason on 4/28/2016.
 */
public class AbstractShapeFactory {

    // method that return shape factory with style
    public ShapeFactory getShapeFactory(int style){
        if(style >-1 || style <4){
            return new ShapeFactory(style);
        }
        return null;
    }
}
