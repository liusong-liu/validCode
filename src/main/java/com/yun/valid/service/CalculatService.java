package com.yun.valid.service;

import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

public interface CalculatService {

    BufferedImage getImage(HttpServletResponse response) throws Exception;
}
