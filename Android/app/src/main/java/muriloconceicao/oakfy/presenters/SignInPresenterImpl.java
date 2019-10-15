package muriloconceicao.oakfy.presenters;

import android.text.TextUtils;
import com.google.firebase.auth.FirebaseAuth;
import muriloconceicao.oakfy.views.SignInView;

public class SignInPresenterImpl implements SignInPresenter {
    private  SignInView signInView;

    @Override
    public void login(String email, String password) {
        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            signInView.showErrorMessage("Email e Senha não podem ser vazios.");
        }
        else {
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if(task.isSuccessful())
                    signInView.showLoginSuccess();
                else
                    signInView.showLoginError();
            });
        }

    }

    @Override
    public void attachView(SignInView view) {
        signInView = view;
    }

    @Override
    public void dettachView() {
        signInView = null;
    }
}