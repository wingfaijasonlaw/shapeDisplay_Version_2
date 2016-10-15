package com.wingfaijasonlaw.shapeDisplayWithStyle;

import android.graphics.Color;
import android.graphics.Paint;
import java.util.Random;

/**
 * Created by Wing Fai Jason Law on 3/23/2016.
 */
public class InitialShape {
    private float radius, left, top, right, bottom, x, y;
    private Paint paintShape, strokeShape;
    private int myStyle;

    InitialShape(){
        shapeSpec();
    }

    InitialShape(int style){
        this.myStyle = style;
        shapeSpec();

        // Set paint spec.
        // If style number greater than zero is selected
        if(style > 0){
            // initialize fill color and stroke color
            int styleStrokeColor = 0, styleFillColor = 0;
            // matching the corresponding stroke and fill colors for the style
            switch (style){
                case 1:
                    styleStrokeColor = Color.rgb(style * 32, style * 32, style * 32);
                    styleFillColor = Color.rgb(style * 102, style * 178, style * 255);
                    break;
                case 2:
                    styleStrokeColor = Color.rgb(style * 102, style * 51, style * 0);
                    styleFillColor = Color.rgb(style * 0, style * 51, style * 0);
                    break;
                case 3:
                    styleStrokeColor = Color.rgb(style * 51, style * 28, style * 0);
                    styleFillColor = Color.rgb(style * 83, style * 83, style * 34);
                    break;
                default:
                    styleStrokeColor = Color.rgb(style * 21, style * 35, style * 61);
                    styleFillColor = Color.rgb(style * 22, style * 22, style * 22);
                    break;
            }
            // initialize paint for fill and stroke
            paintShape = new Paint(Paint.ANTI_ALIAS_FLAG);
            strokeShape = new Paint(Paint.ANTI_ALIAS_FLAG);
            // set the stroke paint
            strokeShape.setColor(styleStrokeColor);
            strokeShape.setStyle(Paint.Style.STROKE);
            strokeShape.setStrokeWidth(10.0f);
            // set the fill paint
            paintShape.setColor(styleFillColor);
            paintShape.setStyle(Paint.Style.FILL);
        }
    }

    // The default initialization of the shape without style
    private void shapeSpec(){
        Random random = new Random();
        left = (float)random.nextInt(100) + 50 + random.nextFloat(); // Set left randomly from 50 to 150.
        top = (float)random.nextInt(200) + 50 + random.nextFloat(); // Set top randomly from 50 to 250.
        right = (float)random.nextInt(100) + 50 + left; // Set right randomly from 100 to 300.
        bottom = (float)random.nextInt(200) + 50 + top; // Set buttom randomly from 100 to 500.

        radius = (float)random.nextInt(100) + 50 + random.nextFloat(); // Set radius randomly from 50 to 150.
        x = radius;
        y = radius;

        // Set paint spec. and random color.
        int randomColor = Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        paintShape = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintShape.setColor(randomColor);
        paintShape.setStyle(Paint.Style.FILL);
    }

    float getRadius(){
        return this.radius;
    }

    float getLeft(){
        return this.left;
    }

    float getTop(){
        return this.top;
    }

    float getRight(){
        return this.right;
    }

    float getBottom(){
        return this.bottom;
    }

    float getX(){
        return this.x;
    }

    float getY(){
        return this.y;
    }

    Paint getPaintShape(){
        return this.paintShape;
    }

    Paint getStrokeShape(){
        return this.strokeShape;
    }
}
