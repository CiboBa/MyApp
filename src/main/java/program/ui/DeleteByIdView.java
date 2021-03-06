package program.ui;

import program.ui.models.View;

import static program.ui.InitialView.PRODUCT_DAO;
import static program.ui.InitialView.SCANNER;

public class DeleteByIdView implements View {

    @Override
    public void init() {
        System.out.println("Type number to delete");
        String ids = SCANNER.nextLine();

        PRODUCT_DAO.deleteMultiple(ids);
        
        View manageProductsView = new ManageProductsView();
        manageProductsView.init();
    }
}
