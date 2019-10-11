package muriloconceicao.oakfy.presenters;

public class LoginActivityPresenter {
    private LoginView loginView;

    public LoginActivityPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public interface LoginView {
        void showErrorMessage();

    }
}
