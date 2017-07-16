/*
 * Copyright (C) 2017 Clivern. <https://clivern.com>
 */
package com.clivern.racter.receivers.webhook;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONArray;
import java.lang.*;

/**
 * Message Webhook
 */
public class MessageReceivedWebhook {

    private String user_id;
    private String page_id;
    private Long timestamp;
    private String message_id;
    private String message_text;
    private String quick_reply_payload;
    private Map<String, String> attachments = new HashMap<String, String>();
    private static MessageReceivedWebhook instance;

    /**
     * Constructor
     */
    protected MessageReceivedWebhook() { }

    /**
     * Get Instance
     *
     * @return MessageReceivedWebhook
     */
    public static MessageReceivedWebhook getInstance() {
        if(instance == null) {
            instance = new MessageReceivedWebhook();
        }
        return instance;
    }

    public void setUserId(String user_id)
    {
        this.user_id = user_id;
    }

    public void setPageId(String page_id)
    {
        this.page_id = page_id;
    }

    public void setTimestamp(Long timestamp)
    {
        this.timestamp = timestamp;
    }

    public void setMessageId(String message_id)
    {
        this.message_id = message_id;
    }

    public void setMessageText(String message_text)
    {
        this.message_text = message_text;
    }

    public void setQuickReplyPayload(String quick_reply_payload)
    {
        this.quick_reply_payload = quick_reply_payload;
    }

    public void setAttachment(String type, String payload)
    {
        attachments.put(type, payload);
    }

    public void setAttachment(String type, Long loc_lat, Long loc_long)
    {
        attachments.put(type, Long.toString(loc_lat) + "," + Long.toString(loc_long));
    }

    public Boolean hasUserId()
    {
        return (this.user_id != null);
    }

    public Boolean hasPageId()
    {
        return (this.page_id != null);
    }

    public Boolean hasTimestamp()
    {
        return (this.timestamp != null);
    }

    public Boolean hasMessageId()
    {
        return (this.message_id != null);
    }

    public Boolean hasMessageText()
    {
        return (this.message_text != null);
    }

    public Boolean hasQuickReplyPayload()
    {
        return (this.quick_reply_payload != null);
    }

    public Boolean hasAttachment()
    {
        return !this.attachments.isEmpty();
    }

    public String getUserId()
    {
        return this.user_id;
    }

    public String getPageId()
    {
        return this.page_id;
    }

    public Long getTimestamp()
    {
        return this.timestamp;
    }

    public String getMessageId()
    {
        return this.message_id;
    }

    public String getMessageText()
    {
        return this.message_text;
    }

    public String getQuickReplyPayload()
    {
        return this.quick_reply_payload;
    }

    public Map<String, String> getAttachment()
    {
        return this.attachments;
    }
}