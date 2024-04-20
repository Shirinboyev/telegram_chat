package backend.service.chatService;

import backend.model.chat.Chat;
import backend.model.user.User;
import backend.service.userService.UserService;

import java.util.ArrayList;
import java.util.List;

public class ChatServiceImp implements ChatService {

    private static ChatService chatService;
    private List<Chat> chat;

    public ChatServiceImp() {

        this.chat = new ArrayList<> ();
    }

    public static ChatService getInstance() {
        if (chatService == null) {
            chatService = new ChatServiceImp();
        }

        return chatService;
    }

    @Override
    public List<Chat> getChatsOfUser(String userId) {
        return List.of ( );
    }

    @Override
    public Chat getChatOfUser(String userId) {
        return null;
    }

    @Override
    public boolean Exist(String userId) {
        return false;
    }

    @Override
    public boolean add(Chat o) {
        return false;
    }

    @Override
    public boolean delete(Chat chat) {
        return false;
    }

    @Override
    public Chat get(String id) {
        for (Chat chat1 : chat) {
            if (chat1.getId ().equals(id)) {

                return chat1;
            }
        }
        return null;
    }

    @Override
    public List<Chat> getList() {
        return List.of ( );
    }
}
