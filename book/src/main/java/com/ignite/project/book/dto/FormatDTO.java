package com.ignite.project.book.dto;
/**
  FormatDTO

 * This Data Transfer Object (DTO) represents the download formats available
 * for a specific book. It includes the MIME type and the corresponding URL link.
 
  Key Features:
 *  - Contains lightweight format data (mimeType and URL).
 *  - Used inside BookDTO to display all available download links.
 *  - Keeps response structure simple and readable.
 
 * Author: Siddharth Kardile
 */
public class FormatDTO {
    private String mimeType;
    private String url;

    public FormatDTO() {}

    public FormatDTO(String mimeType, String url) {
        this.mimeType = mimeType;
        this.url = url;
    }

    public String getMimeType() { return mimeType; }
    public void setMimeType(String mimeType) { this.mimeType = mimeType; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}
