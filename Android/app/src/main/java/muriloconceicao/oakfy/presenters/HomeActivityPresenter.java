package muriloconceicao.oakfy.presenters;

import muriloconceicao.oakfy.models.Acai;
import muriloconceicao.oakfy.models.Demand;
import muriloconceicao.oakfy.models.User;

public class HomeActivityPresenter {
    private Demand demand;
    private Acai acai;
    private User user;
    private HomeView homeView;

    public HomeActivityPresenter(HomeView view) {
        this.demand = new Demand();
        this.acai = new Acai();
        this.user = new User();
        this.homeView = view;
    }

    public HomeView detach() {
        return homeView = null;
    }

    public interface HomeView {
        void showErrorMessage();
    }

}