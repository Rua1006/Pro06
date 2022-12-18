package com.shop2.myapp.dto;

import lombok.Data;

@Data
public class NoticeDTO {
   private int notiNo;
   private String title;
   private String content;
   private String author;
   private String resdate;
}
