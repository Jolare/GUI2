package de.hsas.inf.gui.a2;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowImage extends AppCompatActivity {

  private TextView pfade;
  private ImageView image; // Von Ihnen weiter einzubinden
  String[] filepaths;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_show_image);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    pfade = findViewById(R.id.showPath);
    String directory = getIntent().getExtras().getString("SELECTED_DIRECTORY");
    image = findViewById(R.id.gallery);
    //pfade.setText(pfadeStrings[0] + "\n" + pfadeStrings[1] + "\n" +  directory);
    try {
        filepaths = FileIO.loadImagePathNames(directory);
        Bitmap bitmap = FileIO.createBitmapFromFile(filepaths[0]);
        System.out.println("Path " +
                filepaths[0]);
        image.setImageBitmap(bitmap);
    } catch (Exception e){
      //pfade.setText("Kein Text vorhanden!");
      image.setImageResource(R.drawable.x);
    }
  }
}
