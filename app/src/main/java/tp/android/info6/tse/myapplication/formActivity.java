package tp.android.info6.tse.myapplication;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class formActivity extends AppCompatActivity  {

    public final static String KEY_USERNAME ="USERNAME";
    private Button buttonSave;
    private EditText editTextName;


    private void init(){
        buttonSave = findViewById(R.id.activity_form_button_save);
        editTextName = findViewById(R.id.activity_form_edittext_name);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        init();

    }


    private void saveData(){
        String name = editTextName.getText().toString();
        if(!name.isEmpty()){
            DataManager.getInstance().addName(name);
        }
        finish();
    }
}
