package com.project.oldCare.service;

public interface PraiseService {


    void praise(String sourceTable, String sourceField, Integer sourceId);

    Integer praise_len(String sourceTable, String sourceField, Integer sourceId);
}
