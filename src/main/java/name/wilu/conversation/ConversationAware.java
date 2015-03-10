package name.wilu.conversation;

public interface ConversationAware<T> {
    //
    static final String CONVERSATION_MODE = "CONVERSATION_MODE";
    static final String CONVERSATION_ID = "CONVERSATION_ID";
    //
    public String getConversationId();
    public void setConversationId(String id);
    public T getConversationModel();
    public void setConversationModel(T model);
    public boolean isConversationFinished();
}
