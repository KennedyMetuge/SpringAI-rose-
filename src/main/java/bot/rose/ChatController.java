 //Java id="9ez6hg"

package bot.rose;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    private final ChatService chatService;
    public ChatController(ChatService chatService){
        this.chatService=chatService;
    }
    @GetMapping("/chat")
    public String chat(String msg, String user){
        return
    chatService.getResponse(msg,user);
    }

}
