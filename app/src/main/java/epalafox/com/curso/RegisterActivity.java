package epalafox.com.curso;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import epalafox.com.curso.Models.UserModel;
import epalafox.com.curso.WebService.WebServiceClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends Activity {
    EditText user;
    EditText password;
    EditText birthday;
    Spinner gender;
    Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        user= (EditText) findViewById(R.id.user);
        password= (EditText) findViewById(R.id.password);
        birthday= (EditText) findViewById(R.id.birthday);
        gender= (Spinner) findViewById(R.id.gender);
        registrar = (Button) findViewById(R.id.sendRegister);

        List<String> list = new ArrayList<String>();
        list.add("Hombre");
        list.add("Mujer");
        list.add("Indefinido");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        gender.setAdapter(dataAdapter);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel newUser = new UserModel();

                newUser.setUserName(user.getText().toString());
                newUser.setPassword(password.getText().toString());
                newUser.setGender(gender.getSelectedItemPosition() + 1);
                newUser.setBirthday(birthday.getText().toString());

                Call<Void> call = WebServiceClient.getApi().postUser(newUser);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast toast = Toast.makeText(RegisterActivity.this,"Fallo conexión",Toast.LENGTH_LONG);
                        toast.show();
                    }
                });
            }
        });
    }
}
