package backend.service.chatService;

import backend.dto.LoginDto;
import backend.model.chat.Chat;
import backend.model.user.User;
import backend.service.userService.UserService;

import java.util.ArrayList;
import java.util.List;

public class ChatServiceImp implements ChatService {

    private List<Chat> chat;

    public ChatServiceImp(List<Chat> chat) {
        this.chat = new ArrayList<> ();
    }

    @Override
    public List<Chat> getChatsOfUser(String userId) {
        return List.of ( );
    }

    @Override
    public Chat getChatOfUser(String userId) {
        List<Chat> chatsOfUser = new ArrayList<>();
        for (Chat chat : chat) {
            if (chat.getFirstUserId().equals(userId) || chat.getSecondUserId().equals(userId)) {
                chatsOfUser.add(chat);
            }
        }
        return (Chat) chatsOfUser;

    }

    @Override
    public boolean Exist(String userId) {
        return false;
    }

    @Override
    public boolean add(Chat chats) {
        return chat.add(chats);
    }

    @Override
    public boolean delete(Chat chat1) {
        return chat.remove (chat1);
    }

    @Override
    public Chat get(String id) {
         for (Chat chat1:chat){
             if (chat1.getId ().equals (id)){
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
