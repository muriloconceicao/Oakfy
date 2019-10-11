package muriloconceicao.oakfy.views;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import muriloconceicao.oakfy.R;
import muriloconceicao.oakfy.presenters.SignInActivityPresenter;

public class SignInActivity extends AppCompatActivity implements SignInActivityPresenter.SignInView {
    private FirebaseAuth firebaseAuth;
    @BindView(R.id.edtTxtEmail) EditText edtTxtEmail;
    @BindView(R.id.edtTxtPassword) EditText edtTxtPassword;

    @OnClick(R.id.btnSignIn)
    public void onBtnSignInClick() {
        checkLoginEditTexts();
    }

    @OnClick(R.id.txtViewSignUp)
    public void onTxtViewSignUpClick() {
        startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        firebaseAuth = FirebaseAuth.getInstance();
        ButterKnife.bind(this);
    }

    private void checkLoginEditTexts() {
        String userEmail = edtTxtEmail.getText().toString();
        String userPassword = edtTxtPassword.getText().toString();

        if(userEmail.length() <= 0 || userPassword.length() <= 0)
            showErrorMessage();
        else
            signInRequest(userEmail, userPassword);
    }

    private void signInRequest(String userEmail, String userPassword) {
        firebaseAuth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(task -> {
            if(task.isSuccessful()) {
                startActivity(new Intent(SignInActivity.this, HomeActivity.class));
            } else {
                showErrorMessage();
            }
        });
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "Erro ao efetuar Login", Toast.LENGTH_SHORT).show();
    }
}