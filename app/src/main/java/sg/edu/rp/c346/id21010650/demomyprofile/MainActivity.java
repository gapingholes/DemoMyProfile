package sg.edu.rp.c346.id21010650.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textName, textGPA;
    EditText editName, editGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textName = findViewById(R.id.textName);
        textGPA = findViewById(R.id.textGPA);
        editName = findViewById(R.id.editName);
        editGPA = findViewById(R.id.editGPA);

    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String strName = prefs.getString("name", "Royden");
        Float gpa = prefs.getFloat("GPA", 4);
        Toast.makeText(MainActivity.this, strName, Toast.LENGTH_LONG);

        editName.setText(strName);
        editGPA.setText(gpa + "");
    }
    @Override
    protected void onPause() {
        super.onPause();
        String strName = editName.getText().toString();
        float gpa= Float.parseFloat(editGPA.getText().toString());
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name", strName);
        prefEdit.commit();


    }}