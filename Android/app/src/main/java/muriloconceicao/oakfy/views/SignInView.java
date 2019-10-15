package muriloconceicao.oakfy.views;

import muriloconceicao.oakfy.bases.BaseView;

public interface SignInView extends BaseView {
    void showErrorMessage(String errorMessage);
    void showLoginSuccess();
    void showLoginError();
}