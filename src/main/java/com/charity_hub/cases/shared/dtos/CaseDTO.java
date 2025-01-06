package com.charity_hub.cases.shared.dtos;

import java.util.List;

public record CaseDTO(int code,
                      String title,
                      String description,
                      int goal,
                      int collected,
                      int status,
                      boolean acceptZakat,
                      long creationDate,
                      long lastUpdated,
                      List<String> tags,
                      List<String> documents,
                      int contributions) {
}