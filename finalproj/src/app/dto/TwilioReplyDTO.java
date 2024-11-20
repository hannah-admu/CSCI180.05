package app.dto;

import java.util.Map;

public class TwilioReplyDTO {
	
	String account_sid;
	String api_version;
	String body;
	String date_created;
	String date_sent;
	String date_updated;
	String direction;
	String error_code;
	String error_message;
	String from;
	String messaging_service_sid;
	String num_media;
	String num_segments;
	String price;
	String price_unit;
	String sid;
	String status;
	Map<String, Object> subresource_uris;
	String to;
	String uri;
	
	public String getAccount_sid() {
		return account_sid;
	}
	
	public void setAccount_sid(String account_sid) {
		this.account_sid = account_sid;
	}
	
	public String getApi_version() {
		return api_version;
	}
	
	public void setApi_version(String api_version) {
		this.api_version = api_version;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getDate_created() {
		return date_created;
	}
	
	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}
	
	public String getDate_sent() {
		return date_sent;
	}
	
	public void setDate_sent(String date_sent) {
		this.date_sent = date_sent;
	}
	
	public String getDate_updated() {
		return date_updated;
	}
	
	public void setDate_updated(String date_updated) {
		this.date_updated = date_updated;
	}
	
	public String getDirection() {
		return direction;
	}
	
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public String getError_code() {
		return error_code;
	}
	
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	
	public String getError_message() {
		return error_message;
	}
	
	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
	
	public String getFrom() {
		return from;
	}
	
	public void setFrom(String from) {
		this.from = from;
	}
	
	public String getMessaging_service_sid() {
		return messaging_service_sid;
	}
	
	public void setMessaging_service_sid(String messaging_service_sid) {
		this.messaging_service_sid = messaging_service_sid;
	}
	
	public String getNum_media() {
		return num_media;
	}
	
	public void setNum_media(String num_media) {
		this.num_media = num_media;
	}
	
	public String getNum_segments() {
		return num_segments;
	}
	
	public void setNum_segments(String num_segments) {
		this.num_segments = num_segments;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getPrice_unit() {
		return price_unit;
	}
	
	public void setPrice_unit(String price_unit) {
		this.price_unit = price_unit;
	}
	
	public String getSid() {
		return sid;
	}
	
	public void setSid(String sid) {
		this.sid = sid;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Map<String, Object> getSubresource_uris() {
		return subresource_uris;
	}
	
	public void setSubresource_uris(Map<String, Object> subresource_uris) {
		this.subresource_uris = subresource_uris;
	}
	
	public String getTo() {
		return to;
	}
	
	public void setTo(String to) {
		this.to = to;
	}
	
	public String getUri() {
		return uri;
	}
	
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	@Override
	public String toString() {
		return "TwilioReply [account_sid=" + account_sid + ", api_version=" + api_version + ", body=" + body
				+ ", date_created=" + date_created + ", date_sent=" + date_sent + ", date_updated=" + date_updated
				+ ", direction=" + direction + ", error_code=" + error_code + ", error_message=" + error_message
				+ ", from=" + from + ", messaging_service_sid=" + messaging_service_sid + ", num_media=" + num_media
				+ ", num_segments=" + num_segments + ", price=" + price + ", price_unit=" + price_unit + ", sid=" + sid
				+ ", status=" + status + ", subresource_uris=" + subresource_uris + ", to=" + to + ", uri=" + uri + "]";
	}
	
}