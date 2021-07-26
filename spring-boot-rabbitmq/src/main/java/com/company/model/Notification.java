package com.company.model;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Notification implements Serializable {

     private String notificationId;
     private Date createdAt;
     private Boolean seen;
     private String message;


}
