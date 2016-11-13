package com.jdcasas.laboratorio_8_1;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private EditText usernameField,passwordField;
    private TextView status,role,method;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        usernameField = (EditText)findViewById(R.id.editText1);
        passwordField = (EditText)findViewById(R.id.editText2);
        status = (TextView)findViewById(R.id.textView8);
        role = (TextView)findViewById(R.id.textView9);
        method = (TextView)findViewById(R.id.textView7);
    }

    public void login(View view){
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        method.setText("Get Metodo");
        new SigninActivity(this,status,role,0).execute(username,password);
    }

    public void loginPost(View view){
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        method.setText("Post Metodo");
       // new JSON(this,status,role,1).execute(username,password);
        new SigninActivity(this,status,role,1).execute(username,password);
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
