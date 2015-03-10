package name.wilu.actions;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import name.wilu.model.Network;
import name.wilu.service.HotelService;
import org.apache.struts2.convention.annotation.Action;

@Action(value = "conversation")
public class HotelAction extends ActionSupport implements ModelDriven<Network> {

    private final HotelService service = new HotelService();

    public Network getModel() {
        return service.readNetwork();
    }
}
