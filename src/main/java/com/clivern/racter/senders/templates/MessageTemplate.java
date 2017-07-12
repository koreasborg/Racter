/*
 * Copyright (C) 2017 Clivern. <https://clivern.com>
 */
package com.clivern.racter.senders.templates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 * Text Message Template
 */
public class MessageTemplate {

    private String recipient_id;
    private String message_text;
    private Map<String, String> message_attachment = new HashMap<String, String>();
    private ArrayList<HashMap<String, String>> message_quick_replies = new ArrayList<HashMap<String, String>>();
    private String message_metadata;
    private String sender_action;
    private String notification_type;
    private String message_string;

    public void setRecipientId(String recipient_id){
        this.recipient_id = recipient_id;
    }

    public void setMessageText(String message_text){
        this.message_text = message_text;
    }

    public void setMessageMetadata(String message_metadata){
        this.message_metadata = message_metadata;
    }

    public void setSenderAction(String sender_action){
        this.sender_action = sender_action;
    }

    public void setNotificationType(String notification_type){
        this.notification_type = notification_type;
    }

    public void setAttachment(String type, String url, Boolean is_reusable)
    {
        this.message_attachment.put("type", type);
        this.message_attachment.put("url", url);
        this.message_attachment.put("is_reusable", String.valueOf(is_reusable));
    }

    public void setQuickReply(String content_type, String title, String payload, String image_url)
    {
        HashMap<String, String> quick_reply = new HashMap<String, String>();
        quick_reply.put("content_type", content_type);
        quick_reply.put("title", title);
        quick_reply.put("payload", payload);
        quick_reply.put("image_url", image_url);
        this.message_quick_replies.add(quick_reply);
    }

    public String getRecipientId(){
        return this.recipient_id;
    }

    public String getMessageText(){
        return this.message_text;
    }

    public String getMessageMetadata(){
        return this.message_metadata;
    }

    public String getSenderAction(){
        return this.sender_action;
    }

    public String getNotificationType(){
        return this.notification_type;
    }

    public Map<String, String> getAttachment()
    {
        return this.message_attachment;
    }

    public ArrayList<HashMap<String, String>> getQuickReply()
    {
        return this.message_quick_replies;
    }

    public String build()
    {
        this.message_string  = "{";

        if( this.recipient_id != null ){
            this.message_string += "\"recipient\": {\"id\": \"" + this.recipient_id + "\"},";
        }

        if( ( this.message_text != null ) || ( !this.message_attachment.isEmpty() ) || ( !this.message_quick_replies.isEmpty() ) || ( this.message_metadata != null ) ){

            this.message_string += "\"message\": {";

            if( this.message_text != null ){
                this.message_string += "\"text\": \"" + this.message_text + "\",";
            }

            if( !this.message_attachment.isEmpty() ){
                this.message_string += "\"attachment\":{\"type\":\"" + this.message_attachment.get("type") + "\",\"payload\":{\"url\":\"" + this.message_attachment.get("url") + "\",\"is_reusable\": " + this.message_attachment.get("is_reusable") + "}},";
            }

            if( !this.message_quick_replies.isEmpty() ){
                this.message_string += "\"quick_replies\":[";
                for ( int j = 0 ; j < this.message_quick_replies.size(); j++ ) {
                    HashMap<String, String> quick_reply = this.message_quick_replies.get(j);

                    this.message_string += "{";
                    if( !quick_reply.get("content_type").equals("") ){
                        this.message_string += "\"content_type\":\"" + quick_reply.get("content_type") + "\",";
                    }
                    if( !quick_reply.get("title").equals("") ){
                        this.message_string += "\"title\":\"" + quick_reply.get("title") + "\",";
                    }
                    if( !quick_reply.get("payload").equals("") ){
                        this.message_string += "\"payload\":\"" + quick_reply.get("payload") + "\",";
                    }
                    if( !quick_reply.get("image_url").equals("") ){
                        this.message_string += "\"image_url\":\"" + quick_reply.get("image_url") + "\",";
                    }
                    this.message_string = this.message_string.replaceAll(",$", "");
                    this.message_string += "},";

                }
                this.message_string = this.message_string.replaceAll(",$", "");
                this.message_string += "],";
            }


            if( this.message_metadata != null ){
                this.message_string += "\"metadata\": \"" + this.message_metadata + "\",";
            }
            this.message_string = this.message_string.replaceAll(",$", "");
            this.message_string += "},";
        }

        if( this.sender_action != null ){
            this.message_string += "\"sender_action\":\"" + this.sender_action + "\",";
        }
        if( this.notification_type != null ){
            this.message_string += "\"notification_type\":\"" + this.notification_type + "\",";
        }

        this.message_string = this.message_string.replaceAll(",$", "");

        this.message_string += "}";

        return this.message_string;
    }

    public void setMessageString(String message_string)
    {
        this.message_string = message_string;
    }

    public String getMessageString()
    {
        return this.message_string;
    }
}