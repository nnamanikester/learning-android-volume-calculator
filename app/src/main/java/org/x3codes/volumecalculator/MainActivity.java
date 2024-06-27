package org.x3codes.volumecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Shape> shapes;
    ShapeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        gridView = findViewById(R.id.gridView);
        shapes = new ArrayList<>();

        shapes.add(new Shape(R.drawable.sphere, "Sphere"));
        shapes.add(new Shape(R.drawable.cylinder, "Cylinder"));
        shapes.add(new Shape(R.drawable.cube, "Cube"));
        shapes.add(new Shape(R.drawable.prism, "Prism"));

        adapter = new ShapeAdapter(shapes, getApplicationContext());
        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Shape shape = adapter.getItem(i);
                assert shape != null;
                String name = shape.getShapeName();

                if (Objects.equals(name, "Sphere")) {
                    Intent intent = new Intent(getApplicationContext(), Sphere.class);
                    startActivity(intent);
                } else if(Objects.equals(name, "Cube")) {
                    Intent intent = new Intent(getApplicationContext(), Cube.class);
                    startActivity(intent);
                } else if(Objects.equals(name, "Prism")) {
                    Intent intent = new Intent(getApplicationContext(), Prism.class);
                    startActivity(intent);
                } else if(Objects.equals(name, "Cylinder")) {
                    Intent intent = new Intent(getApplicationContext(), Cylinder.class);
                    startActivity(intent);
                }


            }
        });

    }
}