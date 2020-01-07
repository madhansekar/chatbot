package com.ey.poc.common.util;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Component
public class JsonResponseBody {

	@Override
	public String toString() {
		return "JsonResponseBody [jsonResponseNode=" + jsonResponseNode + ", status=" + status + ", messages="
				+ messages + ", data=" + data + ", statusCode=" + statusCode + "]";
	}

	private ObjectNode jsonResponseNode = null;
	private boolean status = false;
	private boolean mailStatus=false;
	private ArrayNode messages = null;
	private ObjectNode data = null;
	private int statusCode = 500; //500 - Internal server error, 200 - ok (success)

	public JsonResponseBody() {
		this.jsonResponseNode = JsonNodeFactory.instance.objectNode();
		this.data = JsonNodeFactory.instance.objectNode();
		this.messages = JsonNodeFactory.instance.arrayNode();
		this.status = false;
		this.mailStatus=false;
		this.statusCode = 500;
	}

	public JsonResponseBody(ObjectNode inData, ArrayNode inMessages, boolean inStatus, int inStatusCode,boolean inMailStatus) {
		this.jsonResponseNode = JsonNodeFactory.instance.objectNode();
		this.data = inData;
		this.messages = inMessages;
		this.status = inStatus;
		this.statusCode = inStatusCode;
		this.mailStatus=inMailStatus;
	}

	public void addMessage(String inMessage) {
		this.messages.add(inMessage);
	}

	public void addData(String inKey, Object inValue) {

		JsonNode node = new ObjectMapper().valueToTree(inValue);
		this.data.set(inKey, node);
	}

	public void addData(String inKey, JsonNode inValue) {
		this.data.set(inKey, inValue);
	}

	public void addData(String inKey, String inValue) {
		this.data.put(inKey, inValue);
	}

	public void addData(String inKey, float inValue) {
		this.data.put(inKey, inValue);
	}

	public void addData(String inKey, double inValue) {
		this.data.put(inKey, inValue);
	}

	public void addData(String inKey, int inValue) {
		this.data.put(inKey, inValue);
	}

//	public int getStatusCode() {
//		return statusCode;
//	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public ObjectNode getJsonResponseNode() {

		jsonResponseNode.put("status", this.status);
		jsonResponseNode.put("mailStatus", this.mailStatus);
		jsonResponseNode.put("statusCode", this.statusCode);
		jsonResponseNode.set("messages", this.messages);
		jsonResponseNode.set("data", this.data);

		return jsonResponseNode;
	}

	public void setJsonResponseNode(ObjectNode jsonResponseNode) {
		this.jsonResponseNode = jsonResponseNode;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ArrayNode getMessages() {
		return messages;
	}

	public void setMessages(ArrayNode messages) {
		this.messages = messages;
	}

	public ArrayNode getArrayNode() {

		return JsonNodeFactory.instance.arrayNode();
	}

	public ObjectNode getObjectNode() {

		return JsonNodeFactory.instance.objectNode();
	}

	public boolean isMailStatus() {
		return mailStatus;
	}

	public void setMailStatus(boolean mailStatus) {
		this.mailStatus = mailStatus;
	}
	
}
