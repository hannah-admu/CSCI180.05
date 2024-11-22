package app.components;

import java.io.IOException;
import java.util.Base64;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import app.dto.TwilioReplyDTO;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class TwilioComponent {
	
	private String creds = "";
	private String msgsid = "";
	private String url = "";
	
	private Retrofit retrofit;
	private TwilioRequests r;

	private	byte[] encodedAuth= Base64.getEncoder().encode(creds.getBytes());
	private final String authorization = "Basic " + new String(encodedAuth);
	
	public TwilioReplyDTO sendQuote(String cellNumber, String quoteMessage) throws IOException {
		r = retrofit.create(TwilioRequests.class);
		Call<TwilioReplyDTO> call = r.testSMS(
				cellNumber,
				msgsid,
				quoteMessage,
				authorization,
				url);
		Response<TwilioReplyDTO> resp = call.execute();
		return resp.body();
	}
	
	@PostConstruct
	public void twilioInterfaceInit() {
		retrofit = new Retrofit.Builder()
	               .baseUrl("https://bogus")
	               .addConverterFactory(GsonConverterFactory.create())
	               .build();
	}

}
