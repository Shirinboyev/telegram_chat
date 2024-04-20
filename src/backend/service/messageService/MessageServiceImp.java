package backend.service.messageService;

public class MessageServiceImp implements MessageService{
    private static MessageService messageService;

    public static MessageService getInstance() {
        if (messageService == null) {
            messageService = new MessageServiceImp();
        }

        return messageService;
    }
}
