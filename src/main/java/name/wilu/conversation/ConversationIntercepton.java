package name.wilu.conversation;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ConversationIntercepton<T> extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        if (actionInvocation.getAction() instanceof ConversationAware) {
            ActionContext ctx = actionInvocation.getInvocationContext();
            Map<String, T> map = assureConversation(ctx);
            String id = assureConversationId(ctx);
            assureModel(ctx, map, id);
            String result = actionInvocation.invoke();
            assureConversationEnd(ctx, map, id);
            return result;
        } else return actionInvocation.invoke();
    }

    private void assureConversationEnd(ActionContext ctx, Map<String, T> map, String id) {
        if (((ConversationAware) ctx.getActionInvocation()).isConversationFinished()) {
            map.remove(id);
        }
    }

    private void assureModel(ActionContext ctx, Map<String, T> map, String id) {
        T model = map.get(id);
        ConversationAware<T> action = (ConversationAware<T>) ctx.getActionInvocation();
        if (model == null) {
            map.put(id, action.getConversationModel());
        } else action.setConversationModel(model);
        ctx.getValueStack().push(model);
    }

    private String assureConversationId(ActionContext ctx) {
        Object id = ctx.getParameters().get(ConversationAware.CONVERSATION_ID);
        if (id == null || StringUtils.isBlank((String) id)) {
            String newId = UUID.randomUUID().toString();
            ((ConversationAware<?>) ctx.getActionInvocation()).setConversationId(newId);
            return newId;
        }
        return (String) id;
    }

    private Map<String, T> assureConversation(ActionContext ctx) {
        Object map = ctx.getSession().get(ConversationAware.CONVERSATION_MODE);
        if (map == null) {
            HashMap<String, T> newMap = new HashMap<String, T>();
            ctx.getSession().put(ConversationAware.CONVERSATION_MODE, newMap);
            return newMap;
        }
        return (Map<String, T>) map;
    }
}