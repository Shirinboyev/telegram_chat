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
        List<Chat> chatsOfUser = new ArrayList<>();
        for (Chat chat1 : chat) {
            if (chat1.getFirstUserId().equals(userId) || chat1.getSecondUserId().equals(userId)) {
                chatsOfUser.add(chat1);
            }
        }
        return chatsOfUser;
    }

    @Override
    public Chat getChatOfUser(String userId) {
        for (Chat chats : chat) {
            if (chats.getFirstUserId().equals(userId) || chats.getSecondUserId().equals(userId)) {
                return chats;
            }
        }
        return null;
    }

    @Override
    public boolean Exist(String userId) {
        for (Chat chats : chat) {
            if (chats.getFirstUserId().equals(userId) || chats.getSecondUserId().equals(userId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(Chat ch) {
        return chat.add (ch);
    }

    @Override
    public boolean delete(Chat chat0) {
        return chat.remove(chat0);
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
        return chat;
    }
}
