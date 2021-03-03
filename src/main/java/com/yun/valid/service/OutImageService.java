package com.yun.valid.service;

import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

public interface OutImageService {
    BufferedImage getImage(HttpSession httpSession);
}
