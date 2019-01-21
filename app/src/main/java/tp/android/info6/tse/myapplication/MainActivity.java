package tp.android.info6.tse.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static tp.android.info6.tse.myapplication.ListNameAdapter.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,NameItemListener{

    public final static String KEY_USERNAME ="USERNAME";
    private Button buttonNext;
    private RecyclerView recyclerView;

    ListNameAdapter listNameAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listNameAdapter=new ListNameAdapter(this);

        initViews();
        initList();

    }
    
    protected void onResume(){
        super.onResume();
        List nameList = DataManager.getInstance().getNameList();
        listNameAdapter.updateData(nameList);
    }
    
    private void initViews(){
        buttonNext = findViewById(R.id.activity_main_button_next);
        buttonNext.setOnClickListener(this);
    }
    
    private void initList(){
        final LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);
        recyclerView.setAdapter(listNameAdapter);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(listNameAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activity_main_button_next:
                displayFormActivity();
                break;
        }
    }

    @Override
    public void clickOnItem(String name) {
        Toast.makeText(this,name, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void clickOnCross(String name) {
        Toast.makeText(this,"Clic sur la croix de l'item:"+name,Toast.LENGTH_SHORT).show();
    }
    
    private void displayFormActivity(){
        Intent intent= new Intent(this,formActivity.class);
        startActivity(intent);
    }

}
