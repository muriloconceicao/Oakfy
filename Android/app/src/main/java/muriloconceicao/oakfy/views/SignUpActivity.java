package muriloconceicao.oakfy.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import muriloconceicao.oakfy.R;
import muriloconceicao.oakfy.presenters.SignUpActivityPresenter;

public class SignUpActivity extends AppCompatActivity implements SignUpActivityPresenter.SignUpView {
    private FirebaseAuth firebaseAuth;
    @BindView(R.id.edtTxtEmail) EditText edtTxtEmail;
    @BindView(R.id.edtTxtPassword) EditText edtTxtPassword;

    @OnClick(R.id.btnSignUp)
    public void onBtnSignUp() {
        checkLoginEditTexts();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firebaseAuth = FirebaseAuth.getInstance();
        ButterKnife.bind(this);
    }

    private void checkLoginEditTexts() {
        String userEmail = edtTxtEmail.getText().toString();
        String userPassword = edtTxtPassword.getText().toString();

        if(userEmail.length() <= 0 || userPassword.length() <= 0)
            showErrorMessage();
        else
            signUpRequest(userEmail, userPassword);
    }

    private void signUpRequest(String userEmail, String userPassword) {
        firebaseAuth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnSuccessListener(authResult -> startActivity(new Intent(SignUpActivity.this, HomeActivity.class)))
                .addOnFailureListener(e -> showErrorMessage());
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "Erro ao registrar usuário.", Toast.LENGTH_SHORT).show();
    }
}