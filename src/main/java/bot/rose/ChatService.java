package bot.rose;
import netscape.javascript.JSObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.json.JSONObject;

@Service
public class ChatService {
    private RestTemplate restTemplate = new RestTemplate();
    public String getResponse(String msg, String user){
        String url = "http://localhost:11434/api/generate";
        String requestJson = "{"+ "\"model\": \"llama3.2:3b\", "+"\"prompt\": \""+ msg + "\","+ "\"stream\": false"+"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(requestJson, headers);
        String response = restTemplate.postForObject(url, request, String.class);
        JSONObject json = new JSONObject(response);
      return json.getString("response");
    }


}

