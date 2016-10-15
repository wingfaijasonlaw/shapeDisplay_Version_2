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

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    private TextView score;
    private RelativeLayout showShape;
    private ShapeFactory shapeDisplay;
    private AbstractShapeFactory abstractShape;
    private Vector<Shape> storeShape;
    private Shape myShape;
    private int rectCount = 0, cirCount = 0, styling = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.hide();
        }

        storeShape = new Vector<>();
        abstractShape = new AbstractShapeFactory();
        shapeDisplay = new ShapeFactory();
        final Random randCoord = new Random();

        score = (TextView) findViewById(R.id.countInfo);
        showShape = (RelativeLayout) findViewById(R.id.ShapeLayout);

        Button cirButton = (Button) findViewById(R.id.cir);
        Button rectButton = (Button) findViewById(R.id.rect);
        Button clearButton = (Button) findViewById(R.id.clear);
        Button styleButton = (Button) findViewById(R.id.style);

        styleButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                styling++;
                if(styling > 3){
                    styling = 0;
                }
                updateShapeCount();
            }
        });

        cirButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                adjustShapeAlpha(); // Traverse vector to fade the color.
                shapeDisplay = abstractShape.getShapeFactory(styling);
                myShape = shapeDisplay.getCircle(getApplicationContext());
                //myShape = shapeDisplay.getShape(getApplicationContext(), "CIRCLE"); // New circle.
                myShape.setY((float) randCoord.nextInt(1000));
                myShape.setX((float) randCoord.nextInt(700));
                storeShape.addElement(myShape); // Add new circle to the end of vector.
                showShape.addView(storeShape.lastElement()); // Display circle.
                updateShapeCount(); // Update the count info of all shapes that are visible.
            }
        });

        rectButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                adjustShapeAlpha(); // Traverse vector to fade the color.
                shapeDisplay = abstractShape.getShapeFactory(styling);
                myShape = shapeDisplay.getRectangle(getApplicationContext());
                //myShape = shapeDisplay.getShape(getApplicationContext(), "RECTANGLE"); // New rect.
                myShape.setY((float) randCoord.nextInt(1000));
                myShape.setX((float) randCoord.nextInt(700));
                storeShape.addElement(myShape); // Add new rectangle to the end of vector.
                showShape.addView(storeShape.lastElement()); // Display rectangle.
                updateShapeCount(); // Update the count info of all shapes that are visible.
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Traverse vector element
                for(Shape delShape: storeShape){
                    delShape.removeShape(); // Remove the corresponding shape's visibility.
                }
                storeShape.clear(); // Remove all element in vector.
                showShape.invalidate(); // Refresh relative layout.
                styling = 0;
                updateShapeCount(); // Update the count info of all shapes to 0.
            }
        });
    }

    void adjustShapeAlpha(){
        Collections.reverse(storeShape); // Set vector in reverse order.
        for(Shape load: storeShape){
            // If the element's alpha is less than or equal to 0.1.
            if(load.getShapeAlpha() <= 0.1){
                load.removeShape(); // Remove element's visibility.
                storeShape.remove(load); // Remove the corresponding element.
                storeShape.trimToSize(); // Reduce the size.
            }
            load.setShapeAlpha(load.getShapeAlpha() - 0.1f); // Reduce alpha by 0.1
        }
        Collections.reverse(storeShape); // Set vector back to original order.
    }

    void updateShapeCount(){
        // Traverse vector element
        for(Shape type: storeShape){
            // Check element shape type
            if(Shape.ShapeType.RECTANGLE.equals(type.getShapeType())){ // If RECTANGLE
                rectCount++; // Increment rectCount by 1.
            }else if(Shape.ShapeType.CIRCLE.equals(type.getShapeType())){ // If CIRCLE
                cirCount++; // Increment cirCount by 1.
            }
        }
        // Update text
        score.setText("Rectangle: " + rectCount + "\t\t\t\t\t"+ "Circle: " + cirCount
                + "\t\t\t\t\t" + "Style: " + styling);
        score.invalidate();// Refresh shapes count info
        cirCount = 0; // Reset circle count info to 0.
        rectCount = 0; // Reset rectangle count info to 0.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
