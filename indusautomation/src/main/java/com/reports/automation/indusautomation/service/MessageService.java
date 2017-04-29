package com.reports.automation.indusautomation.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.reports.automation.indusautomation.database.DatabaseClass;
import com.reports.automation.indusautomation.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService (){
		messages.put(1l, new Message(1,"ravi", "kondeti"));
		messages.put(2l, new Message(2,"sowmya", "kondeti"));
	}	
	
	public List<Message> getMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getMessagesByYear(int year){
		List<Message> messageForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()){
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) ==year){
				messageForYear.add(message);
			}
		}
		return messageForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if(start+size >list.size()){
			return new ArrayList<Message>();
		}
		return list.subList(start, start+size);
		
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
		
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <=0){
			return null;
		}

		messages.put(message.getId(),message);
		return message;		
	}
	
	public Message delete(long id){
		return messages.remove(id);
	}
	
	
//	public List<Message> getAllMessages(){
//	Message msg1 = new Message(1l,"ravi","kondeti");
//	Message msg2 = new Message(2l,"Sowmya","Kondeti");
//	Message msg3 = new Message(3l,"Manasvi","Kondeti");
//	List<Message> msgList = new ArrayList<>();
//	msgList.add(msg1);
//	msgList.add(msg2);
//	msgList.add(msg3);
//	return msgList;
//	}
}
