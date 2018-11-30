package APIs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public GetAPI getAPI()
    {
        return new GetAPI();
    }

    @Bean
    public PostAPI postAPI()
    {
        return new PostAPI();
    }

    @Bean
    public PutAPI putAPI()
    {
        return new PutAPI();
    }
}
