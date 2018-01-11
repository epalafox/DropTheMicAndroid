package epalafox.com.curso;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import epalafox.com.curso.Models.SessionModel;
import epalafox.com.curso.WebService.WebServiceClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {
    Button iniciar;
    Button registrar;
    EditText user;
    EditText password;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("user", Context.MODE_PRIVATE);
        if(sp.getInt("IdUser", 0) != 0)
        {
            Intent i = new Intent(MainActivity.this,DashboardActivity.class);
            startActivity(i);
            finish();
        }

        iniciar = (Button) findViewById(R.id.log);
        registrar = (Button) findViewById(R.id.registrar);
        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<SessionModel> call = WebServiceClient.getApi().login(user.getText().toString(), password.getText().toString());
                call.enqueue(new Callback<SessionModel>() {
                    @Override
                    public void onResponse(Call<SessionModel> call, Response<SessionModel> response) {

                        editor = sp.edit();
                        editor.putInt("IdUser", response.body().getIdUser());
                        editor.putString("WebToken", response.body().getWebToken());
                        editor.apply();

                        Intent i = new Intent(MainActivity.this,DashboardActivity.class);
                        startActivity(i);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<SessionModel> call, Throwable t) {
                        Toast toast = Toast.makeText(MainActivity.this,"Usuario no encontrado",Toast.LENGTH_LONG);
                        toast.show();
                    }
                });
            }
        });
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}
