package net.bitacademy.java72.util;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class MultipartDataProcessor {
  
  public static Map<String,String> toParamMap(
        String uploadDir,
        HttpServletRequest request) throws Exception {
    DiskFileItemFactory itemFactory = new DiskFileItemFactory();
    ServletFileUpload upload = new ServletFileUpload(itemFactory);
    
    HashMap<String,String> paramMap = new HashMap<String,String>();
    List<FileItem> items = upload.parseRequest(request);
    for (FileItem item : items) {
      if (item.isFormField()) {
        paramMap.put(
            item.getFieldName(), 
            item.getString("UTF-8"));
      } else {
        item.write(new File(
            request.getServletContext().getRealPath(uploadDir)
            + "/" + item.getName()));
        paramMap.put(
            item.getFieldName(), 
            item.getName());
      }
    }
    
    return paramMap;
  }
}









