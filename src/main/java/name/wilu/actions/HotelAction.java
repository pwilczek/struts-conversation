package name.wilu.actions;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import name.wilu.conversation.ConversationAware;
import name.wilu.model.Network;
import name.wilu.service.HotelService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Action(value = "conversation")
@Result(location = "conversation.jsp")
public class HotelAction extends ActionSupport implements ModelDriven<Network>, ConversationAware<Network> {

    private final HotelService service = new HotelService();
    private Network network;

    public Network getModel() {
        if (network == null) network = service.readNetwork();
        return network;
    }

    public String addRow() {
        System.out.println("addRow()");
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("execute()");
        return super.execute();
    }

    public String getConversationId() {
        return null;
    }

    public void setConversationId(String id) {

    }

    public Network getConversationModel() {
        return null;
    }

    public void setConversationModel(Network model) {

    }

    public boolean isConversationFinished() {
        return false;
    }
}
