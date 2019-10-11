package muriloconceicao.oakfy.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import muriloconceicao.oakfy.R;
import muriloconceicao.oakfy.presenters.LoginActivityPresenter;

public class LoginActivity extends AppCompatActivity implements LoginActivityPresenter.LoginView {
    private FirebaseAuth firebaseAuth;
    private LoginActivityPresenter loginActivityPresenter;

    @BindView(R.id.edtTxtEmail) EditText edtTxtEmail;
    @BindView(R.id.edtTxtPassword) EditText edtTxtPassword;
    @BindView(R.id.txtViewSignUp) TextView txtViewSignUp;

    @OnClick(R.id.btnSignIn)
    public void onBtnSignInClick() {
        checkLoginEditTexts();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginActivityPresenter.detach();
    }

    private void checkLoginEditTexts() {
        String userEmail = edtTxtEmail.getText().toString();
        String userPassword = edtTxtPassword.getText().toString();

        if(userEmail.length() <= 0 || userPassword.length() <= 0)
            showErrorMessage();
        else
            loginRequest(userEmail, userPassword);
    }

    private void loginRequest(String userEmail, String userPassword) {
        firebaseAuth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                } else {
                    showErrorMessage();
                }
            }
        });
    }


    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "Erro ao efetuar Login", Toast.LENGTH_SHORT).show();
    }
}