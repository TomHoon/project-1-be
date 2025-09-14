package com.project1.hy.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;


public class FileUtil {
  
  private static final String UPLOAD_DIR = "uploads";


  /**
   * Saving files
    Generating unique names
    Returning metadata: URL, original name, size
    Deleting files
    File type validation
    File size limit check
    Directory creation
    Possibly moving or copying files
   * 
   */
  public static String saveFile(MultipartFile file) {
    // 비어있는지 체크
    if (file.isEmpty())
    return null;

    // 경로없으면 생성
    File uploadDir = new File(UPLOAD_DIR);
    if (!uploadDir.exists())
    uploadDir.mkdirs();

    // 중복 안되도록 prefix 추가
    String fileName = UUID.randomUUID().toString().substring(0,5) + file.getOriginalFilename();

    // Path 미리 생성
    Path path = Paths.get(UPLOAD_DIR, fileName);

    // Files.copy로 넣어주기 (덮어쓰기 옵션 추가)
    try {
      Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return fileName;
  }
  
  private static boolean deleteFile(String filename) {
    Path filePath = Paths.get(UPLOAD_DIR, filename);
    return Files.exists(filePath) && filePath.toFile().delete();
  }
}
