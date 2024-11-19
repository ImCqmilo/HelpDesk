package co.uceva.edu.base.beans;

import co.uceva.edu.base.models.Menu;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class HomeBean {

    private String welcome = "Bienvenido";
    private List<Menu> menuList;

    public HomeBean() {
        this.menuList = new ArrayList<>();
        this.menuList.add( new Menu(1,"Usuarios","/proyecto-base-1.0/faces/listar-usuario.xhtml") );
    }

    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }


}
