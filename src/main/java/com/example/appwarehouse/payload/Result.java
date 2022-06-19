package com.example.appwarehouse.payload;

import com.example.appwarehouse.Entity.Attachment;
import com.example.appwarehouse.Entity.AttachmentContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private String message;
    private boolean success;
    private Object object;

    private List<Attachment> attachment;
    private List<AttachmentContent> attachmentContent;

    public Result(String message, boolean success, List<Attachment> attachment, List<AttachmentContent> attachmentContent) {
        this.message = message;
        this.success = success;
        this.attachment = attachment;
        this.attachmentContent = attachmentContent;
    }

    public Result(String message, boolean success, Object object) {
        this.message = message;
        this.success = success;
        this.object = object;
    }

    public Result(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

}
