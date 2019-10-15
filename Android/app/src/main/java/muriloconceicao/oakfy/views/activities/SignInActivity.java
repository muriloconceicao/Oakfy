package muriloconceicao.oakfy.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import muriloconceicao.oakfy.R;
import muriloconceicao.oakfy.presenters.SignInPresenter;
import muriloconceicao.oakfy.presenters.SignInPresenterImpl;
import muriloconceicao.oakfy.utils.Utils;
import muriloconceicao.oakfy.views.SignInView;

public class SignInActivity extends AppCompatActivity implements SignInView {
    private SignInPresenter signInPresenter;

    @BindView(R.id.edtTxtEmail) EditText edtTxtEmail;
    @BindView(R.id.edtTxtPassword) EditText edtTxtPassword;

    @OnClick(R.id.btnSignIn)
    public void onBtnSignInClick() {
        String email = edtTxtEmail.getText().toString().trim();
        String password = edtTxtPassword.getText().toString().trim();
        signInPresenter.login(email, password);
    }

    @OnClick(R.id.txtViewSignUp)
    public void onTxtViewSignUpClick() {
        startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
        signInPresenter = new SignInPresenterImpl();
        signInPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        signInPresenter.dettachView();
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Utils.showToastMessage(this, errorMessage);
    }

    @Override
    public void showLoginSuccess() {
        Utils.showToastMessage(this, "Logado com Sucesso!");

    }

    @Override
    public void showLoginError() {
        Utils.showToastMessage(this, "Erro ao efetuar Login!");

    }

    @Override
    public Context getContext() {
        return this;
    }
}