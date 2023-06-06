package learning.spring.helloworld;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theokanning.openai.OpenAiApi;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import okhttp3.OkHttpClient;
//import retrofit2.Retrofit;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.time.Duration;

import static com.theokanning.openai.service.OpenAiService.*;

public class ChatGPT3 {

    public static void main(String[] args) {


        // System.getenv("OPENAI_TOKEN");
        String token = "sk-0ywi";

        OpenAiService service = new OpenAiService(token);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("You are a Front-end development specialist. Now you are working on a project that requires you to build a web page that allows users to chat with a robot.")
                .temperature(0.5)
                .maxTokens(2048)
                .topP(1D)
                .frequencyPenalty(0D)
                .presencePenalty(0D)
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);

//        使用代理
//        ObjectMapper mapper = defaultObjectMapper();
//        String host = "";
//        int port = 9876;
//        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, port));
//        Duration timeout = Duration.ofMinutes(60);
//        OkHttpClient client = defaultClient(token, timeout)
//                .newBuilder()
//                .proxy(proxy)
//                .build();
//        Retrofit retrofit = defaultRetrofit(client, mapper);
//        OpenAiApi api = retrofit.create(OpenAiApi.class);
//        OpenAiService service = new OpenAiService(api);
    }


}
