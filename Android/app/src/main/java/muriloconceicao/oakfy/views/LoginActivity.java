package muriloconceicao.oakfy.views;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import muriloconceicao.oakfy.R;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.edtTxtEmail) EditText edtTxtEmail;
    @BindView(R.id.edtTxtPassword) EditText edtTxtPassword;
    @BindView(R.id.txtViewSignUp) TextView txtViewSignUp;

    @OnClick(R.id.btnSignIn)
    public void onBtnSignInClick() {
        loginRequest();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    private void loginRequest() {
    }

}