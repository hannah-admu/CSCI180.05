package app.components;

import app.dto.TwilioReplyDTO;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface TwilioRequests {

	@POST
	@FormUrlEncoded
	public Call<TwilioReplyDTO> testSMS(@Field("To") String to, 
						  @Field("MessagingServiceSid") String messageService, 
						  @Field("Body") String body,
						  @Header("Authorization") String creds,
						  @Url String url);
	
}