package muriloconceicao.oakfy.presenters;

public class SignUpActivityPresenter {
    private SignUpView signUpView;

    public SignUpActivityPresenter(SignUpView signUpView) {
        this.signUpView = signUpView;
    }

    public SignUpView detach() {
        return signUpView = null;
    }

    public interface SignUpView {
        void showErrorMessage();
    }

}