package com.stragegic.web.controller;

/**
 * 消息策略
 */
public enum UserMessageEnum {
    /**
     * 交易消息
     */
    TRANSCATIONMESSAGE("transactionMessage"),
    /**
     * 系统消息
     */
    SYSTEMMESSAGE("systemMessage");
    private String value;

    UserMessageEnum(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
