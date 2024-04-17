package com.project.oldCare.entity;

import java.util.Objects;

public class ResultMessage {
    private boolean isSystem;
    private String fromName;
    private Object message;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultMessage that = (ResultMessage) o;
        return isSystem == that.isSystem && Objects.equals(fromName, that.fromName) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isSystem, fromName, message);
    }

    @Override
    public String toString() {
        return "ResultMessage{" +
                "isSystem=" + isSystem +
                ", fromName='" + fromName + '\'' +
                ", message=" + message +
                '}';
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public boolean isSystem() {
        return isSystem;
    }

    public void setSystem(boolean system) {
        isSystem = system;
    }
}
