package com.project1.hy.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project1.hy.utils.FileUtil;

@RestController
@RequestMapping("/api/v1/image")
public class ImageController {

  @PostMapping("/uploadImage")
  public String uploadImage(@RequestParam("file") MultipartFile file) {
    String filename = FileUtil.saveFile(file);

    return filename;
  }
}
