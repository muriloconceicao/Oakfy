package muriloconceicao.oakfy.presenters;

public class SignInActivityPresenter {
    private SignInView signInView;

    public SignInActivityPresenter(SignInView signInView) {
        this.signInView = signInView;
    }

    public SignInView detach() {
        return signInView = null;
    }

    public interface SignInView {
        void showErrorMessage();
    }
}